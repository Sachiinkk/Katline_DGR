package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true) // ✅ Improve performance
        recyclerView.setItemViewCacheSize(12) // ✅ Preload items

        val monthAdapter = MonthAdapter()
        recyclerView.adapter = monthAdapter

        val monthList = generateMonthsList()
        monthAdapter.submitList(monthList) // ✅ Efficient updates with DiffUtil
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show()
            finish() // ✅ Closes the app or add logout logic here
        }
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
            val firstDay = date.withDayOfMonth(1).dayOfWeek.value % 7
            for (i in 0 until firstDay) days.add("")

            for (i in 1..date.lengthOfMonth()) days.add(i.toString())

            monthList.add(MonthModel(date.format(monthFormatter), dayHeaders, days))
            date = date.plusMonths(1)
        }

        return monthList
    }
}
