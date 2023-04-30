package org.wikipedia.fintechuitest.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.not
import org.hamcrest.core.AllOf
import org.wikipedia.R

class AboutAppScreen {
    private val titleAuthor = withText(R.string.about_contributors_heading)
    private val titleTranslator = withText(R.string.about_translators_heading)
    private val titleLic = withText(R.string.about_app_license_heading)
    private val textViewAuthor = withId(R.id.about_contributors)
    private val textViewTranslator = withId(R.id.about_translators)
    private val textViewLic = withId(R.id.about_app_license)

    fun checkAuthorBlock() {
        onView(titleAuthor)
            .check(matches(isDisplayed()))
        onView(textViewAuthor)
            .check(matches(isDisplayed()))
    }

    fun checkTranslatorBlock() {
        onView(titleTranslator)
            .check(matches(isDisplayed()))
        onView(textViewTranslator)
            .check(matches(isDisplayed()))
    }

    fun checkLicBlock() {
        onView(titleLic)
            .check(matches(isDisplayed()))
        onView(textViewLic)
            .check(matches(isDisplayed()))
    }

    companion object {
        inline operator fun invoke(crossinline block: AboutAppScreen.() -> Unit) = AboutAppScreen().block()
    }
}