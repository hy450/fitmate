/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yhan.fitmate.core.di

import android.app.Application
import com.yhan.fitmate.AndroidApplication
import com.yhan.fitmate.core.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,
                        ViewModelModule::class,
                        AndroidInjectionModule::class,
                        ActivityBuilder::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application) : Builder
        fun build(): ApplicationComponent
    }

    fun inject(application: AndroidApplication)
    //fun inject(routeActivity: RouteActivity)
    //fun inject(loginFragment: LoginFragment)
    
}
