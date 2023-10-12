package com.example.rickmortyproject.dagger.modules

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.view.dialogs.EpisodeFilterDialog
import com.example.rickmortyproject.view.recycler_view.EpisodePaginationRecyclerAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Named

@ExperimentalPagingApi
@Module
class EpisodeModule {

    @Provides
    fun provideEpisodePaginationRecyclerAdapter(itemClickListener: EpisodePaginationRecyclerAdapter.EpisodeViewHolder.ItemClickListener): EpisodePaginationRecyclerAdapter {
        return EpisodePaginationRecyclerAdapter(itemClickListener)
    }

    @Provides
    fun provideEpisodeDialogProcessor(@Named("episodeContext") fragmentContext: Context, applyClickListener: EpisodeFilterDialog.ApplyClickListener): EpisodeFilterDialog {
        return EpisodeFilterDialog(fragmentContext, applyClickListener)
    }
}