package com.yhan.fitmate.core.di

import com.yhan.fitmate.core.navigation.RouteActivity
import com.yhan.fitmate.feature.login.LoginActivity
import com.yhan.fitmate.feature.login.LoginFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    //@Binds @IntoMap @ActivityKey(RouteActivity::class)
    //abstract fun bindRoutActivity(builder: RouteActivityComponent.Builder) : AndroidInjector.Factory<out Activity>

    @ContributesAndroidInjector
    abstract fun bindRouteActivity() : RouteActivity

    //@Binds @IntoMap @dagger.android.support.FragmentKey(LoginFragment::class)
    //abstract fun bindLoginFragment(builder: LoginFragmentComponent.Builder) : AndroidInjector.Factory<out Fragment>

    @ContributesAndroidInjector(modules = [LoginFragmentProvider::class])
    abstract fun bindLoginActivity() : LoginActivity



}