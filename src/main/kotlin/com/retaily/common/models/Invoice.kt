package com.retaily.common.models

import java.math.BigDecimal

data class Invoice(
    val id: Long,
    val userId: Long,
    val orderId: Long,
    val lines: List<InvoiceLine>,
    val billingAddress: Address,
    val total: BigDecimal
) {
    val type = "invoice"
}
