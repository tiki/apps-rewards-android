/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.terms

import android.content.res.Configuration
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute


class OfferTermsScreen(
    private val navGraphBuilder: NavGraphBuilder,
    private val navController: NavController,
    private val springSpec: SpringSpec<IntOffset>,
    private val configuration: Configuration,
) {
    fun route() {
        navGraphBuilder.composable(
            route = RewardsRoute.TermsScreen.name,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { configuration.screenWidthDp / 2 },
                    animationSpec = springSpec
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -configuration.screenWidthDp / 2 },
                    animationSpec = springSpec
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -configuration.screenWidthDp / 2 },
                    animationSpec = springSpec
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { configuration.screenWidthDp / 2 },
                    animationSpec = springSpec
                )
            }
        ) {

        }
    }
}