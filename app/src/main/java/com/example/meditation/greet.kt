package com.example.meditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.util.regex.Pattern.compile

class greet : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greet)

        val btn_reg:Button = findViewById(R.id.button2)
        val btn_next:Button = findViewById(R.id.button)
    }

    fun reg(view: View) {
        val intent = Intent(this, registration::class.java)
        startActivity(intent)
    }

    fun next(view: View) {
        val intent = Intent(this, login::class.java)
        startActivity(intent)
    }
}