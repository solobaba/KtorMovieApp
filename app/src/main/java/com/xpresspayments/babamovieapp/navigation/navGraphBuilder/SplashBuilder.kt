package com.xpresspayments.babamovieapp.navigation.navGraphBuilder

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.xpresspayments.babamovieapp.navigation.ScreenRoute
import com.xpresspayments.babamovieapp.presentation.screens.splash.SplashScreen

fun NavGraphBuilder.splashRoute(navController: NavController) {
    composable(route = ScreenRoute.Splash.route) {
        SplashScreen(navController)
    }
}