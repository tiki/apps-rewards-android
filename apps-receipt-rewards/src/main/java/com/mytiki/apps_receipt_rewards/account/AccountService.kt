/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.account

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
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
    private val accounts: MutableList<Account> = mutableListOf()

    // Public Methods

    /**
     * Retrieves all user accounts stored in the service.
     *
     * @return An array of user accounts.
     */
    fun accounts(context: Context): CompletableDeferred<List<Account>> {
        val accountList = CompletableDeferred<List<Account>>()
        MainScope().async {
            val list = CaptureReceipt.accounts(context) {
                val message = "It was not possible to retrieve the accounts list."
                val alertDialog = AlertDialog.Builder(context)
                    .setTitle(null)
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .create()
                alertDialog.show()
            }.await()
            accountList.complete(list)
        }
        return accounts.toList()
    }

    /**
     * Retrieves user accounts associated with a specific [AccountProvider].
     *
     * @param provider The account provider for which accounts should be retrieved.
     * @return An array of user accounts for the specified provider.
     */
    fun accounts(provider: AccountProvider): List<Account> {
        return accounts.filter { it.provider == provider }
    }

    /**
     * Retrieves available [AccountProvider], excluding those already associated with existing accounts.
     *
     * @return An array of available account providers.
     */
    fun providers(): List<AccountProvider> {
        val existingProviders = accounts.map { it.provider }
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
    fun login(activity: AppCompatActivity, username: String, password: String, provider: AccountProvider) {
        if (username.isEmpty() || password.isEmpty()) {
            throw Error("Username and password should not be empty.")
        } else {
            if (!accounts.any {
                    it.username == username &&
                            it.provider == provider &&
                            it.status == AccountStatus.VERIFIED
                }) {
                CaptureReceipt.login(
                    activity, username,
                    password,
                    AccountCommon.fromString(provider.toString())!!,
                    {
                        val account = Account(username, provider, AccountStatus.VERIFIED)
                        accounts.add(account)
                    }
                ){
                    val alertDialog = AlertDialog.Builder(activity)
                        .setTitle(null)
                        .setMessage(it)
                        .setPositiveButton("OK", null)
                        .create()
                    alertDialog.show()
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
    fun logout(username: String, provider: AccountProvider) {
        if (username.isEmpty()) {
            throw Error("Username should not be empty.")
        } else {
            val account = accounts.firstOrNull {
                it.username == username &&
                        it.provider == provider
            }
            if (account != null) {
                accounts.remove(account)
            }
        }
    }
}
