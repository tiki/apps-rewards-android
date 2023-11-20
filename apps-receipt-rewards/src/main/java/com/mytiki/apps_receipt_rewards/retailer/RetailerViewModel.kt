package com.mytiki.apps_receipt_rewards.retailer

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon
import com.mytiki.apps_receipt_rewards.offer.Offer

class RetailerViewModel() : ViewModel() {
    val username = mutableStateOf<String>("")
    val password = mutableStateOf<String>("")
    val accountLists = mutableStateOf<List<Account>>(listOf())
    val offerList = mutableStateOf<List<Offer>>(listOf())

    fun getAccountList(accountCommon: AccountCommon){
        accountLists.value = Rewards.accounts(accountCommon)
    }
    fun getOffers(accountCommon: AccountCommon){
        offerList.value = Rewards.offers(accountCommon)
    }
}