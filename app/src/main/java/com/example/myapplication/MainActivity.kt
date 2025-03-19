package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        val monthList = generateMonthsList()

        // ArrayList of class ItemsViewModel
//        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
//        for (i in 1..40) {
//            data.add(ItemsViewModel(R.drawable.ic_baseline_folder_24, "Itemhola " + i))
//        }

        // This will pass the ArrayList to our Adapter
        val adapter = MonthAdapter(monthList)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }

    private fun generateMonthsList(): ArrayList<MonthModel> {
        val monthList = ArrayList<MonthModel>()
        val monthFormatter = DateTimeFormatter.ofPattern("MMM yyyy") // Format: "Mar 2025"

        var currentDate = LocalDate.now() // Start from today
        val endDate = LocalDate.of(2025, 12, 31) // Until Dec 2025

        while (!currentDate.isAfter(endDate)) {
            val monthName = currentDate.format(monthFormatter) // Convert to "Mar 2025"
            val days = ArrayList<String>()

            val daysInMonth = currentDate.lengthOfMonth() // Get number of days in the month
            for (day in 1..daysInMonth) {
                days.add(day.toString()) // Store day as string
            }

            // ✅ Now store as `MonthModel`
            monthList.add(MonthModel(monthName, days))

            // Move to the next month
            currentDate = currentDate.plusMonths(1)
        }

        return monthList
    }
}
