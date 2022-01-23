package com.gbjm.core.domain

import com.gbjm.core.api.ApiService
import com.gbjm.core.model.entity.CharacterListResponse

class CharacterListRepository(private val api: ApiService) {

    suspend fun getAllCharacters() : CharacterListResponse {
        return api.list()
    }

    suspend fun getCharacterById(characterId: Int): CharacterListResponse {
        return api.getCharacterDetail(characterId)
    }
}