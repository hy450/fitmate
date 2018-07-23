package com.yhan.fitmate

import android.app.Application
import com.yhan.fitmate.core.di.ApplicationModule
import com.yhan.fitmate.feature.login.LoginActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface TestAppComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun build(): TestAppComponent
    }


    fun inject(test: RouteActivityTest)
    fun inject(test: LoginActivityTest)

}