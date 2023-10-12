package com.example.rickmortyproject.dagger.modules

import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.model.repository.CharacterDetailsRepository
import com.example.rickmortyproject.utils.InternetConnectionChecker
import com.example.rickmortyproject.viewmodel.factory.CharacterDetailsViewModelFactory
import dagger.Module
import dagger.Provides

@ExperimentalPagingApi
@Module
class CharacterDetailsModule {

    @Provides
    fun provideCharacterDetailsViewModelFactory(characterId: Int, repository: CharacterDetailsRepository, internetChecker: InternetConnectionChecker): CharacterDetailsViewModelFactory {
        return CharacterDetailsViewModelFactory(characterId, repository, internetChecker)
    }
/*
    @Provides
    fun provideCharacterPaginationRecyclerAdapter(itemClickListener: CharacterPaginationRecyclerAdapter.CharacterViewHolder.ItemClickListener): CharacterPaginationRecyclerAdapter {
        return CharacterPaginationRecyclerAdapter(itemClickListener)
    }

    @Provides
    fun provideCharacterPaginationRecyclerAdapter(itemClickListener: CharacterPaginationRecyclerAdapter.CharacterViewHolder.ItemClickListener): CharacterPaginationRecyclerAdapter {
        return CharacterPaginationRecyclerAdapter(itemClickListener)
    }*/
}