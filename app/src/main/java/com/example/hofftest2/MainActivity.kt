package com.example.hofftest2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hofftest2.screens.OrderFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_for_fragment, OrderFragment())
            .commit()
    }
}