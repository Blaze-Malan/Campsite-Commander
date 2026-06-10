//ST10528596
//Blaze Malan
package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

private lateinit var tvTotalItems: TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tvTotalItems = findViewById(R.id.tvTotalItems)
        val btnAddGear = findViewById<Button>(R.id.btnAddGear)
        val btnViewDetailed = findViewById<Button>(R.id.btnViewDetailed)

        //Add Gear
        btnAddGear.setOnClickListener {
            val intent = Intent(this, AddGearActivity::class.java)
            startActivity(intent)
        }

        //navigation to detailed view
        btnViewDetailed.setOnClickListener {
            val intent = Intent(this, DetailedActivity::class.java)
            startActivity(intent)
        }

    }
    //use on resume so totals update automatically
    override fun onResume() {
        super.onResume()
        val total = DataManager.calculateTotalItemsPacked()
        tvTotalItems.text = "Total Items Packed: $total"
    }

    }
