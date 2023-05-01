package org.wikipedia.fintechuitest.espresso.screens

import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.wikipedia.R
import org.wikipedia.fintechuitest.espresso.matchers.HintColorMatcher

class WikiAccountScreen {
    private val fieldInputUsernameMatcher = allOf(
        isDescendantOfA(withId(R.id.create_account_username)),
        isAssignableFrom(EditText::class.java)
    )
    private val fieldInputPasswordMatcher = allOf(
        isDescendantOfA(withId(R.id.create_account_password_input)),
        isAssignableFrom(EditText::class.java)
    )
    private val buttonEyeMatcher = allOf(
        withId(com.google.android.material.R.id.text_input_end_icon),
        isDescendantOfA(withId(R.id.create_account_password_input))
    )
    private val buttonNextMatcher = withId(R.id.create_account_submit_button)
    private val colorErrorMessage = R.color.red500

    fun inputUsername(username : String) {
        onView(fieldInputUsernameMatcher)
            .perform(click())
            .perform(typeText(username))
            .perform(closeSoftKeyboard())
    }

    fun inputPassword(password : String) {
        onView(fieldInputPasswordMatcher)
            .perform(click())
            .perform(typeText(password))
            .perform(closeSoftKeyboard())
    }

    fun clickEyeButton() {
        onView(buttonEyeMatcher)
            .perform(click())
    }

    fun checkVisiblePassword(password: String) {
        onView(fieldInputPasswordMatcher)
            .check(matches(withText(password)))
    }

    fun checkHiddenPassword(password: String) {
        onView(fieldInputPasswordMatcher)
            .check(matches(withText(PasswordTransformationMethod.getInstance().getTransformation(password, null).toString())))
    }

    fun clickNextButton() {
        onView(buttonNextMatcher)
            .perform(click())
    }

    fun checkRedTitle(errorHintId: Int) {
        onView(fieldInputPasswordMatcher)
            .check(matches(HintColorMatcher(errorHintId)))
    }

    fun checkRedExceptionMessage() {
        onView(withText(R.string.create_account_password_error))
            .check(matches(allOf(
                isDisplayed(),
                hasTextColor(colorErrorMessage)
            )))
    }

    companion object {
        inline operator fun invoke(crossinline block: WikiAccountScreen.() -> Unit) = WikiAccountScreen().block()
    }
}