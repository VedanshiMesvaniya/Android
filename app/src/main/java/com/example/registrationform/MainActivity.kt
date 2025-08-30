package com.example.registrationform


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstName = findViewById<EditText>(R.id.FirstName)
        val lastName = findViewById<EditText>(R.id.LastName)
        val genderGroup = findViewById<RadioGroup>(R.id.genderGroup)
        val travel = findViewById<CheckBox>(R.id.checkBoxTravel)
        val reading = findViewById<CheckBox>(R.id.checkBoxReading)
        val exploring = findViewById<CheckBox>(R.id.checkBoxExploring)
        val cities = findViewById<Spinner>(R.id.cities)
        val submit = findViewById<Button>(R.id.submit)

        // Add dropdown values
        // Dropdown values
        val citiesList = arrayOf("Ahmedabad", "Surat", "Rajkot", "Vadodara", "Bhavnagar")
        cities.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, citiesList)

        submit.setOnClickListener {
            val fName = firstName.text.toString()
            val lName = lastName.text.toString()

            // Gender
            val selectedGenderId = genderGroup.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                "Not Selected"
            }

            // Hobbies
            val hobbies = mutableListOf<String>()
            if (travel.isChecked) hobbies.add("Traveling")
            if (reading.isChecked) hobbies.add("Reading")
            if (exploring.isChecked) hobbies.add("Exploring")

            // City
            val selectedCity = cities.selectedItem.toString()

            // Send data to another activity
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("fname", fName)
            intent.putExtra("lname", lName)
            intent.putExtra("gender", gender)
            intent.putExtra("hobbies", hobbies.joinToString(", "))
            intent.putExtra("city", selectedCity)
            startActivity(intent)
        }
    }
}