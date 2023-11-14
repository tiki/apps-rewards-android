package com.mytiki.apps_receipt_rewards.offer

import com.mytiki.apps_receipt_rewards.account.AccountCommon

data class Offer(
    val accountCommon: AccountCommon,
    val discount: String
)