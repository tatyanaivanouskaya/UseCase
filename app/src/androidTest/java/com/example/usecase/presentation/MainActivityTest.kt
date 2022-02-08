package com.example.usecase.presentation

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.usecase.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun saveButtonIsDisplayed(){
        Espresso.onView(withId(R.id.sendButton)).perform(click()).check(matches(isDisplayed()))
    }
    @Test
    fun pressButtonIsDisplayed(){
        Espresso.onView(withId(R.id.receiveButton)).perform(click()).check(matches(isDisplayed()))
    }
    @Test
    fun editTextLineIsDisplayed(){
        Espresso.onView(withId(R.id.dataEditText)).check(matches(isDisplayed()))
    }
    @Test
    fun dataTextLineIsDisplayed(){
        Espresso.onView(withId(R.id.dataTextView)).check(matches(isDisplayed()))
    }
    @Test
    fun enterAndGetText() {
        Espresso.onView(withId(R.id.dataEditText))
            .perform(typeText("new_name_test_2"))

        Espresso.onView(withId(R.id.sendButton))
            .perform(click())

        Espresso.onView(withId(R.id.receiveButton))
            .perform(click())

        Espresso.onView(withId(R.id.dataTextView))
            .check(matches(withText("new_name_test_2 def_last_name")))
    }
}