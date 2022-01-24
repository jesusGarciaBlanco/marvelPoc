package com.gbjm.detail

import com.gbjm.core.model.entity.CharacterAppearanceEntity
import com.gbjm.core.model.entity.CharacterEntity
import com.gbjm.core.model.entity.ThumbnailEntity
import com.gbjm.detail.ui.mapper.CharacterAppearanceMapper
import com.gbjm.detail.ui.mapper.CharacterDetailHeaderMapper
import com.gbjm.detail.ui.mapper.CharacterDetailMapper
import org.junit.Assert
import org.junit.Test

class MapperDetailTest {
    val headerDetailMapper = CharacterDetailHeaderMapper()
    val appearanceDetailMapper = CharacterAppearanceMapper()
    val characterDetailMapper = CharacterDetailMapper(headerDetailMapper, appearanceDetailMapper)

    val characterEntity = mockCharacterEntity()

    val characterEntityUi = characterDetailMapper.mapFrom(characterEntity)

    @Test
    fun checkHeaderCharacterDetailMapper(){
        Assert.assertEquals(characterEntityUi?.header?.title, characterEntity.name)
        Assert.assertEquals(characterEntityUi?.header?.description, characterEntity.description)
        Assert.assertEquals(characterEntityUi?.header?.image, "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/landscape_large.jpg")
    }

    fun mockCharacterEntity() = CharacterEntity(
        id = 1011334,
        name = "3-D Man",
        description = "",
        thumbnail = ThumbnailEntity(path = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784", extension = "jpg"),
        comics = CharacterAppearanceEntity(available = 12, collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/comics",items = mutableListOf()),
        series = CharacterAppearanceEntity(available = 12, collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/series",items = mutableListOf()),
        stories = CharacterAppearanceEntity(available = 12, collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/stories",items = mutableListOf()),
        events = CharacterAppearanceEntity(available = 12, collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/events",items = mutableListOf())
    )
}