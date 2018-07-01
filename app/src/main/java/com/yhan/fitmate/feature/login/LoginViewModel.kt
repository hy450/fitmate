package com.yhan.fitmate.feature.login


import com.yhan.fitmate.core.extension.debug
import com.yhan.fitmate.core.platform.BaseViewModel
import com.yhan.fitmate.domain.GetUser
import com.yhan.fitmate.entity.UserInfo
import javax.inject.Inject

/**
 * 로그인 화면 뷰 모델
 *  - 로그인 Progress
 *  - 로그인 완료
 *  - 로그인 실패
 */
class LoginViewModel
@Inject constructor(private val getUser: GetUser) : BaseViewModel()
{
    // 센터로 로그인 인증 진행
    fun centerAuth(auth_num: String, phone: String) {
        val params = HashMap<String,String>()
        params["auth_num"] = auth_num
        params["phone"] = phone

        getUser(params) {
            it.either(::handleFailure,::handleLoginResult)
        }
    }

    private fun handleLoginResult( userInfo: UserInfo) {

        debug(userInfo.toString())


    }

}