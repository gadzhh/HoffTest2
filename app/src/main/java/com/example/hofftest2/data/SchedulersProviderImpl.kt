package com.example.hofftest2.data

import com.example.hofftest2.domain.common.SchedulersProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulersProviderImpl @Inject constructor() : SchedulersProvider {
    override val ui: Scheduler
        get() = AndroidSchedulers.mainThread()
    override val computation: Scheduler
        get() = Schedulers.computation()
    override val trampoline: Scheduler
        get() = Schedulers.trampoline()
    override val newThread: Scheduler
        get() = Schedulers.newThread()
    override val io: Scheduler
        get() = Schedulers.io()
}