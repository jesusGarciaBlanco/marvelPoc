package com.gbjm.marvelpoc.di

import com.gbjm.core.api.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Provides network services for data
 */

@Module(includes = [NetworkModule::class])
class NetworkServiceModule {
    @Provides
    fun provideMarvelCharacterService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}