package com.mayan.numbers.decimal

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import java.util.StringTokenizer


class ConvertToDecimalActivity : AppCompatActivity() {

    private lateinit var b0: Button
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button
    private lateinit var b10: Button
    private lateinit var b11: Button
    private lateinit var b12: Button
    private lateinit var b13: Button
    private lateinit var b14: Button
    private lateinit var b15: Button
    private lateinit var b16: Button
    private lateinit var b17: Button
    private lateinit var b18: Button
    private lateinit var b19: Button
    private lateinit var clearBtn: Button
    private lateinit var equalsBtn: Button
    private lateinit var decimalNumbersText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert_2decimal)
        b0 = findViewById(R.id.n0_btn)
        b1 = findViewById(R.id.n1_btn)
        b2 = findViewById(R.id.n2_btn)
        b3 = findViewById(R.id.n3_btn)
        b4 = findViewById(R.id.n4_btn)
        b5 = findViewById(R.id.n5_btn)
        b6 = findViewById(R.id.n6_btn)
        b7 = findViewById(R.id.n7_btn)
        b8 = findViewById(R.id.n8_btn)
        b9 = findViewById(R.id.n9_btn)
        b10 = findViewById(R.id.n10_btn)
        b11 = findViewById(R.id.n11_btn)
        b12 = findViewById(R.id.n12_btn)
        b13 = findViewById(R.id.n13_btn)
        b14 = findViewById(R.id.n14_btn)
        b15 = findViewById(R.id.n15_btn)
        b16 = findViewById(R.id.n16_btn)
        b17 = findViewById(R.id.n17_btn)
        b18 = findViewById(R.id.n18_btn)
        b19 = findViewById(R.id.n19_btn)
        clearBtn = findViewById(R.id.clear_btn)
        equalsBtn = findViewById(R.id.equals_btn)
        decimalNumbersText = findViewById(R.id.decimal_numbers_text)
        decimalNumbersText.isEnabled = false
        setActions()
    }

    private fun setActions() {
        clearBtn.setOnClickListener { decimalNumbersText.setText("") }
        equalsBtn.setOnClickListener { calculateNumber() }
        b0.setOnClickListener { addNumber("0") }
        b1.setOnClickListener { addNumber("1") }
        b2.setOnClickListener { addNumber("2") }
        b3.setOnClickListener { addNumber("3") }
        b4.setOnClickListener { addNumber("4") }
        b5.setOnClickListener { addNumber("5") }
        b6.setOnClickListener { addNumber("6") }
        b7.setOnClickListener { addNumber("7") }
        b8.setOnClickListener { addNumber("8") }
        b9.setOnClickListener { addNumber("9") }
        b10.setOnClickListener { addNumber("10") }
        b11.setOnClickListener { addNumber("11") }
        b12.setOnClickListener { addNumber("12") }
        b13.setOnClickListener { addNumber("13") }
        b14.setOnClickListener { addNumber("14") }
        b15.setOnClickListener { addNumber("15") }
        b16.setOnClickListener { addNumber("16") }
        b17.setOnClickListener { addNumber("17") }
        b18.setOnClickListener { addNumber("18") }
        b19.setOnClickListener { addNumber("19") }
    }

    private fun addNumber(number: String) {
        var text = decimalNumbersText.text.toString()
        text += "$number "
        decimalNumbersText.setText(text)
    }

    private fun calculateNumber() {
        val text = decimalNumbersText.text.toString().trim { it <= ' ' }
        val tokenizer = StringTokenizer(text, " ")
        val tokens = arrayListOf<String>()
        while (tokenizer.hasMoreTokens()) {
            val token = tokenizer.nextToken()
            tokens.add(0, token)
        }
        var result = 0
        for ((counter, token) in tokens.withIndex()) {
            val numeral = token.toInt()
            result += if (counter == 0) {
                numeral
            } else {
                multiplyPosition(counter) * numeral
            }
        }
        showMessage(result)
    }

    private fun multiplyPosition(counter: Int): Int {
        var mult = 1
        for (i in 0 until counter) {
            mult *= 20
        }
        return mult
    }

    private fun showMessage(result: Int) {
        if (result > 0) {
            AlertDialog.Builder(this)
                .setPositiveButton(getString(R.string.ok_message), null)
                .setMessage(getString(R.string.dec_number_is) + " " + result)
                .setTitle("Mensaje")
                .show()
        } else {
            AlertDialog.Builder(this)
                .setPositiveButton(getString(R.string.ok_message), null)
                .setMessage(getString(R.string.number_too_big))
                .setTitle("Msg")
                .show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.draw_numbers_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.back_menu -> returnToMain()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun returnToMain() {
        val intent =
            Intent(this@ConvertToDecimalActivity.applicationContext, MainActivity::class.java)
        this@ConvertToDecimalActivity.startActivity(intent)
    }

}