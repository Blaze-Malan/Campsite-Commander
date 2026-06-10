package com.example.campsitecommander

object DataManager {
    val itemNames = arrayListOf("Tent", "Marshmallows", "Flashlight")
    val categories = arrayListOf("Shelter", "Food", "Safety")
    val quantities = arrayListOf (1, 2, 3, 4, 5, 6, 7, 8, 9)
    val comments = arrayListOf("4-person waterproof", "For S'mores(Mega size)", "Check batteries(AA)")

    //Loop for calculating how many items
    fun calculateTotalItemsPacked(): Int{
        var total = 0
        for (qty in quantities) {
            total += qty
        }
        return total
    }
}

