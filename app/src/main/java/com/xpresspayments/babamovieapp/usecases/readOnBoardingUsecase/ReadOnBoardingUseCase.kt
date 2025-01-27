package com.xpresspayments.babamovieapp.usecases.readOnBoardingUsecase

import com.xpresspayments.babamovieapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}