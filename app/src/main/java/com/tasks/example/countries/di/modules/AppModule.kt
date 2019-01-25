package com.tasks.example.countries.di.modules

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.tasks.example.countries.BuildConfig
import com.tasks.example.countries.api.CountriesService
import com.tasks.example.countries.utils.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideExchangersService(): CountriesService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.Url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(CountriesService::class.java)
    }
}