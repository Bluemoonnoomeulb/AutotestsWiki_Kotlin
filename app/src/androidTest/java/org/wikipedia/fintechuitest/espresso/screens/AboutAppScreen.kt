package org.wikipedia.fintechuitest.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.wikipedia.R

class AboutAppScreen {
    private val titleAuthorMatcher = withText(R.string.about_contributors_heading)
    private val titleTranslatorMatcher = withText(R.string.about_translators_heading)
    private val titleLicMatcher = withText(R.string.about_app_license_heading)
    private val textViewAuthorMatcher = withId(R.id.about_contributors)
    private val textViewTranslatorMatcher = withId(R.id.about_translators)
    private val textViewLicMatcher = withId(R.id.about_app_license)

    fun checkAuthorBlock() {
        onView(titleAuthorMatcher)
            .check(matches(isDisplayed()))
        onView(textViewAuthorMatcher)
            .check(matches(isDisplayed()))
    }

    fun checkTranslatorBlock() {
        onView(titleTranslatorMatcher)
            .check(matches(isDisplayed()))
        onView(textViewTranslatorMatcher)
            .check(matches(isDisplayed()))
    }

    fun checkLicBlock() {
        onView(titleLicMatcher)
            .check(matches(isDisplayed()))
        onView(textViewLicMatcher)
            .check(matches(isDisplayed()))
    }

    companion object {
        inline operator fun invoke(crossinline block: AboutAppScreen.() -> Unit) = AboutAppScreen().block()
    }
}