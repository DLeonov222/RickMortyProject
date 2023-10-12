package com.example.rickmortyproject.utils.mapper

import com.example.rickmortyproject.model.Character
import com.example.rickmortyproject.model.database.CharacterForListDb
import com.example.rickmortyproject.model.dto.CharacterForListDto

class CharacterForListMapper : Mapper<List<Character>, MutableList<CharacterForListDto>> {
    override fun transform(data: List<Character>): MutableList<CharacterForListDto> {
        val newMutableList = mutableListOf<CharacterForListDto>()
        for (character in data) {
            newMutableList.add(CharacterForListDto(
                id = character.id,
                name = character.name,
                status = character.status,
                species = character.species,
                gender = character.gender,
                image = character.image
            ))
        }
        return newMutableList
    }
}

class CharacterForListDbMapper : Mapper<List<CharacterForListDb>, MutableList<CharacterForListDto>> {
    override fun transform(data: List<CharacterForListDb>): MutableList<CharacterForListDto> {
        val newMutableList = mutableListOf<CharacterForListDto>()
        for (character in data) {
            if (character != null) {
                newMutableList.add(CharacterForListDto(
                    id = character.id,
                    name = character.name,
                    status = character.status,
                    species = character.species,
                    gender = character.gender,
                    image = character.image
                ))
            }
        }
        return newMutableList
    }

}