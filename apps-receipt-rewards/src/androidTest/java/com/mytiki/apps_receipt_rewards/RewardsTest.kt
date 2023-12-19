package com.mytiki.apps_receipt_rewards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.junit.Test

class RewardsTest {

    @Test
    fun licenseTest(){
        Rewards.licenses("Test", "Test", "Test")
        assert(Rewards.licenseConfig.tikiPublishingID == "Test")
        assert(Rewards.licenseConfig.microblinkLicenseKey == "Test")
        assert(Rewards.licenseConfig.productIntelligenceKey == "Test")
    }

    @Test
    fun oauthTest(){
        Rewards.oauth(
            "test",
           "test",
        )
        assert(Rewards.oauth.gmailAPIKey == "test")
        assert(Rewards.oauth.outlookAPIKey == "test")
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
                Font(R.font.space_grotesk_regular, FontWeight.Normal), //400
                Font(R.font.space_grotesk_medium, FontWeight.Medium), //500
                Font(R.font.space_grotesk_semi_bold, FontWeight.SemiBold), //600
                Font(R.font.space_grotesk_bold, FontWeight.Bold), //700
            )
        )
        assert(Rewards.colorScheme.outline == Color(0xFF32484E))
        assert(Rewards.colorScheme.primary == Color(0xFF5E00F5))
    }
}