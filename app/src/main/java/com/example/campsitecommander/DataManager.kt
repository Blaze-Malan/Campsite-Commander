package com.example.campsitecommander
//The arrays we use for most of the app creating an object allows me to use the arrays
//globally so it saves us time for having to pass each one back and forth for each activity page
object DataManager {
    val itemNames = arrayListOf<String>()
    val categories = arrayListOf<String>()
    val quantities = arrayListOf<Int>()
    val comments = arrayListOf<String>()

    //Loop for calculating how many items
    fun calculateTotalItemsPacked(): Int{
        var total = 0
        for (qty in quantities) {
            total += qty
        }
        return total
    }
}

