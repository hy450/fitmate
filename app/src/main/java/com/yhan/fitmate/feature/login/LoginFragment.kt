package com.yhan.fitmate.feature.login


import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.focusChanges
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jakewharton.rxbinding2.widget.textChanges
import com.yhan.fitmate.R
import com.yhan.fitmate.core.exception.Failure
import com.yhan.fitmate.core.extension.debug
import com.yhan.fitmate.core.extension.failure
import com.yhan.fitmate.core.extension.observe
import com.yhan.fitmate.core.extension.viewModel
import com.yhan.fitmate.core.platform.BaseFragment
import com.yhan.fitmate.datamodel.CenterInfo
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_login.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : BaseFragment() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    @Inject lateinit var searchCenterResultViewModel: CenterSearchViewModel
    @Inject lateinit var loginViewModel: LoginViewModel
    private var mSeletableCenter: CenterInfo? = null

    private val centerSrchResultRecyclerAdapter by lazy {
        CenterSrchResultRecyclerAdapter(context!!) {
            mSeletableCenter = it
            searchTv.setText(it.gym_name)
            if( phone.text.toString().isEmpty()) {
                phone.requestFocus()
            }else {
                val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(searchTv.windowToken, 0)
                searchTv.clearFocus()
            }
            hideSearchView()
        }

    }

    override fun layoutId(): Int = R.layout.fragment_login

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        //appComponent.inject(this)

        searchCenterResultViewModel = viewModel(viewModelFactory) {
            observe(centers, ::renderCenterList)
            failure(failure, ::handleFail)
        }


        loginViewModel = viewModel(viewModelFactory) {
            observe(userInfo) {
                //
            }
            failure( failure, ::handleFail)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        debug("LoginFragment create")

        centerSrchResultList.adapter = centerSrchResultRecyclerAdapter
        centerSrchResultList.layoutManager = LinearLayoutManager( context, RecyclerView.VERTICAL,false)

        regBtnClickListener()
        regCenterSearchListener()
    }


    private fun regBtnClickListener() {
        // 로그인 버튼 클릭
        loginBtn.setOnClickListener {
            //todo validation check

            loginViewModel.centerAuth(mSeletableCenter!!.gym_cd!!, phone.toString())
        }
    }

    private fun renderCenterList(centers: List<CenterInfo>?) {
        debug("renderCenterList")!!
        val diffUtilCallback = CenterInfoDiffCallback(centerSrchResultRecyclerAdapter.centers, centers?:emptyList())
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        centerSrchResultRecyclerAdapter.centers.clear()
        centerSrchResultRecyclerAdapter.centers.addAll(centers?:emptyList())
        diffResult.dispatchUpdatesTo(centerSrchResultRecyclerAdapter)
    }

    private fun handleFail(failure: Failure?){
        debug("handleFail")
    }

    private fun regCenterSearchListener() {

        searchTv.focusChanges().subscribe {

            // focus 를 획득함. 새로 검색을 할려고 함. 이전에 선택한 센터 삭제
            if( it ) mSeletableCenter = null

            val keyword = searchTv.text.toString()
            if( it && keyword.isNotEmpty() ) {
                searchTv.setSelection(keyword.length)
                showSearchView()
            }else {
                hideSearchView()
            }
        }.addTo(disposables)

        searchTv.textChanges().subscribe{
            if( searchTv.text.toString().isNotEmpty()) {
                showSearchView()
            }else {
                hideSearchView()
            }
        }.addTo(disposables)

        RxTextView.textChanges(searchTv).debounce(100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .map{ it.toString() }
                .filter { it -> !it.isEmpty() }
                .distinctUntilChanged()
                .doOnNext{ searchCenterResultViewModel.loadCenterList(it,1) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe().addTo(disposables)

    }

    private fun showSearchView() {
        //termsLy.visibility = View.INVISIBLE
        //complBtn.visibility = View.INVISIBLE
        centerSrchResultList.visibility = View.VISIBLE
    }
    private fun hideSearchView() {
        //termsLy.visibility = View.VISIBLE
        //complBtn.visibility = View.VISIBLE
        centerSrchResultList.visibility = View.INVISIBLE
    }
}
