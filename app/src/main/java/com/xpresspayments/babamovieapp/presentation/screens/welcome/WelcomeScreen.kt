package com.xpresspayments.babamovieapp.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//import com.google.accompanist.pager.*
import androidx.compose.foundation.pager.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.xpresspayments.babamovieapp.R
import com.xpresspayments.babamovieapp.domain.model.OnboardingLayout
import com.xpresspayments.babamovieapp.ui.theme.EXTRA_LARGE_PADDING
import com.xpresspayments.babamovieapp.ui.theme.PAGING_INDICATOR_SPACING
import com.xpresspayments.babamovieapp.ui.theme.PAGING_INDICATOR_WIDTH
import com.xpresspayments.babamovieapp.ui.theme.Purple500
import com.xpresspayments.babamovieapp.ui.theme.Purple700
import com.xpresspayments.babamovieapp.ui.theme.SMALL_PADDING
import com.xpresspayments.babamovieapp.util.Constants.LAST_ON_BOARDING_PAGE
import com.xpresspayments.babamovieapp.util.Constants.ON_BOARDING_PAGE_COUNT

@Composable
fun WelcomeScreen(navController: NavController) {
    val pages = listOf(
        OnboardingLayout.FirstOnboardingScreen,
        OnboardingLayout.SecondOnboardingScreen,
        OnboardingLayout.ThirdOnboardingScreen,
    )

    val pagerState = rememberPagerState { ON_BOARDING_PAGE_COUNT }
    val pagerIndicatorState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = if (isSystemInDarkTheme()) {
                    Color.Black
                } else {
                    Color.White
                }
            )
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { pagePosition ->
            PagerScreen(onboardingLayout = pages[pagePosition])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(3f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerIndicatorState,
            pageCount = 3,
            activeColor = if (isSystemInDarkTheme()) {
                Color.White
            } else {
                Color.Red
            },
            inactiveColor = if (isSystemInDarkTheme()) {
                Color.LightGray
            } else {
                Color.DarkGray
            },
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING
        )
        OnboardingFinishButton(
            modifier = Modifier.weight(3f),
            pagerState = pagerState
        ) { }
    }
}

@Composable
fun PagerScreen(onboardingLayout: OnboardingLayout) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onboardingLayout.image),
            contentDescription = stringResource(R.string.on_boarding_image)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onboardingLayout.title,
            color = if (isSystemInDarkTheme()) {
                Color.White
            } else {
                Color.DarkGray
            },
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onboardingLayout.description,
            color = if (isSystemInDarkTheme()) {
                Color.White
            } else {
                Color.DarkGray.copy(alpha = 0.5f)
            },
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OnboardingFinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == LAST_ON_BOARDING_PAGE
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSystemInDarkTheme()) {
                        Purple700
                    } else {
                        Purple500
                    },
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = stringResource(R.string.finish),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FirstOnboardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onboardingLayout = OnboardingLayout.FirstOnboardingScreen)
    }
}

@Composable
@Preview(showBackground = true)
fun SecondOnboardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onboardingLayout = OnboardingLayout.SecondOnboardingScreen)
    }
}

@Composable
@Preview(showBackground = true)
fun ThirdOnboardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onboardingLayout = OnboardingLayout.ThirdOnboardingScreen)
    }
}