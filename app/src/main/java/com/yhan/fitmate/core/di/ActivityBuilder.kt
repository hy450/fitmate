package com.yhan.fitmate.core.di

import android.app.Activity
import androidx.fragment.app.Fragment
import com.yhan.fitmate.core.navigation.RouteActivity
import com.yhan.fitmate.feature.login.LoginFragment
import com.yhan.fitmate.feature.login.LoginFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

    @Binds @IntoMap @ActivityKey(RouteActivity::class)
    abstract fun bindRoutActivity(builder: RouteActivityComponent.Builder) : AndroidInjector.Factory<out Activity>

    @Binds @IntoMap @dagger.android.support.FragmentKey(LoginFragment::class)
    abstract fun bindLoginFragment(builder: LoginFragmentComponent.Builder) : AndroidInjector.Factory<out Fragment>


}