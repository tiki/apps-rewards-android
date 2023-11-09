package com.mytiki.apps_receipt_rewards.ui.model
import com.mytiki.apps_receipt_rewards.R

enum class AccountCommon(val imageId: Int, val accountName: String, val accountType: AccountType) {
    WALMART(R.drawable.walmart, "Walmart", AccountType.RETAILER),
    UBER_EATS(R.drawable.uber_eats, "Uber Eats", AccountType.RETAILER),
    TACO_BELL(R.drawable.taco_bell, "Taco Bell", AccountType.RETAILER),
    DOLLAR_GENERAL(R.drawable.dollar_general, "Dollar General", AccountType.RETAILER),
    GMAIL(R.drawable.gmail, "Gmail", AccountType.EMAIL);

    override fun toString() = this.name

    companion object {
        fun fromSource(string: String) = AccountCommon.values().first { it.name == string }

    }
}