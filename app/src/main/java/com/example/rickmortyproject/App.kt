package com.example.rickmortyproject

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.dagger.AppComponent
import com.example.rickmortyproject.dagger.AppModule
import com.example.rickmortyproject.dagger.DaggerAppComponent

@ExperimentalPagingApi
class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}