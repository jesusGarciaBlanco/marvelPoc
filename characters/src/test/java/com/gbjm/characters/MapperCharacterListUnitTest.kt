package com.gbjm.characters

import com.gbjm.characters.ui.mapper.CharacterListMapper
import com.gbjm.core.model.entity.CharacterAppearanceDetailItem
import com.gbjm.core.model.entity.CharacterAppearanceEntity
import com.gbjm.core.model.entity.CharacterEntity
import com.gbjm.core.model.entity.ThumbnailEntity
import org.junit.Assert
import org.junit.Test

class MapperCharacterListUnitTest {
    val characterListMapper = CharacterListMapper()

    val characterEntityList = mockCharacterEntityList()

    val characterEntityListUi = characterListMapper.mapFrom(characterEntityList)

    @Test
    fun checkCharacterListMapper(){
        Assert.assertEquals(characterEntityListUi[0]?.id, characterEntityList[0].id)
        Assert.assertEquals(characterEntityListUi[0]?.name, characterEntityList[0].name)
        Assert.assertEquals(characterEntityListUi[0]?.description, characterEntityList[0].description)
        Assert.assertEquals(characterEntityListUi[0]?.image, "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/standard_medium.jpg")

        Assert.assertEquals(characterEntityListUi[1]?.id, characterEntityList[1].id)
        Assert.assertEquals(characterEntityListUi[1]?.name, characterEntityList[1].name)
        Assert.assertEquals(characterEntityListUi[1]?.description, characterEntityList[1].description)
        Assert.assertEquals(characterEntityListUi[1]?.image, "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16/standard_medium.jpg")
    }


    //method create and return a mocked character Entity
    fun mockCharacterEntityList(): List<CharacterEntity> {
        val characterMan = CharacterEntity(
            id = 1011334,
            name = "3-D Man",
            description = "",
            thumbnail = ThumbnailEntity(
                path = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
                extension = "jpg"
            ),
            comics = CharacterAppearanceEntity(
                available = 12,
                collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/comics",
                items = mutableListOf(
                    CharacterAppearanceDetailItem(
                        resourceUri = "http://gateway.marvel.com/v1/public/comics/1945",
                        name = "Avengers: The Initiative (2007) #14",
                        "comic",
                        "pruebaComic"
                    )
                )
            ),
            series = CharacterAppearanceEntity(
                available = 12,
                collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/series",
                items = mutableListOf(
                    CharacterAppearanceDetailItem(
                        resourceUri = "http://gateway.marvel.com/v1/public/series/1945",
                        name = "Avengers: The Initiative (2007 - 2010)",
                        "serie",
                        "pruebaSerie"
                    )
                )
            ),
            stories = CharacterAppearanceEntity(
                available = 12,
                collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/stories",
                items = mutableListOf(
                    CharacterAppearanceDetailItem(
                        resourceUri = "http://gateway.marvel.com/v1/public/stories/19947",
                        name = "Cover #19947",
                        "cover",
                        "pruebaStory"
                    )
                )
            ),
            events = CharacterAppearanceEntity(
                available = 12,
                collectionUri = "http://gateway.marvel.com/v1/public/characters/1011334/events",
                items = mutableListOf(
                    CharacterAppearanceDetailItem(
                        resourceUri = "http://gateway.marvel.com/v1/public/events/269",
                        name = "Secret Invasion",
                        "cover",
                        "pruebaEvent"
                    )
                )
            )
        )

        val characterBomb = CharacterEntity(
            id = 1017100,
            name = "A-Bomb (HAS)",
            description = "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ",
            thumbnail = ThumbnailEntity(
                path = "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16",
                extension = "jpg"
            ),
            comics = CharacterAppearanceEntity(
                available = 1,
                collectionUri ="http://gateway.marvel.com/v1/public/characters/1017100/comics",
                items = mutableListOf(
                    CharacterAppearanceDetailItem(
                        resourceUri = "http://gateway.marvel.com/v1/public/comics/47176",
                        name = "FREE COMIC BOOK DAY 2013 1 (2013) #1",
                        "comic",
                        "pruebaComic"
                    )
                )
            ),
            series = CharacterAppearanceEntity(
                available = 1,
                collectionUri = "http://gateway.marvel.com/v1/public/characters/1017100/series",
                items = mutableListOf(
                    CharacterAppearanceDetailItem(
                        resourceUri = "http://gateway.marvel.com/v1/public/series/17765",
                        name = "FREE COMIC BOOK DAY 2013 1 (2013)",
                        "serie",
                        "pruebaSerie"
                    )
                )
            ),
            stories = CharacterAppearanceEntity(
                available = 1,
                collectionUri = "http://gateway.marvel.com/v1/public/characters/1017100/stories",
                items = mutableListOf(
                    CharacterAppearanceDetailItem(
                        resourceUri = "http://gateway.marvel.com/v1/public/stories/92078",
                        name = "Hulk (2008) #55",
                        "cover",
                        "pruebaStory"
                    )
                )
            ),
            events = CharacterAppearanceEntity(
                available = 1,
                collectionUri = "http://gateway.marvel.com/v1/public/characters/1017100/events",
                items = mutableListOf(
                    CharacterAppearanceDetailItem(
                        resourceUri = "http://gateway.marvel.com/v1/public/characters/1017100/events",
                        name = "Hulk (2010) #99",
                        "cover",
                        "pruebaEvent"
                    )
                )
            )
        )
        return listOf(characterMan, characterBomb)
    }
}