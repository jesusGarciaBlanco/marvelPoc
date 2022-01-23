package com.gbjm.detail.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gbjm.core.architecture.domain.result.UseCaseResult
import com.gbjm.detail.ui.entity.UiCharacterDetail
import com.gbjm.detail.ui.mapper.CharacterDetailMapper
import com.gbjm.detail.usecase.GetCharacterByIdUseCase
import javax.inject.Inject

class CharacterDetailViewModel @Inject constructor(
    val context: Context,
    private val detailMapper : CharacterDetailMapper,
    private val getCharacterDetail: GetCharacterByIdUseCase,
) : ViewModel() {

    val _uiCharacterDetail = MutableLiveData<UiCharacterDetail>()
    val uiCharacterDetail: LiveData<UiCharacterDetail>
        get() = _uiCharacterDetail

    val _uiError = MutableLiveData<String>()
    val uiError: LiveData<String>
        get() = _uiError


    fun onCharacterDetailNeeded(characterId: Int) {
        getCharacterDetail(characterId) { result ->
            when (result) {
                is UseCaseResult.Success -> {
                    result.data?.let {
                        val uiCharactersDetail = detailMapper.mapFrom(it)
                        if (uiCharactersDetail!=null) {
                            _uiCharacterDetail.value = uiCharactersDetail!!
                        }
                    }
                }

                is UseCaseResult.Error -> {
                    _uiError.value = "error getting marvel character detail"
                }
            }
        }
    }
}
