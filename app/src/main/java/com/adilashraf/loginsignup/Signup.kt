package com.adilashraf.loginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
 import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Signup : AppCompatActivity() {

    private lateinit var loginTxt: TextView
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        loginTxt = findViewById(R.id.loginTxt)
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signup = findViewById(R.id.signupBtn)


        signup.setOnClickListener {
            val userName = name.text.toString()
            val userEmail = email.text.toString()
            val userPass = password.text.toString()

            //Log.d("Email", "${userEmail} --> ${userPass}")
            if(  userEmail != "" && userPass != "" ){
                val intent = Intent(this@Signup, Signin::class.java)
                intent.putExtra("email", userEmail )
                intent.putExtra("password", userPass )
                intent.putExtra("name", userName )
                startActivity(intent)
                Toast.makeText(this, "SignUp Successfull", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Please Enter Details correctly", Toast.LENGTH_LONG).show()
            }
        }

        loginTxt.setOnClickListener {
            val intent = Intent(this@Signup, Signin::class.java)
            startActivity(intent)
        }

    }
}