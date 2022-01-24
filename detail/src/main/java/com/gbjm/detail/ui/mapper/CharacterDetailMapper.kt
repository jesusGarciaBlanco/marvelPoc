package com.gbjm.detail.ui.mapper

import com.gbjm.core.architecture.mapper.Mapper
import com.gbjm.core.model.entity.CharacterEntity
import com.gbjm.detail.ui.entity.UiAppearanceRow
import com.gbjm.detail.ui.entity.UiCharacterDetail
import javax.inject.Inject

class CharacterDetailMapper @Inject constructor(
    val headerMapper: CharacterDetailHeaderMapper,
    val appearanceRowMapper: CharacterAppearanceMapper
) : Mapper<CharacterEntity, UiCharacterDetail?>() {
    /**
     * map CharacterEntity to UiCharacterRow
     * @param from the CharacterEntity retrieved from server
     */
    override fun mapFrom(from: CharacterEntity): UiCharacterDetail? {
        val headerDetail = headerMapper.mapFrom(from)

        val comicsList = mutableListOf<UiAppearanceRow>()
        from.comics?.items?.forEach {
            comicsList.add(appearanceRowMapper.mapFrom(it))
        }

        val seriesList = mutableListOf<UiAppearanceRow>()
        from.series?.items?.forEach {
            seriesList.add(appearanceRowMapper.mapFrom(it))
        }

        val storiesList = mutableListOf<UiAppearanceRow>()
        from.stories?.items?.forEach {
            storiesList.add(appearanceRowMapper.mapFrom(it))
        }

        val eventsList = mutableListOf<UiAppearanceRow>()
        from.events?.items?.forEach {
            eventsList.add(appearanceRowMapper.mapFrom(it))
        }

        return UiCharacterDetail(
            headerDetail,
            comicsList,
            seriesList,
            eventsList,
            storiesList
        )
    }
}