package com.example.hofftest2.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hofftest2.R
import com.example.hofftest2.presentation.detail.ui.DetailFragment
import com.example.hofftest2.presentation.order.ui.OrderFragment

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