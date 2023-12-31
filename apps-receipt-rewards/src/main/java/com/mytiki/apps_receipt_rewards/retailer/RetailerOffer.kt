/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.retailer

import com.mytiki.apps_receipt_rewards.account.AccountProvider

data class RetailerOffer(
    val accountProvider: AccountProvider,
    val discount: String,
    val offerLink: String
)