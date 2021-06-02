package com.example.hofftest2.domain.common

import io.reactivex.Scheduler

interface SchedulersProvider {
    val ui: Scheduler
    val computation: Scheduler
    val trampoline: Scheduler
    val newThread: Scheduler
    val io: Scheduler
}