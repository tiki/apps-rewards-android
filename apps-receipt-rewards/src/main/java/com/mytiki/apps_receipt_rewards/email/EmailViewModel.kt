package com.mytiki.apps_receipt_rewards.email

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.account.AccountProviderEnum

class EmailViewModel : ViewModel() {
    val username = mutableStateOf<String>("")
    val password = mutableStateOf<String>("")
    val accountLists = mutableStateOf<List<Account>>(listOf())

    fun getAccountList(accountProvider: AccountProvider) {
        accountLists.value = Rewards.accounts(accountProvider)
    }

    fun googleSignIn() {
        Rewards.login("test@gmail.com", "", AccountProviderEnum.GMAIL.provider)
        getAccountList(AccountProviderEnum.GMAIL.provider)
    }

    fun accountLogin(accountProvider: AccountProvider) {
        Rewards.login(
            Account(null, accountProvider, username.value, password.value)
        )
        getAccountList(accountProvider)
    }

    fun accountLogout(account: Account) {
        Rewards.logout(account)
        getAccountList(account.accountProvider)
    }
}