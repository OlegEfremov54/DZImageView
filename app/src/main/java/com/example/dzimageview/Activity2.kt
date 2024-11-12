package com.example.dzimageview


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    private lateinit var toolbarFoto: Toolbar
    private lateinit var imageIV: ImageView
    private lateinit var nextBTN: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbarFoto = findViewById(R.id.toolbarFoto)
        setSupportActionBar(toolbarFoto)
        title = " Альбом фотографий"
        toolbarFoto.subtitle = "  Версия 1. Страница фотографий"
        toolbarFoto.setLogo(R.drawable.fotoalb)

        imageIV = findViewById(R.id.imageIV)
        nextBTN = findViewById(R.id.nextBTN)

        imageIV.setImageResource(R.drawable.im01)
        var foto = 1
        nextBTN.setOnClickListener{view ->
            foto++
            when(foto) {
                2 -> imageIV.setImageResource(R.drawable.im02)
                3 -> imageIV.setImageResource(R.drawable.im03)
                4 -> imageIV.setImageResource(R.drawable.im04)
                5 -> imageIV.setImageResource(R.drawable.im05)
                else -> {
                    val intent = Intent(this, ActivityFinal::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.infoMenuMain -> {
                Toast.makeText(applicationContext, "Автор Ефремов О.В. Создан 11.11.2024",
                    Toast.LENGTH_LONG).show()
            }
            R.id.exitMenuMain ->{
                Toast.makeText(applicationContext, "Работа приложения завершена",
                    Toast.LENGTH_LONG).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    }


