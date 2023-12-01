/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.mytiki.apps_receipt_rewards.databinding.RewardsActivityBinding
import com.mytiki.apps_receipt_rewards.navigation.NavigationHost
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
    }
}



