package com.example.uwaftlogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        Log.d("LoginActivity", "Login Activity has been opened")

        login_button_loginActivity.setOnClickListener{
            LoginUser()
            //attempt login with the credentials

        }

    }

    private fun LoginUser(){

        val email = email_editText_loginActivity.text.toString()

        val password = password_editText_loginActivity.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener{
            if(!it.isSuccessful){
                Log.d("LoginActivity", "Succesfully logged the user in")

                val intent = Intent(this, LoggedInActivity::class.java)
                startActivity(intent)//starts the logged in activity
                return@addOnCompleteListener

            }
        }.addOnFailureListener(){
            Toast.makeText(this, "Failed to Login", Toast.LENGTH_SHORT).show()
        }
    }
}