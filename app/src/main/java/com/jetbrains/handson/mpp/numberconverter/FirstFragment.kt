package com.jetbrains.handson.mpp.numberconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.Encode).setOnClickListener {

            encode(view)
        }

        view.findViewById<Button>(R.id.Decode).setOnClickListener {

            decode(view)
        }
    }
}

//function to increment the counted value when clicking on the `count` button
private fun encode(view: View) {

    // Get the EditText
    val textToConvert = view.findViewById<EditText>(R.id.textToConvert)

    // Get the text view
    val displayAnswer = view.findViewById<TextView>(R.id.Answer)

    // Get the value of the EditText.
    val editTextValue = textToConvert.text.toString()

    // Convert to Int
    var numberToEncode: Int = Integer.parseInt(editTextValue)

    // Convert integer to binary
    var binaryNumber = convertDecimalToBinary(numberToEncode)

    // Display the new value in the text view.
    displayAnswer.text = binaryNumber.toString()
}

// helper function to handle the conversion from decimal to binary
private fun convertDecimalToBinary(decimalNumber: Int): Long {

    // define variables needed to perform conversion
    var n = decimalNumber
    var binaryNumber: Long = 0
    var remainder: Int
    var i = 1

    // loop through the decimal number, keep track of remainder to convert to binary number
    while (n != 0) {

        remainder = n % 2
        n /= 2
        binaryNumber += (remainder * i).toLong()
        i *= 10
    }

    return binaryNumber
}

//function to increment the counted value when clicking on the `count` button
private fun decode(view: View) {

    // Get the EditText
    val textToConvert = view.findViewById<EditText>(R.id.textToConvert)

    // Get the text view
    val displayAnswer = view.findViewById<TextView>(R.id.Answer)

    // Get the value of the EditText.
    val editTextValue = textToConvert.text.toString()

    // Convert to Int
    var numberToDecode: Int = Integer.parseInt(editTextValue)

    // Convert integer to binary
    var decimalNumber = convertBinaryToDecimal(numberToDecode.toLong())

    // Display the new value in the text view.
    displayAnswer.text = decimalNumber.toString()
}

// helper function to handle the conversion from binary to decimal
private fun convertBinaryToDecimal(binaryNumber: Long): Int {

    // define variables needed to convert a binary number to decimal
    var n = binaryNumber
    var decimalNumber = 0
    var i = 0
    var remainder: Long

    // loop through the given number, keep track of each numbers' index, raise each `1` to the power of 2
    while (n.toInt() != 0) {

        remainder = n % 10
        n /= 10
        decimalNumber += (remainder * 2.0.pow(i.toDouble())).toInt()
        i++
    }

    return decimalNumber
}