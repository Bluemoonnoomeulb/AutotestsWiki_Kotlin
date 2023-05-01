package org.wikipedia.fintechuitest.espresso.matchers

import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.wikipedia.R


class HintColorMatcher(@ColorRes private val  resId: Int) : BoundedMatcher<View, TextView>(TextView::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("textView.currentHintTextColor is ${getHexColor(resId)}")
    }

    override fun matchesSafely(textView: TextView): Boolean {
        return ContextCompat.getColor(textView.context, R.color.red500) == resId
    }

    @Suppress("MagicNumber")
    private fun getHexColor(color: Int): String {
        return String.format("#%06X", 0xFFFFFF and color)
    }
}

