package com.tasks.example.countries.ui.base


import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


abstract class BaseActivity(@LayoutRes private val viewId: Int) : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieve the content view that renders the map.
        setContentView(viewId)
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> = fragmentInjector

}