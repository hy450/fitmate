package com.yhan.fitmate.feature.login

import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface LoginFragmentComponent : AndroidInjector<LoginFragment>{

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<LoginFragment>()
}