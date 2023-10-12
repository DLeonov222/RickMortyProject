package com.example.rickmortyproject.dagger

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.MainViewModelFactory
import com.example.rickmortyproject.utils.ResourceProvider
import dagger.Module
import dagger.Provides

@ExperimentalPagingApi
@Module
class AppModule(val context: Application) {

    @Provides
    fun provideContext(): Application {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(mResourceProvider: ResourceProvider) : MainViewModelFactory {
        return MainViewModelFactory(mResourceProvider)
    }

}
