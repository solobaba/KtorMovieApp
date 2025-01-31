package com.xpresspayments.babamovieapp.data.pagingSource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.xpresspayments.babamovieapp.data.BabaMovieAppDatabase
import com.xpresspayments.babamovieapp.data.remote.HeroesMovieApi
import com.xpresspayments.babamovieapp.domain.model.Hero
import com.xpresspayments.babamovieapp.domain.model.HeroRemoteKeys
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class HeroRemoteMediator @Inject constructor(
    private val heroesMovieApi: HeroesMovieApi,
    private val babaMovieAppDatabase: BabaMovieAppDatabase
): RemoteMediator<Int, Hero>() {

    private val heroDao = babaMovieAppDatabase.heroDao()
    private val heroRemoteKeysDao = babaMovieAppDatabase.heroRemoteKeysDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hero>): MediatorResult {
        return try {
            val response = heroesMovieApi.getAllHeroes(page = 1)

            if (response.heroes.isNotEmpty()) {
                babaMovieAppDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        heroDao.deleteAllHeroes()
                        heroRemoteKeysDao.deleteAllRemoteKeys()
                    }
                    val prevPage = response.prevPage
                    val nextPage = response.nextPage
                    val keys = response.heroes.map { hero ->
                        HeroRemoteKeys(
                            id = hero.id,
                            prevPage = prevPage,
                            nextPage = nextPage
                        )
                    }
                    heroRemoteKeysDao.addAllRemoteKeys(heroRemoteKey = keys)
                    heroDao.addHeroes(heroes = response.heroes)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }
}