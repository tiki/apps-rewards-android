package com.mytiki.apps_receipt_rewards.cardTest

import com.mytiki.apps_receipt_rewards.card.Card
import com.mytiki.apps_receipt_rewards.card.CardNetwork
import com.mytiki.apps_receipt_rewards.card.CardRepository
import com.mytiki.apps_receipt_rewards.card.CardService
import org.junit.Test

class CardServiceTest {

    private val card1 = Card(
        last4 = "1234",
        bin = "789564",
        issuer = "TIKICard",
        network = CardNetwork.VISA
    )
    private val card2 = Card(
        last4 = "9999",
        bin = "789123",
        issuer = "TIKIBank",
        network = CardNetwork.MASTER_CARD
    )
    private val card3 = Card(
        last4 = "5555",
        bin = "675456",
        issuer = "TIKIInc",
        network = CardNetwork.AMERICAN
    )


    @Test
    fun crudTest(){
        val service = CardService()
        service.addCard(listOf(card1, card2))
        assert(service.getCards().contains(card1) && service.getCards().contains(card2))
        service.removeCard(card1)
        assert(!service.getCards().contains(card1))
        assert(!service.removeCard(card3))
    }


}