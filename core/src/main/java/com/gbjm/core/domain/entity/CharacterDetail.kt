package com.gbjm.core.domain.entity

import com.gbjm.core.model.entity.CharacterAppearanceEntity
import com.gbjm.core.model.entity.CharacterEntity

enum class imageSize(val size: String) {
    PORTRAIT_SMALL("portrait_small"),
    STANDARD_MEDIUM("standard_medium"),
    LANDSCAPE_LARGE("landscape_large")
}

data class CharacterDetail(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String?,
    val detailThumbnail: String?,
    val comics: CharacterAppearanceEntity?,
    val series: CharacterAppearanceEntity?,
    val stories: CharacterAppearanceEntity?,
    val events: CharacterAppearanceEntity?
//  val urls: MutableList<CharacterAppearanceEntity>?
)

fun CharacterEntity.toDomain(): CharacterDetail {
    var thumbnailConcatenation : String? = null
    var detailThumbnailConcatenation: String? = null
    if (!thumbnail?.path.isNullOrEmpty() && !thumbnail?.extension.isNullOrEmpty()){
        thumbnailConcatenation = "${thumbnail?.path}/${imageSize.STANDARD_MEDIUM.size}.${thumbnail?.extension}"
        detailThumbnailConcatenation = "${thumbnail?.path}/${imageSize.LANDSCAPE_LARGE.size}.${thumbnail?.extension}"
    }
    return CharacterDetail(id ?: -1,
        name ?: "",
        description?:"",
        thumbnailConcatenation,
        detailThumbnailConcatenation,
        comics,
        series,
        stories,
        events
//    urls
    )
}
