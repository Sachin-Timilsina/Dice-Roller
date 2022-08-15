package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This class is used to process a random roll from dice and display the result in screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // In here i am giving id to button and the variable rollButton for it's id.
        // The button also has has on set on click listener with rollDice function.

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //roll dice when app starts.
        rollDice()
    }

    /**
     * Function to organize the rollDice in one method.
     */
    private fun rollDice() {
        //Create a dice as instance of Dice class and roll the Dice.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Gave the Image View a international id to call
        val diceImage: ImageView = findViewById(R.id.imageView)
        // To know which drawable resource to use based on the diceRoll.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Gave the dice image view the correct resource form the drawableResource variable.
        diceImage.setImageResource(drawableResource)
        //update contentDescription.
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * This class is used to process the number of sides of dice and produce random roll form the dice.
 */

class Dice(private val numSides: Int) {
    //Using range and the class definition of numSides to generate random numbers between the range.
    fun roll(): Int {
        return (1..numSides).random()
    }
}
