package com.xpresspayments.babamovieapp.domain.model

import androidx.annotation.DrawableRes
import com.xpresspayments.babamovieapp.R

sealed class OnboardingLayout(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
) {
    object FirstOnboardingScreen: OnboardingLayout(
        image = R.drawable.greetings,
        title = "Greeting",
        description = "Are you a Solobaba Movie fan? Because if you are then we have a great news for you!"
    )

    object SecondOnboardingScreen: OnboardingLayout(
        image = R.drawable.explore,
        title = "Explore",
        description = "Find your favorite heroes and learn some of the things that you didn't know about."
    )

    object ThirdOnboardingScreen: OnboardingLayout(
        image = R.drawable.power,
        title = "Power",
        description = "Check out your hero's power and  see how much are they strong comparing to others."
    )
}