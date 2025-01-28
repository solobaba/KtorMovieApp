package com.xpresspayments.babamovieapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class HeroesMovieResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero> = emptyList(),
    val lastUpdated: Long? = null
)
