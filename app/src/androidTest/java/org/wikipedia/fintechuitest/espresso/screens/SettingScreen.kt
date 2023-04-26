package org.wikipedia.fintechuitest.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R

class SettingScreen {
    private val buttonCustomizeFeed = withText(R.string.preference_title_customize_explore_feed)

    fun clickFeedButton() {
        onView(buttonCustomizeFeed)
            .perform(click())
    }

    companion object {
        inline operator fun invoke(crossinline block: SettingScreen.() -> Unit) = SettingScreen().block()
    }
}