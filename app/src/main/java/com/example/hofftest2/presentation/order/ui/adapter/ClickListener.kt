package com.example.hofftest2.presentation.order.ui.adapter

interface ClickListener {
    fun buttonClick(id: String, productNumber: String, productDateTime: Int, productDelivery: String)
}