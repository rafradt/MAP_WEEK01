package com.LAB_WEEK_01.myapplication

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Value Nama
        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        // Click Listener untuk Nama
        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text.toString().trim()

            if (nameInput.isNotEmpty()) {
                nameDisplay?.text = getString(R.string.name_greet).plus(" ").plus(nameInput)
                // or you can use
                // nameDisplay?.text = "${getString(R.string.name_greet)} ${nameInput}"
            } else {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
        }

        // Value NIM
        val nimDisplay = findViewById<TextView>(R.id.nim_display)
        val nimSubmit = findViewById<Button>(R.id.nim_submit)

        // Click Listener untuk NIM
        nimSubmit.setOnClickListener {
            val nimInput = findViewById<TextInputEditText>(R.id.nim_input)
                ?.text.toString().trim()

            if (nimInput.isEmpty()) {
                Toast.makeText(this, getString(R.string.nim_empty), Toast.LENGTH_LONG).show()

            } else if (nimInput.length != 11) {
                Toast.makeText(this, getString(R.string.nim_not_11_digits), Toast.LENGTH_LONG)
                    .show()

            } else {
                nimDisplay?.text = getString(R.string.nim_greet).plus(" ").plus(nimInput)
            }
        }
    }
}