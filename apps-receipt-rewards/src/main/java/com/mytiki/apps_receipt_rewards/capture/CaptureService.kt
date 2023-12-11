/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.capture

import android.app.AlertDialog
import android.content.Context
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.more.MoreContributor
import com.mytiki.apps_receipt_rewards.retailer.RetailerOffer
import com.mytiki.sdk.capture.receipt.capacitor.CaptureReceipt

/**
 * [CaptureService] class provides functionalities related to capturing and processing data,
 * such as scanning physical and digital receipts and retrieving offers and contributors.
 *
 * ## Example
 *
 * To use the [CaptureService] class, follow the example below:
 *
 * ```kotlin
 * val captureService = CaptureService()
 *
 * // Trigger receipt scanning
 * captureService.scan(context)
 *
 * // Retrieve offers for a specific account provider
 * val providerOffers = captureService.offers(AccountProvider.YOUR_PROVIDER)
 *
 * // Retrieve the largest contributors
 * val contributors = captureService.largestContributors()
 * ```
 */
class CaptureService {

    /**
     * Initiates the receipt scanning process.
     *
     * Displays an alert indicating that the functionality is not implemented in the demo app.
     *
     * @param context The context for displaying the alert.
     */
    fun scan(context: Context) {
        val message = "Receipt scanning functionality not implemented in demo app."
        val alertDialog = AlertDialog.Builder(context)
            .setTitle(null)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .create()
        alertDialog.show()
    }

    /**
     * Retrieves a list of retailer offers for a specific account provider.
     *
     * @param provider The account provider for which offers should be retrieved.
     * @return A list of [RetailerOffer] objects containing offer details.
     */
    fun offers(provider: AccountProvider): List<RetailerOffer> {
        return listOf(
            RetailerOffer(provider, "4% cashback on electronics", "https://mytiki.com"),
            RetailerOffer(provider, "10% off on electronics", "https://mytiki.com")
        )
    }

    /**
     * Retrieves a list of the largest contributors to the rewards program.
     *
     * @return A list of [MoreContributor] objects containing contributor details.
     */
    fun largestContributors(): List<MoreContributor> {
        return listOf(
            MoreContributor("Walmart", 0.4),
            MoreContributor("Kroger", 0.3),
            MoreContributor("Dollar General", 0.2)
        )
    }
}
