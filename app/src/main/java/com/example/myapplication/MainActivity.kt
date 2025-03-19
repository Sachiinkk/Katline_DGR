package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val monthList = generateMonthsList()
        recyclerView.adapter = MonthAdapter(monthList)
    }

    private fun generateMonthsList(): List<MonthModel> {
        val monthList = ArrayList<MonthModel>()
        val monthFormatter = DateTimeFormatter.ofPattern("MMM yyyy")
        val currentDate = LocalDate.now()
        val endDate = LocalDate.of(2025, 12, 31)

        var date = currentDate
        while (!date.isAfter(endDate)) {
            val days = mutableListOf<String>()
            val dayHeaders = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

            val firstDayOfWeek = date.withDayOfMonth(1).dayOfWeek.value % 7
            repeat(firstDayOfWeek) { days.add("") }

            val daysInMonth = date.lengthOfMonth()
            for (i in 1..daysInMonth) {
                days.add(i.toString())
            }

            monthList.add(MonthModel(date.format(monthFormatter), dayHeaders, days))
            date = date.plusMonths(1)
        }

        return monthList
    }
}
