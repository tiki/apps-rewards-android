package com.mytiki.apps_receipt_rewards.ui.offer

import com.mytiki.apps_receipt_rewards.ui.account.AccountCommon

data class Offer(
    val accountCommon: AccountCommon,
    val discount: String
)