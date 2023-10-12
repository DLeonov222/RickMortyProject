package com.example.rickmortyproject.dagger

import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.MainActivity
import com.example.rickmortyproject.dagger.modules.DataModule
import com.example.rickmortyproject.dagger.modules.RetrofitModule
import com.example.rickmortyproject.dagger.subcomponents.*
import dagger.Component
import javax.inject.Singleton

@ExperimentalPagingApi
@Singleton
@Component(modules = [AppModule::class, DataModule::class, RetrofitModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun getEpisodeComponentBuilder(): EpisodeComponent.Builder
    fun getEpisodeDetailsComponentBuilder(): EpisodeDetailsComponent.Builder
    fun getCharacterComponentBuilder(): CharacterComponent.Builder
    fun getCharacterDetailsComponentBuilder(): CharacterDetailsComponent.Builder
    fun getLocationComponentBuilder(): LocationComponent.Builder
    fun getLocationDetailsComponentBuilder(): LocationDetailsComponent.Builder

}
