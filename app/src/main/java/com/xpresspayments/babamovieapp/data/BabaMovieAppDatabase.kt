package com.xpresspayments.babamovieapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xpresspayments.babamovieapp.data.local.HeroDao
import com.xpresspayments.babamovieapp.data.local.HeroRemoteKeyDao
import com.xpresspayments.babamovieapp.domain.model.Hero
import com.xpresspayments.babamovieapp.domain.model.HeroRemoteKey

@Database(
    entities = [
        Hero::class,
        HeroRemoteKey::class
    ], version = 1
)
@TypeConverters(DataBaseConverter::class)
abstract class BabaMovieAppDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}