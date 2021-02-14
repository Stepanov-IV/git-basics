package com.skillbox.extensions_objects_enums

enum class PopularCurrency {
    RUB,
    EUR,
    USD;

    companion object {
        val nationCurrency = RUB
    }

    val PopularCurrency.isNation: Boolean
        get() = this == PopularCurrency.RUB

    object CurrencyConverter{
        val rub = 0.013
        val usd = 1
        val eur = 1.20
    }

}
fun PopularCurrency.convertToUSD(count:Double):Double{
    return when(this){
        PopularCurrency.RUB -> PopularCurrency.CurrencyConverter.rub * count
        PopularCurrency.USD -> PopularCurrency.CurrencyConverter.usd.toDouble() * count
        PopularCurrency.EUR -> PopularCurrency.CurrencyConverter.eur * count
    }
}