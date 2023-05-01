package org.wikipedia.fintechuitest.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class FeedCustomizationScreen {
    private val firstCheckboxMatcher = allOf(
        hasSibling(withChild(withText(R.string.view_featured_article_card_title))),
        withId(R.id.feed_content_type_checkbox)
    )
    private val secondCheckboxMatcher = allOf(
        hasSibling(withChild(withText(R.string.view_top_read_card_title))),
        withId(R.id.feed_content_type_checkbox)
    )
    private val thirdCheckboxMatcher = allOf(
        hasSibling(withChild(withText(R.string.view_featured_image_card_title))),
        withId(R.id.feed_content_type_checkbox)
    )
    private val fourthCheckboxMatcher = allOf(
        hasSibling(withChild(withText(R.string.view_because_you_read_card_title))),
        withId(R.id.feed_content_type_checkbox)
    )
    private val fifthCheckboxMatcher = allOf(
        hasSibling(withChild(withText(R.string.view_card_news_title))),
        withId(R.id.feed_content_type_checkbox)
    )
    private val sixthCheckboxMatcher = allOf(
        hasSibling(withChild(withText(R.string.on_this_day_card_title))),
        withId(R.id.feed_content_type_checkbox)
    )
    private val seventhCheckboxMatcher = allOf(
        hasSibling(withChild(withText(R.string.view_random_card_title))),
        withId(R.id.feed_content_type_checkbox)
    )
    private val eighthCheckboxMatcher = allOf(
        hasSibling(withChild(withText(R.string.view_main_page_card_title))),
        withId(R.id.feed_content_type_checkbox)
    )
    private val contentRecycler = withId(R.id.content_types_recycler)

    fun checkFirstCheckbox() {
        onView(firstCheckboxMatcher)
            .check(matches(isChecked()))
    }

    fun checkSecondCheckbox() {
        onView(secondCheckboxMatcher)
            .check(matches(isChecked()))
    }

    fun checkThirdCheckbox() {
        onView(thirdCheckboxMatcher)
            .check(matches(isChecked()))
    }

    fun checkFourthCheckbox() {
        onView(fourthCheckboxMatcher)
            .check(matches(isChecked()))
    }

    fun checkFifthCheckbox() {
        onView(fifthCheckboxMatcher)
            .check(matches(isChecked()))
    }

    fun checkSixthCheckbox() {
        onView(sixthCheckboxMatcher)
            .check(matches(isChecked()))
    }

    fun checkSeventhCheckbox() {
        onView(seventhCheckboxMatcher)
            .check(matches(isChecked()))
    }

    fun checkEighthCheckbox() {
        onView(eighthCheckboxMatcher)
            .check(matches(isChecked()))
    }

    fun scrollView() {
        onView(contentRecycler)
            .perform(swipeUp())
    }

    companion object {
        inline operator fun invoke(crossinline block: FeedCustomizationScreen.() -> Unit) = FeedCustomizationScreen().block()
    }
}