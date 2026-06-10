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
        //basic UI
        tvTotalItems = findViewById(R.id.tvTotalItems)
        val btnAddGear = findViewById<Button>(R.id.btnAddGear)
        val btnViewDetailed = findViewById<Button>(R.id.btnViewDetailed)

        //Sends users to the add gear screen
        btnAddGear.setOnClickListener {
            val intent = Intent(this, AddGearActivity::class.java)
            startActivity(intent)
        }

        //Sends users to the detail view screen
        btnViewDetailed.setOnClickListener {
            val intent = Intent(this, DetailedActivity::class.java)
            startActivity(intent)
        }

    }
    //Onresume helps tally the items automatically when users return to the mainscreen
    override fun onResume() {
        super.onResume()
        val total = DataManager.calculateTotalItemsPacked()
        tvTotalItems.text = "Total Items Packed: $total"
    }

    }
