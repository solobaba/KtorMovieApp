package com.xpresspayments.babamovieapp.data.remote

import com.xpresspayments.babamovieapp.domain.model.HeroesMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroesMovieApi {
    @GET("/solobaba/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): HeroesMovieResponse

    @GET("/solobaba/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): HeroesMovieResponse
}