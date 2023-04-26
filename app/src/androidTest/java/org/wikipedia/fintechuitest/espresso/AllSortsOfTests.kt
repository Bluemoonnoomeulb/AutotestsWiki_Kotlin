package org.wikipedia.fintechuitest.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.R
import org.wikipedia.fintechuitest.espresso.screens.ExploreScreen
import org.wikipedia.fintechuitest.espresso.screens.FeedCustomizationScreen
import org.wikipedia.fintechuitest.espresso.screens.SettingScreen
import org.wikipedia.fintechuitest.rules.LaunchActivityRule

@RunWith(AndroidJUnit4::class)
class AllSortsOfTests {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val launchWikiRule = LaunchActivityRule()

    @Test
    fun fragmentNavigationTest() {
        ExploreScreen {
            clickNavMoreButton()
            clickSettingsButton()
        }
        SettingScreen {
            clickFeedButton()
        }

        FeedCustomizationScreen {
            checkFirstCheckbox()
            checkSecondCheckbox()
            checkThirdCheckbox()
            checkFourthCheckbox()
            checkFifthCheckbox()
            checkSixthCheckbox()
            scrollView()
            checkSeventhCheckbox()
            checkEighthCheckbox()
        }
    }
}