package org.wikipedia.fintechuitest.rules

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.wikipedia.fintechuitest.espresso.screens.FirstGreetingScreen
import org.wikipedia.test.BuildConfig

class LaunchActivityRule: TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand("pm clear ${BuildConfig.APPLICATION_ID}").close()
                FirstGreetingScreen {
                    clickSkipButton()
                }
                base.evaluate()
            }
        }
    }
}