package com.gbjm.detail

import com.gbjm.core.model.entity.CharacterAppearanceDetailItem
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

    fun checkCharacterAppearanceComicsMapper(){
        Assert.assertEquals(characterEntityUi?.comics?.get(0)?.name, characterEntity.comics?.items?.get(0)?.name)
        Assert.assertEquals(characterEntityUi?.comics?.get(0)?.type, characterEntity.comics?.items?.get(0)?.type)
        Assert.assertEquals(characterEntityUi?.comics?.get(0)?.url, characterEntity.comics?.items?.get(0)?.url)
    }

    fun checkCharacterAppearanceSeriesMapper(){
        Assert.assertEquals(characterEntityUi?.series?.get(0)?.name, characterEntity.series?.items?.get(0)?.name)
        Assert.assertEquals(characterEntityUi?.series?.get(0)?.type, characterEntity.series?.items?.get(0)?.type)
        Assert.assertEquals(characterEntityUi?.series?.get(0)?.url, characterEntity.series?.items?.get(0)?.url)
    }

    fun checkCharacterAppearanceStoriesMapper(){
        Assert.assertEquals(characterEntityUi?.stories?.get(0)?.name, characterEntity.stories?.items?.get(0)?.name)
        Assert.assertEquals(characterEntityUi?.stories?.get(0)?.type, characterEntity.stories?.items?.get(0)?.type)
        Assert.assertEquals(characterEntityUi?.stories?.get(0)?.url, characterEntity.stories?.items?.get(0)?.url)
    }

    fun checkCharacterAppearanceEventsMapper(){
        Assert.assertEquals(characterEntityUi?.events?.get(0)?.name, characterEntity.events?.items?.get(0)?.name)
        Assert.assertEquals(characterEntityUi?.events?.get(0)?.type, characterEntity.events?.items?.get(0)?.type)
        Assert.assertEquals(characterEntityUi?.events?.get(0)?.url, characterEntity.events?.items?.get(0)?.url)
    }

    @Test
    fun checkCharacterAppearanceMapper(){
        checkCharacterAppearanceComicsMapper()
        checkCharacterAppearanceSeriesMapper()
        checkCharacterAppearanceStoriesMapper()
        checkCharacterAppearanceEventsMapper()
    }


    //method create and return a mocked character Entity
    fun mockCharacterEntity() = CharacterEntity(
        id = 1011334,
        name = "3-D Man",
        description = "",
        thumbnail = ThumbnailEntity(path = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784", extension = "jpg"),
        comics = CharacterAppearanceEntity(available = 12, collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/comics",items = mutableListOf(
            CharacterAppearanceDetailItem(resourceUri = "http://gateway.marvel.com/v1/public/comics/1945", name= "Avengers: The Initiative (2007) #14", "comic", "pruebaComic")
        )),
        series = CharacterAppearanceEntity(available = 12, collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/series",items = mutableListOf(
            CharacterAppearanceDetailItem(resourceUri = "http://gateway.marvel.com/v1/public/series/1945", name= "Avengers: The Initiative (2007 - 2010)", "serie", "pruebaSerie")
        )),
        stories = CharacterAppearanceEntity(available = 12, collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/stories",items = mutableListOf(
            CharacterAppearanceDetailItem(resourceUri = "http://gateway.marvel.com/v1/public/stories/19947", name= "Cover #19947", "cover", "pruebaStory")
        )),
        events = CharacterAppearanceEntity(available = 12, collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/events",items = mutableListOf(
            CharacterAppearanceDetailItem(resourceUri = "http://gateway.marvel.com/v1/public/events/269", name= "Secret Invasion", "cover", "pruebaEvent")
        ))
    )
}