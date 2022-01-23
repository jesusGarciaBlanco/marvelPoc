package com.gbjm.core.api

import com.gbjm.core.model.entity.CharacterListResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v1/public/characters?ts=${Constants.TIME_STAMP}&apikey=${Constants.PUBLIC_KEY}&hash=${Constants.MD5_HASH}")
    suspend fun list(): CharacterListResponse

    @GET("v1/public/characters/{characterId}?ts=${Constants.TIME_STAMP}&apikey=${Constants.PUBLIC_KEY}&hash=${Constants.MD5_HASH}")
    suspend fun getCharacterDetail(@Path("characterId") characterId: Int?): CharacterListResponse

}