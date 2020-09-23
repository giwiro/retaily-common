package com.retaily.common.models

data class OrderUser(val id: Long, val firstName: String, val lastName: String, val email: String) {
    val type = "orderUser"
}
