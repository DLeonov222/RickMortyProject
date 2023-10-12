package com.example.rickmortyproject.dagger.subcomponents

import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.dagger.modules.CharacterDetailsModule
import com.example.rickmortyproject.view.fragments.CharacterDetailsFragment
import com.example.rickmortyproject.view.recycler_view.EpisodeRecyclerAdapter
import com.example.rickmortyproject.view.recycler_view.LocationRecyclerAdapter
import dagger.BindsInstance
import dagger.Subcomponent

@ExperimentalPagingApi
@Subcomponent(modules = [CharacterDetailsModule::class])
interface CharacterDetailsComponent {

    fun inject(characterDetailsFragment: CharacterDetailsFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun characterId(characterId: Int): Builder
        @BindsInstance
        fun episodeItemClickListener(itemClickListener: EpisodeRecyclerAdapter.EpisodeViewHolder.ItemClickListener): Builder
        @BindsInstance
        fun locationItemClickListener(itemClickListener: LocationRecyclerAdapter.LocationViewHolder.ItemClickListener): Builder
        fun build(): CharacterDetailsComponent
    }
}