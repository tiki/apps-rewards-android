package com.mytiki.rewards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
<<<<<<< HEAD
import com.mytiki.apps_receipt_rewards.ui.Rewards
import com.mytiki.apps_receipt_rewards.ui.RewardsActivity
=======
import com.mytiki.apps_receipt_rewards.Rewards
>>>>>>> origin/docs/rewards-api

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.start).setOnClickListener {
<<<<<<< HEAD
            Rewards.start(this)
=======
           Rewards.start(this)
>>>>>>> origin/docs/rewards-api
        }
    }
}
