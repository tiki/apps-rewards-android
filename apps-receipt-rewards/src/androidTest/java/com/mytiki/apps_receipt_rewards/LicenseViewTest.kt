package com.mytiki.apps_receipt_rewards

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import com.mytiki.apps_receipt_rewards.license.ui.LicenseTerms
import org.junit.Rule
import org.junit.Test

class LicenseViewTest {
    @Test
    fun setCompanyTermsTest(){
        Rewards.company("test1","test2","test2","test4")
        assert(Rewards.license.terms() == "test1 test2 test2 test4")
    }
}