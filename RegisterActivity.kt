package com.example.uwaftlogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Log.d("RegisterActivity", "Opened the Register Activity")

        register_button_registerActivity.setOnClickListener{
            registerUser()
        }

    }

    private fun registerUser(){

        val email= email_editText_registerActivity.text.toString()

        val password1 = password_editText_registerActivity.text.toString()

        val password2 = confirmPassword_editText_registerActivity.text.toString()

        Log.d("RegisterActivity", "P1: $password1 , P2: $password2")

        if(password1.isEmpty() || password2.isEmpty() || email.isEmpty()){//if one field is empty
            Toast.makeText(this, "Please complete missing field", Toast.LENGTH_LONG).show()
            //prompts the user to complete missing fields
            return
        }

        else if(password1 == password2){//so long as the passwords match
            //creates that user with the password
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password1).addOnCompleteListener{
                if(!it.isSuccessful){
                    Log.d("RegisterActivity", "Successfully Created a user")
                    val intent = Intent(this, LoggedInActivity::class.java)
                    startActivity(intent)//starts the logged in activity
                    return@addOnCompleteListener

                }
            }.addOnFailureListener{//if it fails to create a user, toasts that it failed
                Toast.makeText(this, "${it.message}", Toast.LENGTH_LONG).show()
            }
        }
        else{//shows a toast prompting to correct the passwords
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show()
            return
        }
    }
}