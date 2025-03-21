package com.example.myapplication

import androidx.recyclerview.widget.DiffUtil

class MonthDiffCallback : DiffUtil.ItemCallback<MonthModel>() {
    override fun areItemsTheSame(oldItem: MonthModel, newItem: MonthModel): Boolean {
        return oldItem.monthName == newItem.monthName
    }

    override fun areContentsTheSame(oldItem: MonthModel, newItem: MonthModel): Boolean {
        return oldItem == newItem
    }
}

