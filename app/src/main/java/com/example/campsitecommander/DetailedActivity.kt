package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)
        val tvGearList = findViewById<TextView>(R.id.tvGearList) // Ensure this is inside a ScrollView in XML
        val btnBackToBase = findViewById<Button>(R.id.btnBackToBase)

        // Requirement: Use a loop to present additional item details
        val stringBuilder = java.lang.StringBuilder()

        for (i in 0 until DataManager.itemNames.size) {
            stringBuilder.append("⛺ Item: ${DataManager.itemNames[i]}\n")
            stringBuilder.append("📁 Category: ${DataManager.categories[i]}\n")
            stringBuilder.append("📦 Quantity: ${DataManager.quantities[i]}\n")
            stringBuilder.append("📝 Notes: ${DataManager.comments[i]}\n")
            stringBuilder.append("---------------------------\n\n")
        }

        tvGearList.text = stringBuilder.toString()

        // Requirement: "Back to Base" button (Navigation)
        btnBackToBase.setOnClickListener {
            finish() // Destroys this activity, returning to the previous one (Main Screen)
        }
    }
        }