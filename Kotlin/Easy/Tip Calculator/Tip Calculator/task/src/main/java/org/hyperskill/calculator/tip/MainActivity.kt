package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var slider: Slider
    private lateinit var textView: TextView
    private lateinit var billValue: String
    private var tipPercentage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text)
        slider = findViewById(R.id.slider)
        textView = findViewById(R.id.text_view)

        billValue = ""

        editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                billValue = s.toString()
                changeDisplayText(billValue, tipPercentage)
            }

            override fun afterTextChanged(s: Editable?) { }

        })

        slider.addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->
            tipPercentage = value.toInt()
            changeDisplayText(billValue, tipPercentage)
        })
    }

    private fun changeDisplayText(billValue: String, tipPercentage: Int) {
        if (!billValue.isBlank()) {
            val tipAmount: String = String.format("%.2f", billValue.toFloat() * tipPercentage / 100)
            val displayText: String = "Tip amount: $tipAmount"
            textView.text = displayText
        } else {
            textView.text = ""
        }
    }
}