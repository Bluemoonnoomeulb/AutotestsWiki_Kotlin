package org.wikipedia.fintechuitest.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R

class FirstGreetingScreen {
    private val buttonSkipMatcher = withId(R.id.fragment_onboarding_skip_button)

    fun clickSkipButton(){
        onView(buttonSkipMatcher)
            .perform(click())
    }

    companion object {
        inline operator fun invoke(crossinline block: FirstGreetingScreen.() -> Unit) = FirstGreetingScreen().block()
    }
}