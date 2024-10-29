package com.example.context_menu

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {



    companion object {
        const val ITEM_One = 111
        const val ITEM_Two = 112
    }

    private lateinit var textButton: EditText
    private var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textButton = findViewById(R.id.button1)
        registerForContextMenu(textButton)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(Menu.NONE, ITEM_One, Menu.NONE, "Цветовое качество")
        menu?.add(Menu.NONE, ITEM_Two, Menu.NONE, "Выход из приложения")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
             var grade = textButton.text.toString().toInt()
              var col = R.color.white


           when (item.itemId) {
               ITEM_One ->
                     if(flag) {
                   when (grade) {
                       in 41..50 -> col = R.color.color4
                       in 31..40 -> col = R.color.color3
                       in 21..30 -> col = R.color.color2
                       in 11..20 -> col = R.color.color1
                       in 1..10 -> col = R.color.color5 }
                                } else
                    when (grade) {
                        1 -> col = R.color.color1
                        2 -> col = R.color.color2
                        3 -> col = R.color.color3
                        4 -> col = R.color.color4
                        5 -> col = R.color.color5
                    }
               ITEM_Two -> finish()
           }
            flag = false
                    textButton.setBackgroundColor(resources.getColor(col))
        return super.onContextItemSelected(item)
    }
    fun onButtonClick(v: View){

        val s = Random.nextInt(0,50)
       textButton.setBackgroundColor(resources.getColor(R.color.white))
        textButton.setText(s.toString())
        flag = true
    }

}