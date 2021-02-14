package com.skillbox.extensions_objects_enums
//1.Объявите enum class популярных валют — рубли, доллары, евро.
//2.Внутри класса enum создайте companion object, в котором объявите переменную
// «национальная валюта». Значение может быть любым.
//3.Создайте extension-свойство, расширяющее функционал валюты.
// Свойство должно иметь тип Boolean и определять, является ли валюта национальной.
//4.Создайте глобальный объект CurrencyConverter. Внутри него в качестве статических
// переменных объявите курсы каждой валюты относительно доллара.
//5.Для enum класса валют создайте extension метод convertToUSD, конвертирующий любое
// значение валюты в доллары. Метод должен принимать количество валюты, а возвращать
// относительное значение в долларах.
//6.Создайте sealed класс Wallets, который реализует два типа кошельков, виртуальный и реальный:
//6.1Виртуальный кошелёк хранит значения валют в виде трёх отдельных переменных типа Double.
// Все переменные должны быть закрыты для изменения снаружи (дальше мы напишем функцию
// для обработки такого функционала).
//6.2Реальный кошелёк хранит каждую валюту в виде приватного свойства MutableMap<Int, Int>,
// где в качестве ключа выступает номинал купюры, а в качестве значения — количество купюр.
//7.Для каждого класса создайте методы addMoney, добавляющие в кошелёк деньги:
//7.1Для виртуального кошелька метод должен принимать два аргумента: тип валюты и
// количество добавляемых денег.
//7.2Для реального кошелька понадобится три аргумента: тип валюты, номинал купюры, количество купюр.
//8.У класса Wallets объявите абстрактный метод moneyInUSD, возвращающий количество денег
// в кошельке в пересчёте на доллары США. Реализуйте этот метод для каждого из наследников.
//9.Создайте два разных кошелька, добавьте в них немного денег в разных валютах, сравните
// значения кошельков. Выведите на экран содержимое кошельков (после конвертации в доллары).

fun main() {
    val virtualWallets = Wallets.Virtual()
    virtualWallets.addMoney(PopularCurrency.EUR, 0.0)
    virtualWallets.addMoney(PopularCurrency.USD, 1.0)
    virtualWallets.addMoney(PopularCurrency.RUB, 0.0)
    val realWallets = Wallets.Real()
    realWallets.addMoney(PopularCurrency.EUR, 0, 0)
    realWallets.addMoney(PopularCurrency.USD, 1, 1)
    realWallets.addMoney(PopularCurrency.RUB, 0, 0)

    println(virtualWallets.moneyInUSD())
    println(realWallets.moneyInUSD())
    println(virtualWallets.equals(realWallets))

}