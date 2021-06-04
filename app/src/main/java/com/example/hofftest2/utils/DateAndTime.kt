package com.example.hofftest2.utils

import java.text.SimpleDateFormat
import java.util.*

fun Int.dateTimeFormat(): String = SimpleDateFormat("от dd MMMM yyyy, hh:mm", Locale("ru"))
    .format(this)


