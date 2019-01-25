package com.tasks.example.countries

import android.app.Activity
import android.app.Application
import com.tasks.example.countries.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppInjector.init(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    companion object {
        @JvmStatic lateinit var instance: App
            private set
    }
}