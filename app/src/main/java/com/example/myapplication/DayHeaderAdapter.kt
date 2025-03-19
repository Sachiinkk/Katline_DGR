package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DayHeaderAdapter(private val dayHeaders: List<String>) :
    RecyclerView.Adapter<DayHeaderAdapter.DayHeaderViewHolder>() {

    class DayHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewHeader: TextView = view.findViewById(R.id.textViewDayHeader)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayHeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_day_header, parent, false)
        return DayHeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayHeaderViewHolder, position: Int) {
        holder.textViewHeader.text = dayHeaders[position]
    }

    override fun getItemCount(): Int = dayHeaders.size
}
