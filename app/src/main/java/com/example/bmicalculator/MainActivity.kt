package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    private lateinit var weightInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultText: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize views
        weightInput = findViewById(R.id.weightInput)
        heightInput = findViewById(R.id.heightInput)
        calculateButton = findViewById(R.id.calculateButton)
        resultText = findViewById(R.id.resultText)
        
        // Set click listener for calculate button
        calculateButton.setOnClickListener {
            calculateBMI()
        }
    }
    
    private fun calculateBMI() {
        val weightStr = weightInput.text.toString()
        val heightStr = heightInput.text.toString()
        
        // Validate inputs
        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            resultText.text = "Please enter both weight and height"
            return
        }
        
        try {
            val weight = weightStr.toDouble()
            val height = heightStr.toDouble()
            
            // Validate positive values
            if (weight <= 0 || height <= 0) {
                resultText.text = "Please enter valid positive values"
                return
            }
            
            // Calculate BMI: weight / (height * height)
            val bmi = weight / (height * height)
            
            // Determine category
            val category = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25.0 -> "Normal weight"
                bmi < 30.0 -> "Overweight"
                else -> "Obese"
            }
            
            // Display result with formatting
            resultText.text = String.format(
                "BMI: %.2f\nCategory: %s",
                bmi,
                category
            )
            
        } catch (e: NumberFormatException) {
            resultText.text = "Please enter valid numbers"
        }
    }
}
