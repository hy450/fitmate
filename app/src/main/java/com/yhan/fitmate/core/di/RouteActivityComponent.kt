package com.yhan.fitmate.core.di

import com.yhan.fitmate.core.navigation.RouteActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface RouteActivityComponent : AndroidInjector<RouteActivity> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<RouteActivity>()

}