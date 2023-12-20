package com.mytiki.sdk.capture.receipt.capacitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mytiki.apps_receipt_rewards.Rewards


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.start).setOnClickListener {
            Rewards.initialize(this, "userId1")
        }
    }
}
