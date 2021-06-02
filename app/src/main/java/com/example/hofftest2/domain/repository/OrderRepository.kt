package com.example.hofftest2.domain.repository

import com.example.hofftest2.data.model.listorder.OrderList
import io.reactivex.Single

interface OrderRepository {
    fun getOrders(): Single<OrderList>
}