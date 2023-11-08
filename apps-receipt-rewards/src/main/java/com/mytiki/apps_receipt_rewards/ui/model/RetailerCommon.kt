package com.mytiki.apps_receipt_rewards.ui.model

import com.mytiki.apps_receipt_rewards.R

enum class RetailerCommon(val imageId: Int, val retailerName: String) {
    WALMART(R.drawable.walmart, "Walmart"),
    UBER_EATS(R.drawable.uber_eats, "Uber Eats"),
    TACO_BELL(R.drawable.taco_bell, "Taco Bell"),
    DOLLAR_GENERAL(R.drawable.dollar_general, "Dollar General"),
    GMAIL(R.drawable.gmail, "Gmail");
}