package com.gbjm.core.model.entity

data class CharacterDataEntity(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharacterEntity>
)