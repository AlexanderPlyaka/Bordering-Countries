package com.tasks.example.countries.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tasks.example.countries.R
import kotlinx.android.synthetic.main.item_borders.view.*

class BordersAdapter(
    private val borders: List<String>?
) : RecyclerView.Adapter<BordersAdapter.BordersHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BordersHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_borders, parent, false)
    )

    override fun onBindViewHolder(holder: BordersHolder, position: Int) {
        holder.bind(borders?.get(position))
    }

    override fun getItemCount(): Int = borders?.size ?: 0

    inner class BordersHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        fun bind(item: String?) {
            itemView.apply {
                tvBorders?.text = item
            }
        }
    }

}