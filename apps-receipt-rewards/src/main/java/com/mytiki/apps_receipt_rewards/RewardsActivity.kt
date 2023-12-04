/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.mytiki.apps_receipt_rewards.databinding.RewardsActivityBinding
import com.mytiki.apps_receipt_rewards.navigation.ui.NavigationHost
import com.mytiki.apps_receipt_rewards.utils.theme.RewardsTheme

class RewardsActivity : AppCompatActivity() {

    private var _binding: RewardsActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = RewardsActivityBinding.inflate(layoutInflater)
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                RewardsTheme(Rewards.colorScheme) {
                    NavigationHost()
                }
            }
        }
        setContentView(binding.root)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}



