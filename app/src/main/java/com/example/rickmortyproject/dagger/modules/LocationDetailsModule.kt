package com.example.rickmortyproject.dagger.modules

import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.model.repository.LocationDetailsRepository
import com.example.rickmortyproject.utils.InternetConnectionChecker
import com.example.rickmortyproject.viewmodel.factory.LocationDetailsViewModelFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@ExperimentalPagingApi
@Module
class LocationDetailsModule {

    @Provides
    fun provideLocationDetailsViewModelFactory(locationId: Int, repository: LocationDetailsRepository, internetChecker: InternetConnectionChecker, dispatcher: CoroutineDispatcher): LocationDetailsViewModelFactory {
        return LocationDetailsViewModelFactory(locationId, repository, internetChecker, dispatcher)
    }
}