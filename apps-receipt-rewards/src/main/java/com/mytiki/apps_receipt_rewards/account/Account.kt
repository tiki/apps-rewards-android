package com.mytiki.apps_receipt_rewards.account

class Account(
    var isVerified: Boolean? = null,
    val accountCommon: AccountCommon,
    val username: String,
    val password: String? = null
)