package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        getStart.setOnClickListener {
            logLinerLay.setVisibility(View.VISIBLE)
            getStart.setVisibility(View.INVISIBLE)
            val loginai = AnimationUtils.loadAnimation(this, R.anim.log_in)
            val mtavarlay = findViewById(R.id.logLinerLay) as FrameLayout
            mtavarlay.startAnimation(loginai)
        }
        facebookBtt.setOnClickListener {
            facebookLay.setVisibility(View.VISIBLE)
            frameMain.setVisibility(View.VISIBLE)
        }
        googleBtt.setOnClickListener {
            googleLay.setVisibility(View.VISIBLE)
            frameMain.setVisibility(View.VISIBLE)
        }
        frameMain.setOnClickListener {
            facebookLay.setVisibility(View.INVISIBLE)
            googleLay.setVisibility(View.INVISIBLE)
            frameMain.setVisibility(View.INVISIBLE)
        }
        registrartion.setOnClickListener {
            logInLay.setVisibility(View.INVISIBLE)
            forgotReg.setVisibility(View.INVISIBLE)
            signUpLay.setVisibility(View.VISIBLE)
            backToLogIn.setVisibility(View.VISIBLE)
        }
        backToLogIn.setOnClickListener {
            logInLay.setVisibility(View.VISIBLE)
            forgotReg.setVisibility(View.VISIBLE)
            signUpLay.setVisibility(View.INVISIBLE)
            backToLogIn.setVisibility(View.INVISIBLE)
        }
        logIn.setOnClickListener {
            auth.signInWithEmailAndPassword(emailIn.text.toString(), passwordIn.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "succes", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,MtavariActivity::class.java))
                    }
                    else {
                        Toast.makeText(this, "arasworia", Toast.LENGTH_LONG).show()
                    }
                }
            signUp.setOnClickListener {
                auth.createUserWithEmailAndPassword(
                    emailUp.text.toString(),
                    passwordUp.text.toString()
                )
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            logInLay.setVisibility(View.VISIBLE)
                            forgotReg.setVisibility(View.VISIBLE)
                            signUpLay.setVisibility(View.INVISIBLE)
                            backToLogIn.setVisibility(View.INVISIBLE)
                        }
                    }
            }


        }


    }
}