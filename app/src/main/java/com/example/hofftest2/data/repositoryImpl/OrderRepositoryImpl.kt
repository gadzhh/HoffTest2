package com.example.hofftest2.data.repositoryImpl

import com.example.hofftest2.data.model.listorder.OrderItems
import com.example.hofftest2.data.model.listorder.OrderList
import com.example.hofftest2.data.network.Api
import com.example.hofftest2.domain.common.SchedulersProvider
import com.example.hofftest2.domain.repository.OrderRepository
import io.reactivex.Single
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val api: Api,
    private val schedulers: SchedulersProvider
) : OrderRepository {

    override fun getOrders(): Single<OrderList> = api.getListOrder(
            "40ae023cef2b50fd",
            true,
            1,
            0,
            1,
            "1.8.43",
            "d1f5fdd5df78fed9d7b840b514b84004",
            19
        ).subscribeOn(schedulers.io)

}