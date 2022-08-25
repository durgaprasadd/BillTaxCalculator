package service

import exception.InvalidItemDescription
import model.Item

class ItemParser {
    fun parse(description: String): Item {
        val words = description.split(" ")
        val quantity = words.first()
        if (!verifyQuantity(quantity)) {
            throw InvalidItemDescription("invalid quantity")
        }
        val price = words.last()
        val name = words.subList(1, words.size - 2).joinToString(" ")
        if (!verifyPrice(price.trim())) {
            throw InvalidItemDescription("invalid price")
        }
        return getItem(quantity.toInt(), name.trim(), price.toFloat())
    }

    private fun getItem(quantity: Int, name: String, price: Float): Item {
        return Item(name, quantity, price, isImported(name))
    }

    private fun isImported(name: String): Boolean {
        return name.lowercase().trim().contains("import")
    }

    private fun verifyQuantity(quantity: String): Boolean {
        val parsedQuantity = quantity.toIntOrNull()
        return parsedQuantity != null && parsedQuantity > 0
    }

    private fun verifyPrice(price: String): Boolean {
        return price.isNotEmpty() && price.toFloat() > 0
    }
}