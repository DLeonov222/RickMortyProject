package com.example.rickmortyproject.utils.mapper

import com.example.rickmortyproject.model.Location
import com.example.rickmortyproject.model.database.LocationForListDb
import com.example.rickmortyproject.model.dto.LocationForListDto

class LocationForListMapper : Mapper<Location, LocationForListDto> {
    override fun transform(data: Location): LocationForListDto {
        return LocationForListDto(
            id = data.id,
            name = data.name,
            type = data.type,
            dimension = data.dimension
        )
    }
}

class LocationForListDbMapper : Mapper<LocationForListDb, LocationForListDto> {
    override fun transform(data: LocationForListDb): LocationForListDto {
        return LocationForListDto(
            id = data.id,
            name = data.name,
            type = data.type,
            dimension = data.dimension
        )
    }

}