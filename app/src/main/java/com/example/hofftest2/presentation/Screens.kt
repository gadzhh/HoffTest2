package com.example.hofftest2.presentation

import com.example.hofftest2.presentation.detail.ui.DetailFragment
import com.example.hofftest2.presentation.order.ui.OrderFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun orderScreen() = FragmentScreen{OrderFragment()}
    fun detailScreen(id: String,
                     productNumber: String,
                     productDateTime: Int,
                     productDelivery: String) =
        FragmentScreen{DetailFragment.newInstance(id = id,
                                                  productNumber = productNumber,
                                                  productDateTime = productDateTime,
                                                  productDelivery = productDelivery )}
}