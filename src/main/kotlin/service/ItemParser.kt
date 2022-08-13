package service

import exception.InvalidItemDescription
import model.Book
import model.Food
import model.Item
import model.Medical
import model.Other

class ItemParser {
    fun parse(description: String): Item {
        val quantity = description.takeWhile { it.isDigit() }
        if (!verifyQuantity(quantity)) {
            throw InvalidItemDescription("invalid quantity")
        }
        val (name, price) = description.substring(quantity.length + 1).split(" at ")
        if (!verifyPrice(price.trim())) {
            throw InvalidItemDescription("invalid price")
        }
        return getItem(quantity.toInt(), name.trim(), price.toFloat())
    }

    private fun getItem(quantity: Int, name: String, price: Float): Item {
        return when {
            isMedical(name) -> Medical(name, quantity, price, isImported(name))
            isBook(name) -> Book(name, quantity, price, isImported(name))
            isFood(name) -> Food(name, quantity, price, isImported(name))
            else -> Other(name, quantity, price, isImported(name))
        }
    }

    private fun isImported(name: String): Boolean {
        return name.lowercase().trim().contains("import")
    }

    private fun isMedical(name: String): Boolean {
        val medicalTerms = listOf("medical", "medicine")
        return medicalTerms.any { name.lowercase().contains(it) }
    }

    private fun isBook(name: String): Boolean {
        val bookTerms = listOf("book")
        return bookTerms.any { name.lowercase().contains(it) }
    }

    private fun isFood(name: String): Boolean {
        val foodTerms = listOf("food", "chocolate")
        return foodTerms.any { name.lowercase().contains(it) }
    }

    private fun verifyQuantity(quantity: String): Boolean {
        return quantity.isNotEmpty() && quantity.toInt() > 0
    }

    private fun verifyPrice(price: String): Boolean {
        return price.isNotEmpty() && price.toFloat() > 0
    }
}