/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.account

/**
 * [Account] data class represents an account with a username, provider, and status.
 *
 * @property username The username associated with the account.
 * @property provider The [AccountProvider] of the account.
 * @property status The [AccountStatus] of the account, default is [AccountStatus.UNVERIFIED].
 */
data class Account(
    val username: String,
    val provider: AccountProvider,
    val status: AccountStatus = AccountStatus.UNVERIFIED
) {

    /**
     * Generates a hash code for the [Account] based on its username and provider.
     *
     * @param hasher The [Hasher] used to generate the hash code.
     */
    override fun hashCode(): Int {
        var result = username.hashCode()
        result = 31 * result + provider.hashCode()
        return result
    }

    /**
     * Checks if two [Account] objects are equal based on their username and provider.
     *
     * @param other The other [Account] to compare.
     * @return `true` if the accounts are equal, `false` otherwise.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Account) return false

        return username == other.username && provider == other.provider
    }
}
