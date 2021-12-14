package com.mayan.numbers.decimal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import java.lang.Exception

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 */
class DrawNumbersActivity : AppCompatActivity() {

    private var numbersView: DrawNumbersView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appName = this.getString(R.string.app_name)
        this.window.setTitle(appName)
        try {
            val bundle = this.intent.extras
            val numbers = bundle!!["numbers"] as IntArray?
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
        when (item.itemId) {
            R.id.back_menu -> returnToMain()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun returnToMain() {
        val intent = Intent(this@DrawNumbersActivity.applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        applicationContext.startActivity(intent)
    }
}