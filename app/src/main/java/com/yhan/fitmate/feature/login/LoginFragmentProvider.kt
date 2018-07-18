package com.yhan.fitmate.feature.login

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginFragmentProvider {


    @ContributesAndroidInjector
    abstract fun bindLoginFragment() : LoginFragment

}