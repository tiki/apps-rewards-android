package com.mytiki.apps_receipt_rewards.offer

import com.mytiki.apps_receipt_rewards.account.AccountProvider

data class Offer(
    val accountProvider: AccountProvider,
    val discount: String,
    val offerLink: String
)