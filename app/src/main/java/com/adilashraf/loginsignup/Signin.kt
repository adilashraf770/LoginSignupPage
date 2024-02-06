package com.adilashraf.loginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Signin : AppCompatActivity() {

    private lateinit var signupTxt: TextView
     private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        signupTxt = findViewById(R.id.signupTxt)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signin = findViewById(R.id.signinBtn)

        val userEmail = intent.getStringExtra("email")
        val userPass = intent.getStringExtra("password")
        val userName = intent.getStringExtra("name")

        signin.setOnClickListener {
            if (userEmail == email.text.toString() && userPass == password.text.toString() ){
                Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                val intent = Intent(this@Signin, MainActivity::class.java)
                intent.putExtra("name", userName)
                startActivity(intent)
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Please Enter Details Correctly", Toast.LENGTH_LONG).show()
            }
        }

        signupTxt.setOnClickListener{
            val intent = Intent(this@Signin, Signup::class.java)
            startActivity(intent)
        }
    }
}