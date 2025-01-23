package com.xpresspayments.babamovieapp.di

import android.app.Application
import androidx.room.Room
import com.xpresspayments.babamovieapp.data.BabaMovieAppDatabase
import com.xpresspayments.babamovieapp.util.Constants.BABA_MOVIE_APP_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
}