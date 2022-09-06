package br.com.sscode.aluvery.extensions

import java.math.BigDecimal
import java.text.NumberFormat.getCurrencyInstance
import java.util.*

val BRAZILIAN_LOCATION = Locale("pt", "br")

fun BigDecimal.toBrazilianCurrency(): String =
    getCurrencyInstance(BRAZILIAN_LOCATION).format(this)
