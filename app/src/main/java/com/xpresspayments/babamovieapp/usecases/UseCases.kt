package com.xpresspayments.babamovieapp.usecases

import com.xpresspayments.babamovieapp.usecases.readOnBoardingUsecase.ReadOnBoardingUseCase
import com.xpresspayments.babamovieapp.usecases.saveOnBoardingUsecase.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)