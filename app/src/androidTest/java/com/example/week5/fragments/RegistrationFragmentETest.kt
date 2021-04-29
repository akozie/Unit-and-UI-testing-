package com.example.week5.fragments

import android.app.Activity
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.week5.MainActivity
import com.example.week5.R
import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.hamcrest.CoreMatchers.anything
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4::class)
class RegistrationFragmentETest{

    /**
     * TESTING UI COMPONENTS
     * */
    @Test
    fun testSignUp(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java )
        onView(withId(R.id.name)).perform(typeText("Emmanuel"))
        onView(withId(R.id.phoneNumber)).perform(typeText("09087654321"))
        onView(withId(R.id.email)).perform(typeText("akoziemmanuel@gmail.com"))
        onView(withId(R.id.spinner)).perform(click())
        onData(anything()).atPosition(1).perform(click())
        onView(withId(R.id.spinner)).check(matches(withSpinnerText("Female")))
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.sendBtn)).perform(click())
        onView(withId(R.id.profile)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.registration)).check(matches(isDisplayed()))
    }

    /**
     * TESTING IF NAME TEXT INPUT IS DISPLAYED
     * */

    @Test
    fun nameDisplayed(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java )
        onView(withId(R.id.name)).check(matches(isDisplayed()))
    }

    /**
     * TESTING IF PHONE NUMBER TEXT INPUT IS DISPLAYED
     * */

    @Test
    fun phoneNumberDisplayed(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java )
        onView(withId(R.id.phoneNumber)).check(matches(isDisplayed()))
    }

    /**
     * TESTING IF EMAIL TEXT INPUT IS DISPLAYED
     * */

    @Test
    fun emailDisplayed(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java )
        onView(withId(R.id.email)).check(matches(isDisplayed()))
    }

    /**
     * TESTING IF BUTTON IS DISPLAYED
     * */
    @Test
    fun buttonDisplayed(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java )
        onView(withId(R.id.sendBtn)).check(matches(isDisplayed()))
    }

    @Test
    fun spinnerDisplayed(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java )
        onView(withId(R.id.spinner)).check(matches(isDisplayed()))
    }
}
