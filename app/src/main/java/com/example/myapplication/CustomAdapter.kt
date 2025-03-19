package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MonthAdapter(private val monthList: List<MonthModel>) :
    Adapter<MonthAdapter.MonthViewHolder>() {

    class MonthViewHolder(view: View) : ViewHolder(view) {
        val monthTextView: TextView = view.findViewById(R.id.textViewMonth)
        val daysRecyclerView: RecyclerView = view.findViewById(R.id.recyclerViewDays)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_month, parent, false)
        return MonthViewHolder(view)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        val monthModel = monthList[position]

        holder.monthTextView.text = monthModel.monthName

        // Set up the inner RecyclerView for days
        holder.daysRecyclerView.layoutManager = GridLayoutManager(holder.itemView.context, 7) // 7 columns for week
        holder.daysRecyclerView.adapter = DayAdapter(monthModel.days)
    }

    override fun getItemCount(): Int = monthList.size
}
