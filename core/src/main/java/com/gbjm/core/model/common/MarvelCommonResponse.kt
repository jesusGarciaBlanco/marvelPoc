package com.gbjm.core.model.common

open class MarvelCommonResponse(
    protected var code: Int = 0,
    protected var status: String = "",
) {
    fun isSuccess(): Boolean {
        return code == 200
    }

    fun getErrorMessage(): String {
        return status
    }
}