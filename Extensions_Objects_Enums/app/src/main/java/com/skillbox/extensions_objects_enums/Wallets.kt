package com.skillbox.extensions_objects_enums

sealed class Wallets(){

    abstract fun moneyInUSD(): Double

    class Virtual(): Wallets() {
        private var virtualDollar : Double = 0.0
        private var virtualEuro : Double = 0.0
        private var virtualRuble : Double = 0.0

        fun addMoney(currencyType: PopularCurrency, amountMoney: Double){
            when(currencyType){
                PopularCurrency.USD -> virtualDollar += amountMoney
                PopularCurrency.EUR -> virtualEuro += amountMoney
                PopularCurrency.RUB -> virtualRuble += amountMoney
            }

        }

        override fun toString(): String {
            return "Virtual(virtualDollar=$virtualDollar, virtualEuro=$virtualEuro, virtualRuble=$virtualRuble) "
        }



        override fun moneyInUSD(): Double {
            return PopularCurrency.USD.convertToUSD(virtualDollar) +
                    PopularCurrency.EUR.convertToUSD(virtualEuro) +
                    PopularCurrency.RUB.convertToUSD(virtualRuble)
        }
    }

    class Real(): Wallets() {
        private var realDollar: MutableMap<Int,Int>  = mutableMapOf()
        private var realEuro : MutableMap<Int,Int>  = mutableMapOf()
        private var realRuble : MutableMap<Int,Int>  = mutableMapOf()

        fun addMoney(currencyType: PopularCurrency, nominal:Int, count: Int ){
            when(currencyType){
                PopularCurrency.USD -> {
                    if (realDollar.containsKey(nominal) && realDollar[nominal] != null){
                       realDollar[nominal] = realDollar[nominal]!!.plus(count)
                    } else realDollar[nominal] = count
                }

                PopularCurrency.EUR -> {
                    if (realEuro.containsKey(nominal) && realEuro[nominal] != null){
                        realEuro[nominal] = realEuro[nominal]!!.plus(count)
                    } else realEuro[nominal] = count
                }

                PopularCurrency.RUB -> {
                    if (realRuble.containsKey(nominal) && realRuble[nominal] != null){
                        realRuble[nominal] = realRuble[nominal]!!.plus(count)
                    } else realRuble[nominal] = count
                }

            }

        }

        override fun moneyInUSD(): Double {
            val dollarsSum: Double = realDollar.map { (nominal, value) -> nominal * value }.sum().toDouble()
            val eurosSum: Double = realEuro.map { (nominal, value) -> nominal * value }.sum().toDouble()
            val rublesSum: Double = realRuble.map { (nominal, value) -> nominal * value }.sum().toDouble()

            return PopularCurrency.USD.convertToUSD(dollarsSum) +
                    PopularCurrency.EUR.convertToUSD(eurosSum) +
                    PopularCurrency.RUB.convertToUSD(rublesSum)
        }
        override fun toString(): String {
            return "Real(virtualDollar=$realDollar, virtualEuro=$realEuro, virtualRuble=$realRuble)"
        }

    }
    override fun equals(other: Any?): Boolean {
        if (other is Wallets) {
            return this.moneyInUSD() == other.moneyInUSD()
        }
        return false
    }


}