package com.gbjm.marvelpoc.di

import com.gbjm.core.api.ApiService
import com.gbjm.core.domain.CharacterListRepository
import com.gbjm.characters.usecase.GetAllCharactersUseCase
import com.gbjm.detail.usecase.GetCharacterByIdUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    fun providesCharacterListRepository(api: ApiService): CharacterListRepository {
        val repository = CharacterListRepository(api)
        return repository
    }

    @Singleton @Provides fun providesGetAllCharactersUseCase(repository: CharacterListRepository): GetAllCharactersUseCase {
        return GetAllCharactersUseCase(repository)
    }

    @Singleton @Provides fun providesGetCharacterByIdUseCase(repository: CharacterListRepository): GetCharacterByIdUseCase {
        return GetCharacterByIdUseCase(repository)
    }
}