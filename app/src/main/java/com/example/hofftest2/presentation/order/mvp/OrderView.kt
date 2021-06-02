package com.example.hofftest2.presentation.order.mvp

import com.example.hofftest2.data.model.listorder.OrderList

interface OrderView {
    fun showProgress()
    fun hideProgress()
    fun showOrders(orders: OrderList)
    fun showError(error: String)
}