package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MonthAdapter(private val monthList: List<MonthModel>) :
    RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {

    class MonthViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val monthTextView: TextView = view.findViewById(R.id.textViewMonth)
        val dayHeadersRecyclerView: RecyclerView = view.findViewById(R.id.recyclerViewDayHeaders)
        val daysRecyclerView: RecyclerView = view.findViewById(R.id.recyclerViewDays)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_month, parent, false)
        return MonthViewHolder(view)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        val monthModel = monthList[position]
        holder.monthTextView.text = monthModel.monthName

        holder.dayHeadersRecyclerView.layoutManager = GridLayoutManager(holder.itemView.context, 7)
        holder.dayHeadersRecyclerView.adapter = DayHeaderAdapter(monthModel.dayHeaders)

        holder.daysRecyclerView.layoutManager = GridLayoutManager(holder.itemView.context, 7)
        holder.daysRecyclerView.adapter = DayAdapter(monthModel.days)
    }

    override fun getItemCount(): Int = monthList.size
}
