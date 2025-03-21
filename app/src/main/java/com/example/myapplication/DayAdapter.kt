package com.example.myapplication

import android.graphics.Color
import android.provider.CalendarContract.Colors
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DayAdapter(private val days: List<String> , private val month: String) : RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    class DayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewDay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_day, parent, false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int ) {
        val day = days[position]
        holder.textView.text = day
        if(position % 7 ==0 ||isHoliday(day , month)){
            holder.textView.setTextColor(Color.RED)
        }else{
            holder.textView.setTextColor((Color.BLACK))
        }
        holder.textView.visibility = if (days[position].isEmpty()) View.INVISIBLE else View.VISIBLE

    }

    override fun getItemCount(): Int = days.size
    private fun isHoliday(day: String, month: String): Boolean {
        val holidays = mapOf(
            "Jan" to listOf(1, 26), // New Year, Republic Day
            "Mar" to listOf(8), // Holi
            "Apr" to listOf(6,8,10,13,14, 18,29), // Ambedkar Jayanti, Good Friday
            "Aug" to listOf(15), // Independence Day
            "Oct" to listOf(2, 24), // Gandhi Jayanti, Dussehra
            "Dec" to listOf(25) // Christmas
        )
        return holidays[month]?.contains(day.toIntOrNull()) ?: false
    }
}
