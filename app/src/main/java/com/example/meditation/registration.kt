package com.example.meditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val timer = object:CountDownTimer(3000, 1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val intent:Intent= Intent(this@registration, greet::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}