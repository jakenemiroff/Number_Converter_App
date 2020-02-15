package com.jetbrains.handson.mpp.numberconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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

//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }


        view.findViewById<Button>(R.id.Encode).setOnClickListener {

            encode(view)
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

private fun convertDecimalToBinary(decimalNumber: Int): Long {

    var n = decimalNumber
    var binaryNumber: Long = 0
    var remainder: Int
    var i = 1

    while (n != 0) {

        remainder = n % 2
        n /= 2
        binaryNumber += (remainder * i).toLong()
        i *= 10
    }

    return binaryNumber
}