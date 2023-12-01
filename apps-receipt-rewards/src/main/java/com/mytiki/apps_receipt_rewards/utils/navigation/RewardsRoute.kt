/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.utils.navigation

enum class RewardsRoute {
    OfferScreen,
    TermsScreen,
    HomeScreen,
    EmailScreen,
    RetailerScreen,
    MoreScreen;

    companion object {
        fun fromRoute(route: String?): RewardsRoute = when (route?.substringBefore("/")) {
            OfferScreen.name -> OfferScreen
            TermsScreen.name -> TermsScreen
            HomeScreen.name -> HomeScreen
            EmailScreen.name -> EmailScreen
            RetailerScreen.name -> RetailerScreen
            MoreScreen.name -> MoreScreen
            null -> OfferScreen
            else -> throw IllegalArgumentException("Route $route is not recognize")
        }
    }
}