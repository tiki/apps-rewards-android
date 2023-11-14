package com.mytiki.apps_receipt_rewards.account

class Account(
    var accountStatus: AccountStatus,
    val accountCommon: AccountCommon,
    val username: String,
    val password: String? = null
)