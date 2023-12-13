/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.account

import android.annotation.SuppressLint
import com.mytiki.apps_receipt_rewards.email.EmailEnum
import com.mytiki.apps_receipt_rewards.retailer.RetailerEnum
import com.mytiki.capture.receipt.account.AccountCommon

/**
 * [AccountProvider] enum represents different account providers, including retailers and email providers.
 */
sealed class AccountProvider {

    data class Retailer(val retailerEnum: RetailerEnum) : AccountProvider()
    data class Email(val emailEnum: EmailEnum) : AccountProvider()

    /**
     * Converts the [AccountProvider] object into a string representation.
     *
     * @return The name of the enum entry as a string.
     */
    override fun toString() = when (this) {
        is Email -> emailEnum.name
        is Retailer -> retailerEnum.name
    }

    /**
     * Returns the name of the account provider.
     */
    fun displayName(): String {
        return when (this) {
            is Email -> emailEnum.name
            is Retailer -> retailerEnum.name
        }.replace("_", " ").lowercase().replaceFirstChar(Char::titlecase)
    }

    @SuppressLint("DiscouragedApi")
    fun resId(): Int {
        return when (this) {
            is Email -> emailEnum.resId()
            is Retailer -> retailerEnum.resId()
        }
    }

    fun type(): AccountType {
        return when (this) {
            is Email -> AccountType.EMAIL
            is Retailer -> AccountType.RETAILER
        }
    }

    companion object {
        /**
         * Returns a list of all account providers.
         */
        fun all(): List<AccountProvider> {
            val providers: MutableList<AccountProvider> = mutableListOf()
            EmailEnum.values().forEach { provider ->
                providers.add(Email(provider))
            }
            RetailerEnum.values().forEach { provider ->
                providers.add(Retailer(provider))
            }
            return providers
        }

        fun fromString(name: String): AccountProvider?{
            return all().firstOrNull{it.toString() == name}
        }
    }
}
