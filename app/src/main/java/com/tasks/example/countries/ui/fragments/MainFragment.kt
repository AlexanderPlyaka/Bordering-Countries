package com.tasks.example.countries.ui.fragments


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.tasks.example.countries.R
import com.tasks.example.countries.ui.CountriesAdapter
import com.tasks.example.countries.ui.base.BaseFragment
import com.tasks.example.countries.utils.Constants
import kotlinx.android.synthetic.main.fragment_main.view.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class MainFragment : BaseFragment(R.layout.fragment_main) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.countries.observe(this, Observer { repos ->
            view?.countriesRecycler?.apply {
                setHasFixedSize(true)

                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

                adapter = CountriesAdapter(
                    { position ->
                        view.let {
                            val bundle = Bundle()
                            val listCountries: ArrayList<String> =
                                viewModel.getListOfBorderingCountries(repos?.get(position)?.borders)
                            bundle.putStringArrayList(Constants.COUNTRY_POSITION, listCountries)
                            Navigation.findNavController(it).navigate(R.id.countriesFragment, bundle)
                        }
                    },
                    repos
                )
            }
        })

        return view
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.stopResponse()
    }
}
