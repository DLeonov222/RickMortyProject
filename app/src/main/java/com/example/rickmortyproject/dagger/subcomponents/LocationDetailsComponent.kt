package com.example.rickmortyproject.dagger.subcomponents

import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.dagger.modules.LocationDetailsModule
import com.example.rickmortyproject.view.fragments.LocationDetailsFragment
import com.example.rickmortyproject.view.recycler_view.CharacterRecyclerAdapter
import dagger.BindsInstance
import dagger.Subcomponent

@ExperimentalPagingApi
@Subcomponent(modules = [LocationDetailsModule::class])
interface LocationDetailsComponent {
    fun inject(locationDetailsFragment: LocationDetailsFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun locationId(locationId: Int): Builder
        @BindsInstance
        fun characterItemClickListener(itemClickListener: CharacterRecyclerAdapter.CharacterViewHolder.ItemClickListener): Builder
        fun build(): LocationDetailsComponent
    }
}