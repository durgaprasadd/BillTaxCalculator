package model

import kotlin.reflect.typeOf

class Item(val name: String, val quantity: Int, val price: Float, val imported: Boolean) {

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