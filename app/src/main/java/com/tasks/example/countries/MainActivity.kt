package com.tasks.example.countries

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tasks.example.countries.ui.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main), ActionBarListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun changeActionBar(title: String) {
        supportActionBar?.title = title
    }

}
