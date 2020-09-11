package com.example.a11_sabaq

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layoutMain = LinearLayout(this)
        val Scroll: ScrollView = ScrollView(this)
        val layout1 = LinearLayout(this)
        val layout2 = LinearLayout(this)
        val layout3 = LinearLayout(this)
        layoutMain.orientation = LinearLayout.VERTICAL
        layout1.orientation = LinearLayout.HORIZONTAL
        layout2.orientation = LinearLayout.HORIZONTAL
        layout3.orientation = LinearLayout.VERTICAL


        layoutMain.addView(layout1)
        layoutMain.addView(layout2)
        layoutMain.addView(Scroll)
        Scroll.addView(layout3)
        setContentView(layoutMain)

        val buttonLeft = Button(this)
        buttonLeft.text = "left"
        val buttonCenter = Button(this)
        buttonCenter.text = "center"
        val buttonRight = Button(this)
        buttonRight.text = "right"
        val buttonClear = Button(this)
        buttonClear.text = "clear"

        val buttonLP1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        val buttonLP2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        val buttonLPA = LinearLayout.LayoutParams(toInt(130), toInt(100))
        val buttonLPB = LinearLayout.LayoutParams(toInt(130), toInt(100))
        val buttonLPC = LinearLayout.LayoutParams(toInt(130), toInt(100))
        buttonLPA.gravity = Gravity.START
        buttonLPB.gravity = Gravity.CENTER
        buttonLPC.gravity = Gravity.END
        buttonLP1.weight = 1F

        buttonLeft.layoutParams = buttonLP1
        buttonCenter.layoutParams = buttonLP1
        buttonRight.layoutParams = buttonLP1
        buttonClear.layoutParams = buttonLP2

        layout1.addView(buttonLeft)
        layout1.addView(buttonCenter)
        layout1.addView(buttonRight)
        layout2.addView(buttonClear)

        buttonLeft.setOnClickListener {
            var button1 = Button(this)
            button1.layoutParams = buttonLPA
            layout3.addView(button1)
        }

        buttonCenter.setOnClickListener {
            var button2 = Button(this)
            button2.layoutParams = buttonLPB
            layout3.addView(button2)
        }

        buttonRight.setOnClickListener {
            var button3 = Button(this)
            button3.layoutParams = buttonLPC
            layout3.addView(button3)
        }

        buttonClear.setOnClickListener {
            layout3.removeAllViews()
        }

    }

    fun toInt(param: Int): Int{
        return (param * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
    }
}