package com.xpresspayments.babamovieapp.navigation.navGraphBuilder

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.xpresspayments.babamovieapp.navigation.ScreenRoute
import com.xpresspayments.babamovieapp.presentation.screens.home.HomeScreen

fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(route = ScreenRoute.Home.route) {
        HomeScreen(navController)
    }
}