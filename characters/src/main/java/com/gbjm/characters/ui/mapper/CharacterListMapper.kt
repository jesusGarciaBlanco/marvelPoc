package com.gbjm.characters.ui.mapper

import com.gbjm.core.architecture.mapper.ListMapper
import com.gbjm.core.architecture.mapper.Mapper
import com.gbjm.core.domain.entity.imageSize
import com.gbjm.core.model.entity.CharacterEntity
import com.gbjm.characters.ui.entity.UiCharacterRow
import javax.inject.Inject

/**
 * CharacterEntity list mapper
 */
class CharacterListMapper @Inject constructor() : ListMapper<CharacterEntity, UiCharacterRow?>() {
    override val mapper: Mapper<CharacterEntity, UiCharacterRow?>
        get() = CharacterRowMapper()
}

/**
 * Character type mapper
 */
class CharacterRowMapper @Inject constructor() : Mapper<CharacterEntity, UiCharacterRow?>() {
    /**
     * map CharacterEntity to UiCharacterRow
     * @param from the CharacterEntity retrieved from server
     */
    override fun mapFrom(from: CharacterEntity): UiCharacterRow? {
        val id = from.id
        val name = from.name
        val description = from.description
        var thumbnailConcatenation = ""
        if (!from.thumbnail?.path.isNullOrEmpty() && !from.thumbnail?.extension.isNullOrEmpty()) {
            thumbnailConcatenation =
                "${from.thumbnail?.path}/${imageSize.STANDARD_MEDIUM.size}.${from.thumbnail?.extension}"
        }

        return UiCharacterRow(
            id ?: -1,
            name ?: "",
            description?:"",
            thumbnailConcatenation
        )
    }
}