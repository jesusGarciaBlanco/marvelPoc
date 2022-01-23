package com.gbjm.core.domain.entity

import com.gbjm.core.model.entity.CharacterListResponse
import kotlin.collections.List

data class CharacterList(
    val characters: List<CharacterDetail>)

fun CharacterListResponse.toDomain() = CharacterList(characterData.results.map { it.toDomain() })