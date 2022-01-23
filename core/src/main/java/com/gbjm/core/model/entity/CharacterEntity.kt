package com.gbjm.core.model.entity

data class CharacterEntity(
    val id: Int?,
    val name: String?,
    val description: String?,
    val thumbnail: ThumbnailEntity?,
    val comics: CharacterAppearanceEntity?,
    val series: CharacterAppearanceEntity?,
    val stories: CharacterAppearanceEntity?,
    val events: CharacterAppearanceEntity?
//  val urls: MutableList<CharacterAppearanceEntity>?
)
