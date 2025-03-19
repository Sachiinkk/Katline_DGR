package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DayAdapter(private val days: List<String>) :
    RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    class DayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewDay: TextView = view.findViewById(R.id.textViewDay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_day, parent, false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val day = days[position]
        holder.textViewDay.text = day

        // Hide empty placeholders (for alignment)
        if (day.isEmpty()) {
            holder.textViewDay.visibility = View.INVISIBLE
        } else {
            holder.textViewDay.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int = days.size
}
