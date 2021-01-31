package com.skillbox.room.oop

open class Room (_area: Double, _window:Int) {
    val area: Double = _area
    val window: Int = _window
    open val title: String = "Обычная комната"

    fun getDescription() {
        println("Помещение = ${title},   площадь = ${area} , количество окон = ${window}")
    }
}