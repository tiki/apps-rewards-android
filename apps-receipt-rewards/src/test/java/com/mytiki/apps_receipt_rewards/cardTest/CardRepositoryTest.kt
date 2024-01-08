package com.mytiki.apps_receipt_rewards.cardTest

import com.mytiki.apps_receipt_rewards.card.Card
import com.mytiki.apps_receipt_rewards.card.CardNetwork
import com.mytiki.apps_receipt_rewards.card.CardRepository
import org.junit.Test

class CardRepositoryTest {
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


    @Test
    fun crudTest(){
        val repo = CardRepository()
        repo.add(card1)
        assert(repo.all().contains(card1))
        repo.remove(card1)
        assert(!repo.all().contains(card1))
        assert(!repo.remove(card2))
    }

}