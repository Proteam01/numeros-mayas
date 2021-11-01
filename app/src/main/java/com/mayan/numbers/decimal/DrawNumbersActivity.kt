package com.mayan.numbers.decimal

import androidx.appcompat.app.AppCompatActivity
import com.mayan.numbers.decimal.DrawNumbersView
import android.os.Bundle
import com.mayan.numbers.decimal.R
import android.widget.ScrollView
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.mayan.numbers.decimal.MainActivity
import java.lang.Exception

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 */
class DrawNumbersActivity : AppCompatActivity() {

    var numbersView: DrawNumbersView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appName = this.getString(R.string.app_name)
        this.window.setTitle(appName)
        try {
            val bundle = this.intent.extras
            val numbers = bundle!!["numbers"] as IntArray?
            // val scrollViewNumbers = findViewById<View>(R.id.scrollViewNumbers) as ScrollView
            numbersView = DrawNumbersView(this)
            numbersView!!.setNumbersToDraw(numbers)
            setContentView(numbersView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.draw_numbers_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.back_menu -> returnToMain()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun returnToMain() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        this.applicationContext.startActivity(intent)
    }
}