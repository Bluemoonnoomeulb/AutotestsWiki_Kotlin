package org.wikipedia.fintechuitest.espresso.screens

import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString
import org.wikipedia.R
import org.wikipedia.views.PlainPasteEditText

class WikiAccountScreen {
    private val fieldInputUsername = allOf(
        isDescendantOfA(withId(R.id.create_account_username)),
        isAssignableFrom(EditText::class.java)
    )
    private val fieldInputPassword = allOf(
        isDescendantOfA(withId(R.id.create_account_password_input)),
        isAssignableFrom(EditText::class.java)
    )
    private val buttonEye = allOf(
        withId(com.google.android.material.R.id.text_input_end_icon),
        isDescendantOfA(withId(R.id.create_account_password_input))
    )

    fun inputUsername(username : String) {
        onView(fieldInputUsername)
            .perform(typeText(username))
    }

    fun inputPassword(password : String) {
        onView(fieldInputPassword)
            .perform(click())
            .perform(typeText(password))
            .perform(closeSoftKeyboard())
    }

    fun clickEyeButton() {
        onView(buttonEye)
            .perform(click())
    }

    fun checkVisiblePassword(password: String) {
        onView(fieldInputPassword)
            .check(matches(withText(password)))
    }

    fun checkHiddenPassword(password: String) {
        onView(fieldInputPassword)
            .check(matches(withText(PasswordTransformationMethod.getInstance().getTransformation(password, null).toString())))
    }

    companion object {
        inline operator fun invoke(crossinline block: WikiAccountScreen.() -> Unit) = WikiAccountScreen().block()
    }
}