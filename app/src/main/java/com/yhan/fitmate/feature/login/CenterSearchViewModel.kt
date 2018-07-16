package com.yhan.fitmate.feature.login

import androidx.lifecycle.MutableLiveData
import com.yhan.fitmate.core.platform.BaseViewModel
import com.yhan.fitmate.datamodel.CenterInfo
import com.yhan.fitmate.domain.GetCenter
import javax.inject.Inject

class CenterSearchViewModel
@Inject constructor(private val getCenter: GetCenter) : BaseViewModel() {

    var centers: MutableLiveData<List<CenterInfo>> = MutableLiveData()

    fun loadCenterList(keyword: String, pageIdx: Int = 1) {

        //val hashMap = hashMapOf<String,Any>("keyword" to keyword, "pageIdx" to pageIdx)
        getCenter( GetCenter.Params(keyword,pageIdx)) {
            it.either(::handleFailure, ::handleCenterList)
        }
    }

    private fun handleCenterList( centers: List<CenterInfo>) {
        this.centers.value = centers
    }

}