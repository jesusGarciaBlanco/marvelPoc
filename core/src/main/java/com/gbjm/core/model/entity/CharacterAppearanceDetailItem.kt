package com.gbjm.core.model.entity

import com.google.gson.annotations.SerializedName

data class CharacterAppearanceDetailItem (
    @SerializedName ("resourceURI" ) val resourceUri: String?,
    val name: String?,
    val type: String?,
    val url: String?
)
