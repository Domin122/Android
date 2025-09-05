package com.example.mojenawyki

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var habitList: RecyclerView
    private lateinit var addHabitButton: Button
    private val habitMap = mutableMapOf<LocalDate, MutableList<Habit>>()
    private var selectedDate: LocalDate = LocalDate.now()
    private lateinit var adapter: HabitAdapter

    private val prefs by lazy { getSharedPreferences("habit_prefs", MODE_PRIVATE) }
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendarView = findViewById(R.id.calendarView)
        habitList = findViewById(R.id.recyclerView)
        addHabitButton = findViewById(R.id.addHabitButton)

        adapter = HabitAdapter()
        habitList.adapter = adapter
        habitList.layoutManager = LinearLayoutManager(this)

        calendarView.setOnDateChangeListener { _, year, month, day ->
            selectedDate = LocalDate.of(year, month + 1, day)
            updateHabitList()
        }

        addHabitButton.setOnClickListener {
            showAddHabitDialog()
        }

        loadHabits()
        updateHabitList()
    }

    private fun updateHabitList() {
        val habits = habitMap[selectedDate] ?: emptyList()
        adapter.submitList(habits)
    }

    private fun showAddHabitDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Dodaj nawyk")

        val input = EditText(this)
        builder.setView(input)

        builder.setPositiveButton("Dodaj") { _, _ ->
            val habitText = input.text.toString()
            if (habitText.isNotBlank()) {
                val newHabit = Habit(selectedDate, habitText)
                habitMap.getOrPut(selectedDate) { mutableListOf() }.add(newHabit)
                saveHabits()
                updateHabitList()
            }
        }
        builder.setNegativeButton("Anuluj", null)
        builder.show()
    }

    private fun saveHabits() {
        val json = gson.toJson(habitMap.mapKeys { it.key.toString() })
        prefs.edit().putString("habits", json).apply()
    }

    private fun loadHabits() {
        val json = prefs.getString("habits", null)
        if (json != null) {
            val type = object : TypeToken<Map<String, List<Habit>>>() {}.type
            val map: Map<String, List<Habit>> = gson.fromJson(json, type)
            map.forEach { (dateStr, habits) ->
                val date = LocalDate.parse(dateStr)
                habitMap[date] = habits.toMutableList()
            }
        }
    }
}
