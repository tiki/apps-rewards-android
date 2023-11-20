package com.mytiki.apps_receipt_rewards.email

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon

class EmailViewModel() : ViewModel() {
    val username = mutableStateOf<String>("")
    val password = mutableStateOf<String>("")
    val accountLists = mutableStateOf<List<Account>>(listOf())


    fun getAccountList(accountCommon: AccountCommon){
        accountLists.value = Rewards.accounts(accountCommon)
    }
}