package com.xpresspayments.babamovieapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.xpresspayments.babamovieapp.data.BabaMovieAppDatabase
import com.xpresspayments.babamovieapp.data.remote.HeroesMovieApi
import com.xpresspayments.babamovieapp.data.repositoryImpl.DataStoreOperationsImpl
import com.xpresspayments.babamovieapp.domain.repository.DataStoreOperations
import com.xpresspayments.babamovieapp.domain.repository.Repository
import com.xpresspayments.babamovieapp.usecases.UseCases
import com.xpresspayments.babamovieapp.usecases.readOnBoardingUsecase.ReadOnBoardingUseCase
import com.xpresspayments.babamovieapp.usecases.saveOnBoardingUsecase.SaveOnBoardingUseCase
import com.xpresspayments.babamovieapp.util.Constants
import com.xpresspayments.babamovieapp.util.Constants.BABA_MOVIE_APP_DATABASE
import com.xpresspayments.babamovieapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideBabaMovieAppDatabase(application: Application): BabaMovieAppDatabase {
        return Room.databaseBuilder(
            application,
            BabaMovieAppDatabase::class.java,
            BABA_MOVIE_APP_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ) : DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
        )
    }

    private fun provideHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideHeroesMovieApi() : HeroesMovieApi {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(provideHttpClient())
            .build()
            .create(HeroesMovieApi::class.java)
    }
}