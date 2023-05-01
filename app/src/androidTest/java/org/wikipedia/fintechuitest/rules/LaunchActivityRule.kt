package org.wikipedia.fintechuitest.rules

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.wikipedia.fintechuitest.espresso.screens.FirstGreetingScreen

class LaunchActivityRule: TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                FirstGreetingScreen {
                    clickSkipButton()
                }
                base.evaluate()
            }
        }
    }
}