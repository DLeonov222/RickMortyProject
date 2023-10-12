package com.example.rickmortyproject.utils.mapper

interface Mapper<SRC, DTO> {
    fun transform(data: SRC): DTO
}