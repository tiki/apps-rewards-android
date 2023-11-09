package com.mytiki.apps_receipt_rewards.ui.model

import android.util.Log
import com.google.gson.Gson
import org.json.JSONObject
import java.lang.reflect.Type

class Account(
    val accountStatus: AccountStatus,
    val accountCommon: AccountCommon,
    val username: String,
)