package com.example.hofftest2.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hofftest2.App
import com.example.hofftest2.R
import com.example.hofftest2.presentation.Screens
import com.example.hofftest2.presentation.detail.ui.DetailFragment
import com.example.hofftest2.presentation.order.ui.OrderFragment
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.container_for_fragment)

    @Inject
    lateinit var navHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onResumeFragments() {
        navHolder.setNavigator(navigator)
        super.onResumeFragments()
    }

    override fun onPause() {
        navHolder.removeNavigator()
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)

        router.navigateTo(Screens.orderScreen())
    }
}