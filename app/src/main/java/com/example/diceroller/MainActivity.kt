package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

        }

        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = "6"

        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = "6"
    }

    private fun rollDice() {
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll2.toString()

        if(diceRoll == diceRoll2){
            val toast = Toast.makeText(this, "Pile, vous avez gagné!!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }


}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}