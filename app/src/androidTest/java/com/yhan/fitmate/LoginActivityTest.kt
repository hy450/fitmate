package com.yhan.fitmate

import android.view.View
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.yhan.fitmate.feature.login.LoginActivity
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher


@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginActivityTest {
    @get:Rule @JvmField
    val rule = ActivityTestRule<LoginActivity>(LoginActivity::class.java, false,false)

    private lateinit var testAppComponent: TestAppComponent
    private lateinit var app: AndroidApplication

    @Before fun setUp() {

        MockitoAnnotations.initMocks(this)

        app = InstrumentationRegistry.getTargetContext().applicationContext as AndroidApplication
        testAppComponent = DaggerTestAppComponent.builder()
                .application(app)
                .build()
        testAppComponent.inject(this)

    }

    @After
    fun tearDown() {

    }

    @Test fun onLoadedFragmentTest() {

        rule.launchActivity(null)
        Thread.sleep(1000)

        onView(withId(R.id.searchTv )).check(matches(withHint("Center Select")))
        onView(withId(R.id.loginBtn)).check(matches(withText("Login")))
        onView(withId(R.id.phone)).check(matches(withHint("Phone Number")))


    }

    @Test fun onSearchCenterTest() {
        rule.launchActivity(null)
        Thread.sleep(1000)

        onView(withId(R.id.searchTv)).perform(typeText("SC_3"))
        Thread.sleep(5000) // network 속도 기다림

        onView(nthChildOf(withId(R.id.centerSrchResultList), 0)).perform( click())

        //onData( allOf( Matchers.`is`( instanceOf<String>(String::class.java)), Matchers.`is`("SC_3"))).perform( click() )

        //Thread.sleep( 000)

        onView(withId(R.id.searchTv)).check(matches(withText("SC_3")))

    }

    fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("with $childPosition child view of type parentMatcher")
            }

            override fun matchesSafely(view: View): Boolean {
                if (view.getParent() !is ViewGroup) {
                    return parentMatcher.matches(view.getParent())
                }

                val group = view.getParent() as ViewGroup
                return parentMatcher.matches(view.getParent()) && group.getChildAt(childPosition) == view
            }
        }
    }
}