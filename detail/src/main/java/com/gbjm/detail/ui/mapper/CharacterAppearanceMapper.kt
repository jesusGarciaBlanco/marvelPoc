package com.gbjm.detail.ui.mapper

import com.gbjm.core.architecture.mapper.Mapper
import com.gbjm.core.model.entity.CharacterAppearanceDetailItem
import com.gbjm.detail.ui.entity.UiAppearanceRow
import javax.inject.Inject

class CharacterAppearanceMapper @Inject constructor() :
    Mapper<CharacterAppearanceDetailItem, UiAppearanceRow>() {
    /**
     * map CharacterEntity to UiCharacterRow
     * @param from the CharacterEntity retrieved from server
     */
    override fun mapFrom(from: CharacterAppearanceDetailItem): UiAppearanceRow {
        return UiAppearanceRow(from.name, from.type, from.url)
    }
}