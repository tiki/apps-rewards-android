package com.mytiki.apps_receipt_rewards.ui.composable.navigation

enum class RewardsRoute {
    OfferScreen;

    companion object {
        fun fromRoute(route: String?): RewardsRoute
            = when(route?.substringBefore("/")){
            OfferScreen.name -> OfferScreen
            null -> OfferScreen
            else -> throw IllegalArgumentException("Route $route is not recognize")
            }
    }
}