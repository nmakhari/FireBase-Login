package com.example.uwaftlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_button_mainActivity.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
            //when the login button is pressed start the login activity
        }

        register_textView_MainActivity.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)

            startActivity(intent)
            //when the "Don't have an account?" text is clicked the register activity is started
        }

    }
}
