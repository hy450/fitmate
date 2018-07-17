package com.yhan.fitmate

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.yhan.fitmate.core.di.ApplicationComponent
import com.yhan.fitmate.core.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class AndroidApplication : Application() , HasActivityInjector, HasSupportFragmentInjector {
    @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()

    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
        //this.initializeLeakDetection()
    }

    private fun injectMembers() = appComponent.inject(this)

    //private fun initializeLeakDetection() {
    //    if (BuildConfig.DEBUG) LeakCanary.install(this)
    //}

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector
}
