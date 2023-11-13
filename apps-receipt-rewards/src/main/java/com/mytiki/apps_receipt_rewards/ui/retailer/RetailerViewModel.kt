package com.mytiki.apps_receipt_rewards.ui.retailer

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.ui.account.Account
import com.mytiki.apps_receipt_rewards.ui.account.AccountCommon
import com.mytiki.apps_receipt_rewards.ui.account.AccountStatus
import com.mytiki.apps_receipt_rewards.ui.offer.Offer

class RetailerViewModel(): ViewModel() {
    val  accountLists = mutableStateListOf(
        Account(AccountStatus.UNVERIFIED, AccountCommon.WALMART, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.VERIFIED, AccountCommon.WALMART, "gabrielschuler6@gmail.com"),
    )


//    val  accountLists = mutableStateListOf<Account>()
    val  accountCommon = mutableStateOf(AccountCommon.WALMART)

    val  offerLists = mutableStateListOf<Offer>(
        Offer(AccountCommon.WALMART, "4% cashback on electronics"),
        Offer(AccountCommon.WALMART, "4% cashback on electronics"),
    )


    val username = mutableStateOf<String>("")
    val password = mutableStateOf<String>("")
}