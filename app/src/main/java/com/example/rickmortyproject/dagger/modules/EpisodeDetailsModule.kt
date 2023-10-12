package com.example.rickmortyproject.dagger.modules

import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.model.repository.EpisodeDetailsRepository
import com.example.rickmortyproject.utils.InternetConnectionChecker
import com.example.rickmortyproject.viewmodel.factory.EpisodeDetailsViewModelFactory
import dagger.Module
import dagger.Provides

@ExperimentalPagingApi
@Module
class EpisodeDetailsModule {

    @Provides
    fun provideEpisodeDetailsViewModelFactory(episodeId: Int, repository: EpisodeDetailsRepository, internetChecker: InternetConnectionChecker): EpisodeDetailsViewModelFactory {
        return EpisodeDetailsViewModelFactory(episodeId, repository, internetChecker)
    }
}