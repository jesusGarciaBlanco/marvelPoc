package com.gbjm.detail.ui.mapper

import com.gbjm.core.architecture.mapper.Mapper
import com.gbjm.core.domain.entity.imageSize
import com.gbjm.core.model.entity.CharacterEntity
import com.gbjm.detail.ui.entity.UiDetailHeader
import javax.inject.Inject

/**
 * Character type mapper
 */
class CharacterDetailHeaderMapper @Inject constructor() : Mapper<CharacterEntity, UiDetailHeader>() {
    /**
     * map CharacterEntity to UiCharacterRow
     * @param from the CharacterEntity retrieved from server
     */
    override fun mapFrom(from: CharacterEntity): UiDetailHeader {
        val name = from.name
        val description = from.description
        var detailThumbnailConcatenation: String? = null
        if (!from.thumbnail?.path.isNullOrEmpty() && !from.thumbnail?.extension.isNullOrEmpty()) {
            detailThumbnailConcatenation = "${from.thumbnail?.path}/${imageSize.LANDSCAPE_LARGE.size}.${from.thumbnail?.extension}"
        }

        return UiDetailHeader(
            detailThumbnailConcatenation ?: "",
            name ?: "",
            description?:"",

            )
    }
}