package com.mytiki.apps_receipt_rewards.ui

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

class Rewards {

    companion object{
        fun start(context: Context){
            val intent = Intent(context, RewardsActivity::class.java)
            startActivity(context, intent, null)
        }
    }
}