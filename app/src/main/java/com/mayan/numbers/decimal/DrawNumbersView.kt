package com.mayan.numbers.decimal

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.content.Intent
import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.view.View
import java.lang.Exception
import java.util.Hashtable


class DrawNumbersView(context: Context?) : View(context) {
    var numbers: IntArray? = null
    private val numberHash = Hashtable<String, Bitmap>()
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        try {
            val backgroundImage =
                BitmapFactory.decodeResource(resources, R.drawable.fondo_chichen_2)
            canvas.drawBitmap(backgroundImage, 0f, 0f, null)
            for ((count, number) in numbers!!.withIndex()) {
                val image = numberHash[number.toString()]
                canvas.drawBitmap(
                    image!!,
                    (width / 2 - image.width / 2).toFloat(),
                    (count * image.height + 5).toFloat(),
                    null
                )
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            showErrorMessageInMain()
        }
    }

    fun setNumbersToDraw(numbers: IntArray?) {
        this.numbers = numbers
    }

    private fun showErrorMessageInMain() {
        val extras = Bundle()
        extras.putInt("errMsg", R.string.error_when_converting_big_number)
        val intent = Intent(context as Activity, MainActivity::class.java)
        intent.putExtras(extras)
        context.startActivity(intent)
    }

    init {
        numberHash[0.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n0)
        numberHash[1.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n1)
        numberHash[2.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n2)
        numberHash[3.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n3)
        numberHash[4.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n4)
        numberHash[5.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n5)
        numberHash[6.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n6)
        numberHash[7.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n7)
        numberHash[8.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n8)
        numberHash[9.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n9)
        numberHash[10.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n10)
        numberHash[11.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n11)
        numberHash[12.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n12)
        numberHash[13.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n13)
        numberHash[14.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n14)
        numberHash[15.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n15)
        numberHash[16.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n16)
        numberHash[17.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n17)
        numberHash[18.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n18)
        numberHash[19.toString()] = BitmapFactory.decodeResource(resources, R.drawable.n19)
    }
}