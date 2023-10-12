package com.example.rickmortyproject.model.repository

import com.example.rickmortyproject.model.Character
import com.example.rickmortyproject.model.database.CharacterForListDb
import com.example.rickmortyproject.model.database.ItemsDatabase
import com.example.rickmortyproject.model.dto.LocationDto
import com.example.rickmortyproject.model.retrofit.ApiState
import com.example.rickmortyproject.model.retrofit.RetrofitServices
import com.example.rickmortyproject.utils.mapper.CharacterEpisodeJoinMapper
import com.example.rickmortyproject.utils.mapper.CharacterToDbMapper
import com.example.rickmortyproject.utils.mapper.LocationDbMapper
import com.example.rickmortyproject.utils.mapper.LocationMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LocationDetailsRepository(
    private val mService: RetrofitServices,
    private val database: ItemsDatabase,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun getLocation(locationId: Int): Flow<ApiState<LocationDto>> {
        return flow {
            val location = LocationMapper().transform(mService.getOneLocation(locationId))
            emit(ApiState.success(location))
        }.flowOn(dispatcher)
    }

    suspend fun getCharacterList(charactersId: String): Flow<ApiState<MutableList<Character>>> {
        return flow {
            val characters = mService.getSeveralCharacters(charactersId)
            emit(ApiState.success(characters))
        }.flowOn(dispatcher)
    }

    suspend fun getLocationDb(locationId: Int): Flow<ApiState<LocationDto>> {
        return flow {
            val array: Array<Int> = database.getLocationCharacterJoinDao().getCharactersIdForLocation(locationId)
            val location = LocationDbMapper(array).transform(database.getLocationDao().getOneById(locationId))
                emit(ApiState.success(location))
        }.flowOn(dispatcher)
    }

    suspend fun getCharacterListDb(locationId: Int): Flow<ApiState<MutableList<CharacterForListDb>>> {
        return flow {
            val charactersArray = database.getLocationCharacterJoinDao().getCharactersIdForLocation(locationId)
            val characters = mutableListOf<CharacterForListDb>()
            for (i in charactersArray.indices) {
                characters.add(database.getCharacterDao().getOneForListById(charactersArray[i]))
            }
            emit(ApiState.success(characters))
        }.flowOn(dispatcher)
    }

    suspend fun saveInDb(characterList: MutableList<Character>) {
        database.getCharacterDao().insertAll(CharacterToDbMapper().transform(characterList))
        val listOfCharacterToEpisodes = CharacterEpisodeJoinMapper().transform(characterList)
        database.getCharacterEpisodeJoinDao().insertAll(listOfCharacterToEpisodes)
    }
}