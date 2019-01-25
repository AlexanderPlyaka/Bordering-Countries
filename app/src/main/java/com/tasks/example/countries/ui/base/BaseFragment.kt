package com.tasks.example.countries.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tasks.example.countries.ActionBarListener
import com.tasks.example.countries.di.Injectable

abstract class BaseFragment(@LayoutRes private val viewId: Int): Fragment(), Injectable {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(viewId, container, false)
    }

    val actionBarListener
        get() = context as? ActionBarListener

}