package org.wikipedia.fintechuitest.espresso

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.fintechuitest.espresso.screens.*
import org.wikipedia.main.MainActivity
import org.wikipedia.fintechuitest.rules.LaunchActivityRule

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
        AboutAppScreen {
            checkAuthorBlock()
            checkTranslatorBlock()
            checkLicBlock()
        }
    }

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

    @Test
    fun passwordDisplayTest() {
        ExploreScreen {
            clickNavMoreButton()
            clickLogInButton()
        }
        WikiAccountScreen {
            val temp = "12345"
            inputPassword(temp)
            clickEyeButton()
            checkVisiblePassword(temp)
            clickEyeButton()
            checkHiddenPassword(temp)
        }
    }
}


















































