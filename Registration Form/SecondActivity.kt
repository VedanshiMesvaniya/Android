package com.example.registrationform

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.registrationform.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView = findViewById<TextView>(R.id.resultText)

        val fname = intent.getStringExtra("fname")
        val lname = intent.getStringExtra("lname")
        val gender = intent.getStringExtra("gender")
        val hobbies = intent.getStringExtra("hobbies")
        val city = intent.getStringExtra("city")

        textView.text = """
            First Name: $fname
            Last Name: $lname
            Gender: $gender
            Hobbies: $hobbies
            City: $city
        """.trimIndent()
    }
}
