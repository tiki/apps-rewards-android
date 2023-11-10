package com.mytiki.apps_receipt_rewards.ui.model.offer

import com.mytiki.apps_receipt_rewards.ui.model.account.AccountCommon

data class Offer(
    val accountCommon: AccountCommon,
    val discount: String
)