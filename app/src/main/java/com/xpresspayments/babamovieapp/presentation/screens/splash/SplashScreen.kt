package com.xpresspayments.babamovieapp.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.xpresspayments.babamovieapp.R
import com.xpresspayments.babamovieapp.navigation.ScreenRoute
import com.xpresspayments.babamovieapp.ui.theme.Purple500
import com.xpresspayments.babamovieapp.ui.theme.Purple700

@Composable
fun SplashScreen(
    navController: NavController,
    splashScreenViewModel: SplashScreenViewModel = hiltViewModel()
) {

    val onBoardingCompleted by splashScreenViewModel.onBoardingCompleted.collectAsState()
    val rotateLogo = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        rotateLogo.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )

        navController.popBackStack()

        if (onBoardingCompleted) {
            navController.navigate(ScreenRoute.Home.route)
        } else {
            navController.navigate(ScreenRoute.Welcome.route)
        }
    }

    Splash(rotateLogo.value)
}

@Composable
fun Splash(rotateLogo: Float) {
    if (isSystemInDarkTheme()) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(degrees = rotateLogo),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .background(Brush.verticalGradient(listOf(Purple700, Purple500)))
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(degrees = rotateLogo),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo)
            )
        }
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(rotateLogo = 0f)
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashScreenDarkPreview() {
    Splash(rotateLogo = 0f)
}