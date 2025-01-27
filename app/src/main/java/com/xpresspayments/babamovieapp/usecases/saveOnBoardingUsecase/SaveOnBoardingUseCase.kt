package com.xpresspayments.babamovieapp.usecases.saveOnBoardingUsecase

import com.xpresspayments.babamovieapp.domain.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}