/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.navigation.ui

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.account.AccountType
import com.mytiki.apps_receipt_rewards.email.ui.EmailView
import com.mytiki.apps_receipt_rewards.home.ui.HomeView
import com.mytiki.apps_receipt_rewards.license.ui.LicenseTerms
import com.mytiki.apps_receipt_rewards.license.ui.LicenseView
import com.mytiki.apps_receipt_rewards.more.ui.MoreView
import com.mytiki.apps_receipt_rewards.navigation.NavigationRoute
import com.mytiki.apps_receipt_rewards.retailer.ui.RetailerView

private val accountProvider = mutableStateOf<AccountProvider?>(null)

@Composable
fun NavigationHost() {
    var finish by mutableStateOf(false)
    val navController = rememberNavController()
    val context = LocalContext.current
    navController.addOnDestinationChangedListener { _, _, _ ->
        if (finish) (context as Activity).finish()
    }

    val startRoute: NavigationRoute = if (Rewards.license.isLicensed()) {
        NavigationRoute.HOME
    } else {
        NavigationRoute.LICENSE
    }

    NavHost(navController, startRoute.name) {
        composable(NavigationRoute.LICENSE.name) {
            LicenseView(
                onGetEstimate = { navController.navigate(NavigationRoute.TERMS.name) },
                onDismiss = {

                    (context as Activity).finish()
                }
            )
        }
        composable(NavigationRoute.TERMS.name) {
            LicenseTerms(
                onBackButton = { navController.popBackStack() },
                onAccept = {
                    navController.navigate(NavigationRoute.HOME.name)
                }
            )
        }
        composable(NavigationRoute.HOME.name) {
            HomeView(
                onProvider = { prov -> onProvider(prov, navController) },
                onMore = { navController.navigate(NavigationRoute.MORE.name) },
                onDismiss = {
                    finish = true
                    navController.popBackStack(NavigationRoute.HOME.name, true)
                }
            )
        }
        composable(NavigationRoute.MORE.name) {
            MoreView(
                onProvider = { prov -> onProvider(prov, navController) },
                onTerms = { navController.navigate(NavigationRoute.TERMS.name) },
                onDecline = {
                    navController.popBackStack(NavigationRoute.HOME.name, true)
                    navController.navigate(NavigationRoute.LICENSE.name)
                },
                onBackButton = { navController.popBackStack() }
            )
        }
        composable(NavigationRoute.RETAILER.name) {
            RetailerView(
                provider = accountProvider.value!!,
                onBackButton = { navController.popBackStack() }
            )
        }
        composable(NavigationRoute.EMAIL.name) {
            EmailView(
                provider = accountProvider.value!!,
                onBackButton = { navController.popBackStack() }
            )
        }
    }
}

fun onProvider(prov: AccountProvider, navController: NavController) {
    accountProvider.value = prov
    when (prov.type()) {
        AccountType.RETAILER -> navController.navigate(NavigationRoute.RETAILER.name)
        AccountType.EMAIL -> navController.navigate(NavigationRoute.EMAIL.name)
    }
}
