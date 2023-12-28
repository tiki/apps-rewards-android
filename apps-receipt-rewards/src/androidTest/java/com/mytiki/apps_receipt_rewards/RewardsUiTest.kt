package com.mytiki.apps_receipt_rewards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.mytiki.apps_receipt_rewards.license.ui.LicenseTerms
import com.mytiki.apps_receipt_rewards.license.ui.LicenseView
import com.mytiki.apps_receipt_rewards.utils.theme.RewardsTheme
import org.junit.Rule
import org.junit.Test

class RewardsUiTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun companyTermsTest(){
        Rewards.company("nameTest","jurisdictionTest","privacyTest","termsTest")
        composeTestRule.setContent {
            LicenseTerms({}) {}
        }

        composeTestRule.onNodeWithText("nameTest jurisdictionTest privacyTest termsTest").assertExists()
    }

    @Test
    fun themeTest(){
        Rewards.theme(
            Color(0xFF32484E),
            Color(0x99931A97),
            Color(0xFF399E22),
            Color(0xFF0B8069),
            Color(0xFF5E00F5),
            FontFamily(
                Font(R.font.space_grotesk_light, FontWeight.Light), //300
                Font(R.font.space_grotesk_regular, FontWeight.Light), //400
                Font(R.font.space_grotesk_medium, FontWeight.Light), //500
                Font(R.font.space_grotesk_semi_bold, FontWeight.Light), //600
                Font(R.font.space_grotesk_bold, FontWeight.Light), //700
            )
        )
        val array = IntArray(20)
        composeTestRule.setContent {
            RewardsTheme(Rewards.theme.colorScheme) {
                LicenseView(onGetEstimate = {}){}
            }
        }
        composeTestRule.onNodeWithTag(TestTag.SURFACE_CONTAINER.name).captureToImage()
            .readPixels(array, startY = 500, startX = 200, width = 5, height = 4)
        array.forEach {
            assert(
                it == Rewards.theme.colorScheme.background.convert(ColorSpaces.Srgb).hashCode()
            )
        }

        composeTestRule.onNodeWithTag(TestTag.TITLE.name).captureToImage()
            .readPixels(array, startY = 500, startX = 200, width = 5, height = 4)
        array.forEach {
            assert(
                it == Rewards.theme.colorScheme.background.convert(ColorSpaces.Srgb).hashCode()
            )
        }
        composeTestRule.onNodeWithTag(TestTag.SUBTITLE.name).captureToImage()
            .readPixels(array, startY = 500, startX = 200, width = 5, height = 4)
        array.forEach {
            assert(
                it == Rewards.theme.colorScheme.background.convert(ColorSpaces.Srgb).hashCode()
            )
        }

    }


}