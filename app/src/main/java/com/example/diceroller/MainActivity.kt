package com.example.diceroller

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = "6"

        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = "6"
        val targetNumberEditText = findViewById<EditText>(R.id.targetNumberEditText)

        rollButton.setOnClickListener {
            rollDice()
        }

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

        val targetNumberEditText: TextView = findViewById(R.id.targetNumberEditText)

        targetNumberEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val rollButton: Button = findViewById(R.id.button)
                rollButton.isEnabled = !s.isNullOrEmpty()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        val targetNumber = targetNumberEditText.text.toString().toInt()
        val sum = diceRoll + diceRoll2
        if(sum == targetNumber){
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