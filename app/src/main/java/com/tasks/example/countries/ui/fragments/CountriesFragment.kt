package com.tasks.example.countries.ui.fragments


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tasks.example.countries.R
import com.tasks.example.countries.ui.BordersAdapter
import com.tasks.example.countries.ui.base.BaseFragment
import com.tasks.example.countries.utils.Constants
import kotlinx.android.synthetic.main.fragment_countries.view.*

class CountriesFragment : BaseFragment(R.layout.fragment_countries) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        arguments?.apply {
            view?.bordersRecycler?.apply {
                setHasFixedSize(true)

                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

                adapter = BordersAdapter(getStringArrayList(Constants.COUNTRY_POSITION))
            }
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        actionBarListener?.changeActionBar(title = "Bordering Countries")
    }

    override fun onDetach() {
        super.onDetach()
        actionBarListener?.changeActionBar(title = "Countries")
    }

}
