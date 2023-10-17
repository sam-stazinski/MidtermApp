package com.example.midtermapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val args = MainActivityArgs.fromBundle(intent.extras ?: Bundle())
        val numOfAttempts = args.numOfAttempts
        val playerName = args.playerName

        Log.d("Value", "Num in Main Act: $numOfAttempts")

        if (numOfAttempts != 0) {
            val welcomeTextView: TextView = findViewById(R.id.welcome)
            welcomeTextView.text = "$playerName Score: $numOfAttempts"
        }

        val btnStart: Button = findViewById(R.id.btnStart)
        btnStart.setOnClickListener {
            // Intent to start the GameScreen activity
            val intent = Intent(this, GameScreen::class.java)
            startActivity(intent)
        }

        val btnHighScores: Button = findViewById(R.id.btnHighScores)
        btnHighScores.setOnClickListener {
            // Intent to start the HighScores activity
            val intent = Intent(this, HighScores::class.java)
            startActivity(intent)
        }
    }
}