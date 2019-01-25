package com.tasks.example.countries.di.modules

import com.tasks.example.countries.di.scopes.FragmentScope
import com.tasks.example.countries.ui.fragments.CountriesFragment
import com.tasks.example.countries.ui.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeStartFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMapsFragment(): CountriesFragment

}