package com.mytiki.rewards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mytiki.apps_receipt_rewards.ui.activities.RewardsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.start).setOnClickListener {
            val intent = Intent(this, RewardsActivity::class.java)
            startActivity(intent)
        }
    }
}
