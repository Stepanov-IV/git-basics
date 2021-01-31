package com.skillbox.room.oop

class FreeRoom(_area: Double, _window: Int, _title: String): Room(_area, _window) {
    override var title: String = _title
}