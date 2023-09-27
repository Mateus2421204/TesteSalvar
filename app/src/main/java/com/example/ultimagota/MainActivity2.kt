package com.example.ultimagota

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity2 : AppCompatActivity() {

    private lateinit var btTempoBanho: Button
    private lateinit var btQuizz: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btTempoBanho = findViewById(R.id.btTempoBanho)
        btQuizz = findViewById(R.id.btQuizz)

        btTempoBanho.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
         btQuizz.setOnClickListener{
            val intent2 = Intent(this, MainActivity4::class.java)
             startActivity(intent2)




        }

    }
}
