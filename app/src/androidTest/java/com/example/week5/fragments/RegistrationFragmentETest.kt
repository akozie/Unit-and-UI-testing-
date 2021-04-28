package com.example.week5.fragments

import android.app.Activity
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.week5.MainActivity
import com.example.week5.R
import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4::class)
class RegistrationFragmentETest{
    @Test
    fun testSignUp(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java )
        onView(withId(R.id.name)).perform(typeText("Emmanuel"))
        onView(withId(R.id.phoneNumber)).perform(typeText("09087654321"))
        onView(withId(R.id.email)).perform(typeText("gth@h.m"))
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.sendBtn)).perform(click())
        onView(withId(R.id.profile)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.registration)).check(matches(isDisplayed()))
    }
}
