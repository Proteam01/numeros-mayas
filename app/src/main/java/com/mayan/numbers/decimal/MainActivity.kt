package com.mayan.numbers.decimal


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle

import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity

import com.mayan.numbers.decimal.calculator.DecimalToMayan


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 */
 class MainActivity : AppCompatActivity() {

    private lateinit var convertButton: Button
    private lateinit var convertText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        convertButton = findViewById(R.id.convertButton)
        convertText = findViewById(R.id.convertText)
        convertButton.setOnClickListener { _ ->
            convertButtonClicked()
        }

        val bundle = this@MainActivity.intent.extras
        if (bundle != null && bundle.containsKey("errMsg")) {
            val errMsg: Int = bundle.getInt("errMsg")
            val errorMessage: String = getString(errMsg)
            this@MainActivity.showErrorAlert(errorMessage)
        }


    }

    private fun convertButtonClicked() {
        try {
            val numberText = convertText.text.toString()
            if (numberText.isNotEmpty()) {
                val decimalNumber: Int = Integer.parseInt(numberText)
                if (decimalNumber > 0) {
                    val decimalToMayan = DecimalToMayan()
                    val numbers = decimalToMayan.getNumerics(decimalNumber)
                    val intent = Intent(this, DrawNumbersActivity::class.java)
                    val extras = Bundle()
                    val size = numbers.size
                    val dec: IntArray =  IntArray(size)
                    for ((i, number) in numbers.withIndex()) {
                        dec[i] = number
                    }
                    extras.putIntArray("numbers", dec)
                    intent.putExtras(extras)
                    startActivity(intent)
                } else if (decimalNumber == 0) {
                    val numbers = arrayListOf<Int>()
                    numbers.add(0)
                    val intent = Intent(this, DrawNumbersActivity::class.java)
                    val extras = Bundle()
                    val size = numbers.size
                    val dec = IntArray(size)
                    for ((i, number) in numbers.withIndex()) {
                        dec[i] = number
                    }
                    extras.putIntArray("numbers", dec)
                    intent.putExtras(extras)
                    startActivity(intent)
                }
            } else {
                val message = getString(R.string.empty_text_convert)
                this@MainActivity.showErrorAlert(message)
            }
        } catch (e: Exception) {
            val errorMessage = getString(R.string.error_when_converting_big_number)
            this@MainActivity.showErrorAlert(errorMessage)
            e.printStackTrace()
        }
    }


    private fun showErrorAlert(message: String) {
        AlertDialog.Builder(this)
            .setPositiveButton(getString(R.string.ok_message), null)
            .setMessage(message)
            .show()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this@MainActivity.menuInflater.inflate(R.menu.main_activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_activity_menu_item -> exitApplication()
            R.id.main_activity_decimal_item -> openDecimalConvert()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun exitApplication() {
        this@MainActivity.finishAffinity()
    }

    private fun openDecimalConvert() {
        val intent = Intent(this, ConvertToDecimalActivity::class.java)
        startActivity(intent)
    }


}
