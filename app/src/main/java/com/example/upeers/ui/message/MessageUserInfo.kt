package com.example.upeers.ui.message

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

open class MessageUserInfo(
    val label: String,
    val name: String,
    val active: Boolean,
    val lastMsg: String,
    val timeLastMsg: Date,
    val avatar: Int
) {

}
