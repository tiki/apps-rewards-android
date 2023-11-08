package com.mytiki.apps_receipt_rewards.ui.model

import com.google.gson.Gson
import java.lang.reflect.Type

class Account(
    val accountStatus: AccountStatus,
    val accountCommon: AccountCommon
){
    fun toJson(): String?{
        return  Gson().toJson(this)
    }
    companion object{
        fun fromJson(value: String): Account{
            return Gson().fromJson(value, Account::class.java)
        }
    }
}
