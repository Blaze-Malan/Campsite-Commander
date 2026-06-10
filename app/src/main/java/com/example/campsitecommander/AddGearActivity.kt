package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class AddGearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_gear)
        val etItemName = findViewById<EditText>(R.id.etItemName)
        val etCategory = findViewById<EditText>(R.id.etCategory)
        val etQuantity = findViewById<EditText>(R.id.etQuantity)
        val etComments = findViewById<EditText>(R.id.etComments)
        val btnSaveGear = findViewById<Button>(R.id.btnSaveGear)

        btnSaveGear.setOnClickListener {
            val name = etItemName.text.toString()
            val category = etCategory.text.toString()
            val qtyString = etQuantity.text.toString()
            val comments = etComments.text.toString()

            //Error handling for strings
            if (name.isBlank() || category.isBlank() || qtyString.isBlank()) {
                Toast.makeText(this, "Error: Please fill in Name, Category, and Quantity.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            //error handling for integers
            val qty = qtyString.toIntOrNull()
            if (qty == null || qty <= 0) {
                Toast.makeText(this, "Error: Quantity must be a valid number greater than 0.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //Sends the user input to the parallel arrays
            DataManager.itemNames.add(name)
            DataManager.categories.add(category)
            DataManager.quantities.add(qty)
            DataManager.comments.add(comments)

            Toast.makeText(this, "$name added to your pack!", Toast.LENGTH_SHORT).show()

            //Sends users back to Main Screen
            finish()
        }
    }
        }

