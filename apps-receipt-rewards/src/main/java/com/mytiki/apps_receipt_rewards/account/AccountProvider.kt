/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.account

import android.annotation.SuppressLint
import android.content.Context
import com.mytiki.apps_receipt_rewards.email.EmailEnum
import com.mytiki.apps_receipt_rewards.retailer.RetailerEnum

/**
 * [AccountProvider] enum represents different account providers, including retailers and email providers.
 */
sealed class AccountProvider {

    data class Retailer(val retailerEnum: RetailerEnum) : AccountProvider()
    data class Email(val emailEnum: EmailEnum) : AccountProvider()

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
    fun resId(context: Context): Int {
        val id = when (this) {
            is Email -> emailEnum.name
            is Retailer -> retailerEnum.name
        }.lowercase()
        return context.resources.getIdentifier(id, "drawable", context.packageName)
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
    }
}
