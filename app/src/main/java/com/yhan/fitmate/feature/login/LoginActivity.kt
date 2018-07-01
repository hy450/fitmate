package com.yhan.fitmate.feature.login

import android.content.Context
import android.content.Intent
import com.yhan.fitmate.core.platform.BaseActivity
import com.yhan.fitmate.core.platform.BaseFragment

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity() {

    companion object {
        fun callingIntent( context: Context) = Intent(context, LoginActivity::class.java)
    }

    override fun fragment(): BaseFragment = LoginFragment()
}
