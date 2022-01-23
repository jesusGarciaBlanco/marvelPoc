package com.gbjm.core.model.entity

import com.google.gson.annotations.SerializedName

data class CharacterAppearanceEntity (
    val available: Int?,
    @SerializedName("collectionURI") val collectionUri: String?,
    val items: MutableList<CharacterAppearanceDetailItem>?
)
