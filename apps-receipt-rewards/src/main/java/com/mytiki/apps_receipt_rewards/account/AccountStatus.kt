package com.mytiki.apps_receipt_rewards.account

enum class AccountStatus {
    NOT_LINKED,
    LINKED,
    UNVERIFIED;

    override fun toString() = this.name

    companion object {
        fun fromSource(string: String) = AccountCommon.values().first { it.name == string }
    }
}