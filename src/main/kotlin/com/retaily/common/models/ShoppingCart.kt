package com.retaily.common.models

data class ShoppingCart(val id: Long, val items: List<ShoppingCartItem>) {
    val type = "shoppingCart"
}
