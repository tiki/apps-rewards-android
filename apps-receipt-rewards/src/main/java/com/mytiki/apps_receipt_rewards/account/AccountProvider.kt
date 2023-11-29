

package com.mytiki.apps_receipt_rewards.account

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
    fun name(): String {
        return when (this) {
            is Email -> emailEnum.name
            is Retailer -> retailerEnum.name
        }.replace("_", " ").replaceFirstChar(Char::titlecase)
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
