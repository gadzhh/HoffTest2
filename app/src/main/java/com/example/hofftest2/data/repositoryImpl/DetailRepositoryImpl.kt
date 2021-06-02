package com.example.hofftest2.data.repositoryImpl

import com.example.hofftest2.data.model.detailorder.OrderDetail
import com.example.hofftest2.data.network.Api
import com.example.hofftest2.domain.common.SchedulersProvider
import com.example.hofftest2.domain.repository.DetailRepository
import io.reactivex.Single
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val api: Api,
    private val schedulers: SchedulersProvider
) : DetailRepository {

    override fun getDetail(): Single<OrderDetail> {
        return api.getDetailOrder(
            "dham5rnqcn",
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
}