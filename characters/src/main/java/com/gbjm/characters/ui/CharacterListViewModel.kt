package com.gbjm.characters.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.gbjm.core.architecture.domain.result.ErrorType
import com.gbjm.core.architecture.domain.result.UseCaseResult
import com.gbjm.characters.ui.entity.UiCharacterRow
import com.gbjm.characters.ui.mapper.CharacterListMapper
import com.gbjm.characters.usecase.GetAllCharactersUseCase
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    val context: Context,
    private val characterListMapper : CharacterListMapper,
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
) : ViewModel() {

    val _uiCharacterList = MutableLiveData<List<UiCharacterRow>>()
    val uiCharacterList: LiveData<List<UiCharacterRow>>
        get() = _uiCharacterList

    val _uiError = MutableLiveData<String>()
    val uiError: LiveData<String>
        get() = _uiError


    fun onListNeeded() {
        getAllCharactersUseCase(Unit) { result ->
            when (result) {
                is UseCaseResult.Success -> {
                    result.data?.let {
                        val uiCharactersList = characterListMapper.mapFrom(it).filterNotNull()
                        _uiCharacterList.value = uiCharactersList
                    }
                }

                is UseCaseResult.Error -> {
                    _uiError.value = "error getting marvel characters list"
                }
            }
        }
    }
}