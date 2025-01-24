package com.xpresspayments.babamovieapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.xpresspayments.babamovieapp.navigation.navGraphBuilder.homeRoute
import com.xpresspayments.babamovieapp.navigation.navGraphBuilder.movieDetailsRoute
import com.xpresspayments.babamovieapp.navigation.navGraphBuilder.searchRoute
import com.xpresspayments.babamovieapp.navigation.navGraphBuilder.splashRoute
import com.xpresspayments.babamovieapp.navigation.navGraphBuilder.welcomeRoute

@Composable
fun BabaMoviesAppNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.Welcome.route
    ) {
        splashRoute(navController)
        welcomeRoute(navController)
        homeRoute(navController)
        movieDetailsRoute(navController)
        searchRoute(navController)
    }
}