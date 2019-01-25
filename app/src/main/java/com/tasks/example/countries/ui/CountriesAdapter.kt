package com.tasks.example.countries.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tasks.example.countries.R
import com.tasks.example.countries.api.CountriesResponse
import kotlinx.android.synthetic.main.item_country.view.*

class CountriesAdapter(
    private val onSubmitClick: (position: Int) -> Unit,
    private val countries: List<CountriesResponse>?
) : RecyclerView.Adapter<CountriesAdapter.CountriesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountriesHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_country, parent, false)
    )

    override fun onBindViewHolder(holder: CountriesHolder, position: Int) {
        countries?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = countries?.size ?: 0

    inner class CountriesHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        fun bind(item: CountriesResponse) {
            itemView.apply {
                tvCountry?.text = item.nativeName
                countryCards?.setOnClickListener {
                    onSubmitClick(layoutPosition)
                }
            }
        }
    }

}