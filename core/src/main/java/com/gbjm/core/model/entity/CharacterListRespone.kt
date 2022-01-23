package com.gbjm.core.model.entity

import com.gbjm.core.model.common.MarvelCommonResponse
import com.google.gson.annotations.SerializedName

class CharacterListResponse(@SerializedName("data") val characterData: CharacterDataEntity): MarvelCommonResponse()
