package com.mytiki.apps_receipt_rewards.account

import com.mytiki.apps_receipt_rewards.R

enum class AccountProviderEnum(val provider: AccountProvider) {
    WALMART(AccountProvider(R.drawable.walmart, "Walmart", AccountType.RETAILER)),
    UBER_EATS(AccountProvider(R.drawable.uber_eats, "Uber Eats", AccountType.RETAILER)),
    TACO_BELL(AccountProvider(R.drawable.taco_bell, "Taco Bell", AccountType.RETAILER)),
    DOLLAR_GENERAL(
        AccountProvider(
            R.drawable.dollar_general,
            "Dollar General",
            AccountType.RETAILER
        )
    ),
    GMAIL(AccountProvider(R.drawable.gmail, "Gmail", AccountType.EMAIL));

    override fun toString(): String {
        return provider.accountName
    }
}