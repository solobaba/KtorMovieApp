package com.xpresspayments.babamovieapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.xpresspayments.babamovieapp.data.BabaMovieAppDatabase
import com.xpresspayments.babamovieapp.data.repositoryImpl.DataStoreOperationsImpl
import com.xpresspayments.babamovieapp.domain.repository.DataStoreOperations
import com.xpresspayments.babamovieapp.util.Constants.BABA_MOVIE_APP_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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
}