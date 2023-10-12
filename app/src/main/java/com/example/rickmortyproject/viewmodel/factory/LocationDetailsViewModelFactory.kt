package com.example.rickmortyproject.viewmodel.factory


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.model.repository.LocationDetailsRepository
import com.example.rickmortyproject.utils.InternetConnectionChecker
import com.example.rickmortyproject.viewmodel.LocationDetailsViewModel
import kotlinx.coroutines.CoroutineDispatcher

@ExperimentalPagingApi
class LocationDetailsViewModelFactory(
    private val locationID: Int,
    val repository: LocationDetailsRepository,
    private val internetChecker: InternetConnectionChecker,
    private val dispatcher: CoroutineDispatcher
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LocationDetailsViewModel(locationID, repository, internetChecker, dispatcher) as T
    }
}