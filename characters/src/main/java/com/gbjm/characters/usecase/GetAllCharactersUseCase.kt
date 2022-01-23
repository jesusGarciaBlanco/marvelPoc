package com.gbjm.characters.usecase

import com.gbjm.core.architecture.domain.result.UseCaseResult
import com.gbjm.core.architecture.domain.usecase.SuspendedUseCase
import com.gbjm.core.model.entity.CharacterEntity
import com.gbjm.core.domain.CharacterListRepository
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val repository: CharacterListRepository
) : SuspendedUseCase<Unit, List<CharacterEntity>>() {

    override suspend fun run(params: Unit): UseCaseResult<List<CharacterEntity>> {
        return try {
            val response = repository.getAllCharacters()
            UseCaseResult.Success(response.characterData.results)
        } catch (t: Throwable) {
            UseCaseResult.Error(t)
        }

    }

}