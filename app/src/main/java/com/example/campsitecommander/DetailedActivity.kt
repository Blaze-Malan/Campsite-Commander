package com.example.campsitecommander

import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)
        val tvGearList = findViewById<TextView>(R.id.tvGearList)
        val btnBackToBase = findViewById<Button>(R.id.btnBackToBase)

        //If else logic to check if a user has input any data yet
        if (DataManager.itemNames.isEmpty()) {
            tvGearList.text = "Your pack is currently empty!\nGo add some gear to get started."
        } else {

            // A loop to present additional item details
            val stringBuilder = java.lang.StringBuilder()
            //the loop will only run when items exist
            for (i in 0 until DataManager.itemNames.size) {
                stringBuilder.append("Item: ${DataManager.itemNames[i]}\n")
                stringBuilder.append("Category: ${DataManager.categories[i]}\n")
                stringBuilder.append("Quantity: ${DataManager.quantities[i]}\n")
                stringBuilder.append("Notes: ${DataManager.comments[i]}\n")
                stringBuilder.append("---------------------------\n\n")
            }

            tvGearList.text = stringBuilder.toString()

            // Simply takes the user back to the main screen
            btnBackToBase.setOnClickListener {
                finish()
            }
        }
    }
}