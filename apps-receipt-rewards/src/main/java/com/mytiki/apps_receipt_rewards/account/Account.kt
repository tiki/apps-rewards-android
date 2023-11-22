package com.mytiki.apps_receipt_rewards.account

class Account(
    val username: String,
    val accountProvider: AccountProvider,
    var isVerified: Boolean = false,
    var isSyncing: Boolean = false,
)