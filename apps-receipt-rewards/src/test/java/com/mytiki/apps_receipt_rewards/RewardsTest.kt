package com.mytiki.apps_receipt_rewards

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.mytiki.apps_receipt_rewards.card.Card
import com.mytiki.apps_receipt_rewards.card.CardNetwork
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RewardsTest {

    @Test
    fun licenseTest(){
        Rewards.licenses("Test", "Test", "Test")
        assert(Rewards.license.licenseKeys.tikiPublishingID == "Test")
        assert(Rewards.license.licenseKeys.microblinkLicenseKey == "Test")
        assert(Rewards.license.licenseKeys.productIntelligenceKey == "Test")
    }

    @Test
    fun oauthTest(){
        Rewards.oauth(
            "test",
            "test",
        )
        assert(Rewards.capture.authKeys.gmailAPIKey == "test")
        assert(Rewards.capture.authKeys.outlookAPIKey == "test")
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
        assert(Rewards.theme.colorScheme.outline == Color(0xFF32484E))
        assert(Rewards.theme.colorScheme.outline != Color(0xFF000000))
        assert(Rewards.theme.colorScheme.primary == Color(0xFF5E00F5))
        assert(
            Rewards.theme.fontFamily == FontFamily(
            Font(R.font.space_grotesk_light, FontWeight.Light), //300
            Font(R.font.space_grotesk_regular, FontWeight.Normal), //400
            Font(R.font.space_grotesk_medium, FontWeight.Medium), //500
            Font(R.font.space_grotesk_semi_bold, FontWeight.SemiBold), //600
            Font(R.font.space_grotesk_bold, FontWeight.Bold), //700
        ))
    }

    @Test
    fun cardsTest(){
        val card1 = Card(
            last4 = "1234",
            bin = "789564",
            issuer = "TIKICard",
            network = CardNetwork.VISA
        )
        val card2 = Card(
            last4 = "9999",
            bin = "789123",
            issuer = "TIKIBank",
            network = CardNetwork.MASTER_CARD
        )
        val card3 = Card(
            last4 = "5555",
            bin = "675456",
            issuer = "TIKIInc",
            network = CardNetwork.AMERICAN
        )

        Rewards.cards(card1, card2)
        assert(Rewards.cards() == listOf(card1, card2))
        assert(Rewards.cards() != listOf(card2, card1))
        Rewards.removeCard(card1)
        assert(Rewards.cards() == listOf(card2))
        Rewards.removeCard(card2)
        assert(Rewards.cards() == listOf<Card>())
        Rewards.cards(listOf(card1, card2, card3))
        assert(Rewards.cards() == listOf(card1, card2, card3))
        assert(Rewards.cards() != listOf(card2, card3, card1))

    }


}