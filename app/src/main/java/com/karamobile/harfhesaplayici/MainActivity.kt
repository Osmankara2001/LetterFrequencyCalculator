package com.karamobile.harfhesaplayici

import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.karamobile.harfhesaplayici.ui.theme.HarfhesaplayiciTheme


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputText = findViewById<EditText>(R.id.inputText)
        val inputLetter = findViewById<EditText>(R.id.inputLetter)
        val resultText = findViewById<TextView>(R.id.resultText)
        val countButton = findViewById<Button>(R.id.countButton)

        countButton.setOnClickListener {
            val text = inputText.text.toString().toLowerCase()
            val letter = inputLetter.text.toString().toLowerCase()

            if (text.isEmpty()) {
                Toast.makeText(this, "Lütfen bir metin girin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (letter.length != 1 || !letter[0].isLetter()) {
                Toast.makeText(this, "Lütfen geçerli bir harf girin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val count = text.count { it == letter[0] }

            resultText.text = "'$letter' harfi metinde $count kez geçiyor."
        }
    }
}