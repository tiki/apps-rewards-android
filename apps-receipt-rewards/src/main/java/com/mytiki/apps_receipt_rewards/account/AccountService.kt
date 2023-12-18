/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.account

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.mutableStateListOf
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.capture.receipt.CaptureReceipt
import com.mytiki.capture.receipt.account.AccountCommon
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async

/**
 * [AccountService] class manages user accounts, providing methods for retrieving account
 * information, handling logins, and managing sessions.
 *
 * ## Overview
 *
 * [AccountService] class is responsible for maintaining a collection of 3rd party accounts,
 * allowing for account retrieval based on providers and performing login and logout operations.
 *
 * ## Example
 *
 * To use the [AccountService] class, follow the example below:
 *
 * ```kotlin
 * val accountService = AccountService()
 *
 * // Retrieve all accounts
 * val allAccounts = accountService.accounts()
 *
 * // Retrieve accounts for a specific provider
 * val facebookAccounts = accountService.accounts(AccountProvider.Facebook)
 *
 * // Retrieve available account providers
 * val availableProviders = accountService.providers()
 * ```
 */
class AccountService {

    // Properties

    /**
     * An array containing the user accounts managed by the service.
     */


    // Public Methods

    /**
     * Retrieves all user accounts stored in the service.
     *
     * @return An array of user accounts.
     */
    suspend fun accounts(context: Context): List<Account> {
        return CaptureReceipt.accounts(context){
            Rewards.onError(context, "It was not possible to retrieve the accounts list.")
        }.map{Account(it)}
    }

    /**
     * Retrieves user accounts associated with a specific [AccountProvider].
     *
     * @param provider The account provider for which accounts should be retrieved.
     * @return An array of user accounts for the specified provider.
     */
    suspend fun accounts(context: Context, provider: AccountProvider): List<Account> {
        return accounts(context).filter {it.provider.toString() == provider.toString()}
    }

    /**
     * Retrieves available [AccountProvider], excluding those already associated with existing accounts.
     *
     * @return An array of available account providers.
     */
    suspend fun providers(context: Context): List<AccountProvider> {
        val existingProviders = accounts(context).map { it.provider }.distinctBy { it.name() }
        return AccountProvider.all().filterNot { existingProviders.contains(it) }
    }

    /**
     * Logs in a user by creating a new account or verifying an existing one.
     *
     * @param username The username for the account.
     * @param password The password for the account.
     * @param provider The account provider for the login.
     * @return The logged-in user account.
     * @throws Error An error indicating issues with the login process, such as empty credentials or an already linked account.
     */
    @Throws(Error::class)
    fun login(activity: AppCompatActivity, username: String, password: String, provider: AccountProvider, onSuccess: (Account) -> Unit) {
        if (username.isEmpty() || password.isEmpty()) {
            Rewards.onError(activity, "Username and password should not be empty.")
        } else {
            MainScope().async {
                if (!accounts(activity).any {
                        it.username == username &&
                                it.provider == provider &&
                                it.status == AccountStatus.VERIFIED
                    }) {
                    CaptureReceipt.login(
                        activity, username,
                        password,
                        AccountCommon.fromString(provider.name())!!,
                        {onSuccess(Account(it))}
                    ) {
                        Rewards.onError(activity, it)
                    }
                }
            }
        }
    }

    /**
     * Logs out a user by removing the associated account.
     *
     * @param username The username of the account to be logged out.
     * @param provider The account provider of the account to be logged out.
     * @return The logged-out user account.
     * @throws Error An error indicating issues with the logout process, such as an empty username or an account not found.
     */
    @Throws(Error::class)
    fun logout(context: Context, username: String, provider: AccountProvider) {
        if (username.isEmpty()) {
            Rewards.onError(context, "Please pass a username and a provider.")
        } else {
            MainScope().async {
                val account = accounts(context).firstOrNull {
                    it.username == username &&
                            it.provider == provider
                }
                if (account != null) {
                    CaptureReceipt.logout(context, account.toCaptureAccount(), {}){}
                } else {
                    Rewards.onError(context, "This account doesn't exist.")
                }
            }
        }
    }

    fun logout(context: Context) {
        MainScope().async {
            CaptureReceipt.logout(context, {}){Rewards.onError(context, it)}
        }
    }
}
