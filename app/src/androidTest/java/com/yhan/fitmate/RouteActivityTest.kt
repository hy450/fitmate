package com.yhan.fitmate

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.yhan.fitmate.core.navigation.RouteActivity
import com.yhan.fitmate.feature.login.Authenticator
import com.yhan.fitmate.feature.login.LoginActivity
import com.yhan.fitmate.feature.main.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
@LargeTest
class RouteActivityTest {

    @get:Rule @JvmField
    val activity = ActivityTestRule<RouteActivity>(RouteActivity::class.java,false,false)

    private lateinit var testAppComponent: TestAppComponent

    private lateinit var app: AndroidApplication

    @Before fun setUp() {
        Intents.init()

        MockitoAnnotations.initMocks(this)

        app = InstrumentationRegistry.getTargetContext().applicationContext as AndroidApplication
        testAppComponent = DaggerTestAppComponent.builder()
                .application(app)
                .build()
        testAppComponent.inject(this)
    }

    @After fun tearDown() {
        Intents.release()
    }

    // 사용자 로그인이 되어있지 않아 로그인 화면으로 이동해야함.
    @Test fun loginMoveTest() {
        activity.launchActivity(null)
        Thread.sleep(2000)

        intended(hasComponent(LoginActivity::class.java.name))
    }

    @Test fun moveMainTest() {
        activity.launchActivity(null)
        Thread.sleep(2000)
        intended(hasComponent(MainActivity::class.java.name))

    }


}
