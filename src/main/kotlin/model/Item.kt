package model

import kotlin.reflect.typeOf

abstract class Item(val name: String, val quantity: Int, val price: Float, val imported: Boolean) {

    override fun toString(): String {
        return "name: $name, quantity: $quantity, price: $price, imported: $imported, type: ${this.javaClass.name}"
    }

    override fun hashCode(): Int {
        return this.toString().hashCode()
    }
    override fun equals(other: Any?): Boolean {
        return this.hashCode() == other?.hashCode()
    }
}

class Book(name: String, quantity: Int, price: Float, imported: Boolean) : Item(name, quantity, price, imported) {

}

class Food(name: String, quantity: Int, price: Float, imported: Boolean) : Item(name, quantity, price, imported) {

}

class Other(name: String, quantity: Int, price: Float, imported: Boolean) : Item(name, quantity, price, imported) {

}

class Medical(name: String, quantity: Int, price: Float, imported: Boolean) : Item(name, quantity, price, imported) {

}