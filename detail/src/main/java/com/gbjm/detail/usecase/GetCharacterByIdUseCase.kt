package com.gbjm.detail.usecase

import com.gbjm.core.architecture.domain.result.UseCaseResult
import com.gbjm.core.architecture.domain.usecase.SuspendedUseCase
import com.gbjm.core.model.entity.CharacterEntity
import com.gbjm.core.domain.CharacterListRepository
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: CharacterListRepository
) : SuspendedUseCase<Int, CharacterEntity>() {

    override suspend fun run(params: Int): UseCaseResult<CharacterEntity> {
        return try {
            val response = repository.getCharacterById(params)
            UseCaseResult.Success(response.characterData.results[0])
        } catch (t: Throwable) {
            UseCaseResult.Error(t)
        }

    }

}