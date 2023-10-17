package com.example.midtermapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class GameScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_screen)

        if (savedInstanceState == null) {
            // Top Fragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment1_container, Fragment1())
                .commit()

            // Bottom Fragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment2_container, Fragment2())
                .commit()
        }
    }
}
