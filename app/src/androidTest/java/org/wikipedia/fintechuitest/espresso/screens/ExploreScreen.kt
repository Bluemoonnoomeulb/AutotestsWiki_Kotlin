package org.wikipedia.fintechuitest.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R

class ExploreScreen {
    private val buttonNavMoreMatcher = withId(R.id.nav_more_container)
    private val buttonOpenSettingsMatchers = withId(R.id.main_drawer_settings_container)
    private val buttonLogInMatchers = withId(R.id.main_drawer_account_container)

    fun clickNavMoreButton() {
        onView(buttonNavMoreMatcher)
            .perform(click())
    }

    fun clickSettingsButton() {
        onView(buttonOpenSettingsMatchers)
            .perform(click())
    }

    fun clickLogInButton() {
        onView(buttonLogInMatchers)
            .perform(click())
    }

    companion object {
        inline operator fun invoke(crossinline block: ExploreScreen.() -> Unit) = ExploreScreen().block()
    }
}