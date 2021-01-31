package com.skillbox.room.oop
//Что нужно сделать
//
//1.Создайте класс Room. Класс должен быть открытым для наследования.
//2.В конструктор класса добавьте параметр «площадь»
// (area, тип переменной — Double, значения в квадратных метрах).
// Реализуйте одноимённое публичное свойство внутри класса, сделайте его неизменяемым.
//3.Добавьте в класс Room неизменяемое (protected) свойство title строкового типа.
// Сделайте свойство открытым для переопределения. Значение для класса Room — «Обычная комната».
//4.Добавьте функцию getDescription, которая будет выводить информацию о комнате — её название
// и площадь. Метод должен быть закрытым для переопределения.
//5.Создайте экземпляр класса Room, вызовите у него метод getDescription,
// выведите информацию о комнате на экран.
//6.Создайте наследников класса Room: спальню, гостиную, кухню и санузел.
// Дайте им названия в соответствии с английскими переводами.
//7.Переопределите свойства title для каждой комнаты в соответствии с её назначением.
//8.Создайте класс детской комнаты. Он будет отличаться от остальных классов тем,
// что его поле title должно стать изменяемым — в дальнейшем мы сможем изменить назначение комнаты,
// например сделав её спальней или кабинетом.
//9.Создайте класс комнаты свободного назначения. Он будет отличаться от остальных тем,
// что значение title должно передаваться в конструктор. Свойство title так же, как и в детской,
// должно изменяться.
//10.Создайте комнаты с характеристиками жилища своей мечты.
// Выведите информацию о получившихся комнатах на экран.
//*По желанию. Добавьте больше различных типов комнат и их характеристик,
// но сильно не увлекайтесь: большим количеством свойств сложно управлять и легко ошибиться.

fun main() {
    val room = Room(20.00, 2)
    room.getDescription()

    val bathroom = Bathroom(10.5, 0)
    bathroom.getDescription()

    val livingRoom = LivingRoom(23.0, 3)
    livingRoom.getDescription()

    val kitchen = Kitchen(25.0, 2)
    kitchen.getDescription()

    val children = Сhildren(15.0,1)
    children.getDescription()

    val freeRoom = FreeRoom(10.0, 0,"Кладовка")
    freeRoom.getDescription()
}