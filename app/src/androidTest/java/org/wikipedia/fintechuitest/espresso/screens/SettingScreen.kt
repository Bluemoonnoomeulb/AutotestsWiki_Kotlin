package org.wikipedia.fintechuitest.espresso.screens

import android.app.Instrumentation
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class SettingScreen {
    private val buttonCustomizeFeedMatcher = withText(R.string.preference_title_customize_explore_feed)
    private val viewRecyclerMatcher = withId(R.id.recycler_view)
    private val buttonAboutAppMatcher = withText(R.string.about_description)
    private val buttonPolicyMatcher = withText(R.string.privacy_policy_description)

    fun clickFeedButton() {
        onView(buttonCustomizeFeedMatcher)
            .perform(click())
    }

    fun scrollView() {
        onView(viewRecyclerMatcher)
            .perform(RecyclerViewActions.scrollToLastPosition<RecyclerView.ViewHolder>())
    }

    fun clickAboutAppButton() {
        onView(buttonAboutAppMatcher)
            .perform(click())
    }

    fun clickPolicyButton() {
        Intents.init()
        val expected = allOf(
            IntentMatchers.hasAction(Intent.ACTION_VIEW),
        )
        Intents.intending(expected).respondWith(Instrumentation.ActivityResult(0, null))
        onView(buttonPolicyMatcher)
            .perform(click())
        Intents.intended(expected)
        Intents.release()
    }

    companion object {
        inline operator fun invoke(crossinline block: SettingScreen.() -> Unit) = SettingScreen().block()
    }
}