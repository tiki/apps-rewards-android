package com.mytiki.apps_receipt_rewards

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import com.mytiki.apps_receipt_rewards.license.ui.LicenseTerms
import com.mytiki.apps_receipt_rewards.license.ui.LicenseView
import org.junit.Rule
import org.junit.Test

class LicenseViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun setCompanyTermsTest(){
        Rewards.company("nameTest","jurisdictionTest","privacyTest","termsTest")
        composeTestRule.setContent {
            LicenseTerms({}) {}
        }

        composeTestRule.onNodeWithText("nameTest jurisdictionTest privacyTest termsTest").assertExists()
    }
}