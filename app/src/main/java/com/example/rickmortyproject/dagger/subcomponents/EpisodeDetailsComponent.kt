package com.example.rickmortyproject.dagger.subcomponents

import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.dagger.modules.EpisodeDetailsModule
import com.example.rickmortyproject.view.fragments.EpisodeDetailsFragment
import com.example.rickmortyproject.view.recycler_view.CharacterRecyclerAdapter
import dagger.BindsInstance
import dagger.Subcomponent

@ExperimentalPagingApi
@Subcomponent(modules = [EpisodeDetailsModule::class])
interface EpisodeDetailsComponent {
    fun inject(episodeDetailsFragment: EpisodeDetailsFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun episodeId(episodeId: Int): Builder
        @BindsInstance
        fun characterItemClickListener(itemClickListener: CharacterRecyclerAdapter.CharacterViewHolder.ItemClickListener): Builder
        fun build(): EpisodeDetailsComponent
    }
}