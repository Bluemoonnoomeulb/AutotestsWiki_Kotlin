package org.wikipedia.fintechuitest.espresso

import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.fintechuitest.espresso.screens.AboutAppScreen
import org.wikipedia.fintechuitest.espresso.screens.ExploreScreen
import org.wikipedia.fintechuitest.espresso.screens.FeedCustomizationScreen
import org.wikipedia.fintechuitest.espresso.screens.SettingScreen
import org.wikipedia.fintechuitest.rules.LaunchActivityRule
import org.wikipedia.R

@RunWith(AndroidJUnit4::class)
class AllSortsOfTests {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val launchWikiRule = LaunchActivityRule()


    @Test
    fun defaultSettingsTest() {
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

    @Test
    fun aboutAppTest() {
        ExploreScreen {
            clickNavMoreButton()
            clickSettingsButton()
        }

        SettingScreen {
            scrollView()
            clickAboutAppButton()
        }

        //Thread.sleep(5000)

        AboutAppScreen {
            checkAuthorBlock()
            checkTranslatorBlock()
            checkLicBlock()
        }
    }


    /*@Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }*/
    @Test
    fun forwardingBrowserTest() {

        ExploreScreen {
            clickNavMoreButton()
            clickSettingsButton()
        }

        SettingScreen {
            scrollView()
            clickPolicyButton()
        }
    }
}


















































