package com.example.meditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.meditation.recycAdapter.logins
import com.example.meditation.recycAdapter.myInterface
import com.example.meditation.recycAdapter.myRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class login : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.editTextTextPersonName)
        password = findViewById(R.id.editTextTextPassword)
    }

    val pattern = "[a-zA-Z0-9]{1,20}"+"\\@"+"[a-zA-Z]{1,20}"+"\\."+"[a-zA-Z]{1,20}"
    fun emailValid(email:String):Boolean{return Pattern.compile(pattern).matcher(email).matches()}


    fun login(view: View){
        if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
            if(emailValid(email = email.text.toString())){
                val hashMap:HashMap<String,String> = hashMapOf()
                hashMap["email"] = email.text.toString()
                hashMap["password"] = password.text.toString()
                val ret = myRetrofit().getRetrofit()
                val api = ret.create(myInterface::class.java)
                val call = api.postLogin(hashMap)
                    call.enqueue(object : retrofit2.Callback<logins> {
                        override fun onResponse(call: Call<logins>, response: Response<logins>) {
                           if (response.isSuccessful){
                               val intent = Intent(applicationContext, NavigationActivity::class.java)
                               startActivity(intent)
                           }
                            else{
                               Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<logins>, t: Throwable) {
                            Log.e("LoginError", t.localizedMessage)
                            Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
                        }
                    })

            }
            else{
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Некорректные поля")
                    .setPositiveButton("Ok", null)
                    .create()
                    .show()
            }
        }else{
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас есть незаполненные поля")
                .setPositiveButton("Ok", null)
                .create()
                .show()
        }
    }


    fun regist(view: View) {
        val intent = Intent(this, registration::class.java)
        startActivity(intent)
    }
}