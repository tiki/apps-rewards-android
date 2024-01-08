package com.mytiki.apps_receipt_rewards.cardTest

import com.mytiki.apps_receipt_rewards.card.CardNetwork
import org.junit.Test

class CardNetworkTest {
    @Test
    fun toStringAndFromStringTest() {
        assert(CardNetwork.VISA == CardNetwork.fromString(CardNetwork.VISA.toString()))
     }
}
