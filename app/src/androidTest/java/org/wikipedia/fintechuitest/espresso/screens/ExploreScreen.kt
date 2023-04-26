package org.wikipedia.fintechuitest.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R

class ExploreScreen {
    private val buttonNavMore = withId(R.id.nav_more_container)
    private val buttonOpenSettings = withId(R.id.main_drawer_settings_container)

    fun clickNavMoreButton() {
        onView(buttonNavMore)
            .perform(click())
    }

    fun clickSettingsButton() {
        onView(buttonOpenSettings)
            .perform(click())
    }

    companion object {
        inline operator fun invoke(crossinline block: ExploreScreen.() -> Unit) = ExploreScreen().block()
    }
}