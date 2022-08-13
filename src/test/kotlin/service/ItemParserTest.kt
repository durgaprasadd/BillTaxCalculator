package service

import exception.InvalidItemDescription
import io.kotlintest.shouldBe
import model.Book
import model.Food
import model.Medical
import model.Other
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ItemParserTest {
    private val itemParser = ItemParser()

    @Test
    fun `should able to parse valid description`() {
        itemParser.parse("1 bottle of perfume at 10.00") shouldBe Other("bottle of perfume", 1, 10.0F, false)
    }

    @Test
    fun `should able to parse valid description for imported item`() {
        itemParser.parse("1 imported bottle of perfume at 10.00") shouldBe Other("imported bottle of perfume", 1, 10.0F, true)
    }

    @Test
    fun `should throw exception for invalid quantity`() {
        val exception = org.junit.jupiter.api.assertThrows<InvalidItemDescription> { itemParser.parse("x bottle of perfume at 10.00") }
        exception.message shouldBe "invalid quantity"
    }

    @Test
    fun `should throw exception for invalid price`() {
        val exception = org.junit.jupiter.api.assertThrows<InvalidItemDescription> { itemParser.parse("1 bottle of perfume at ") }
        exception.message shouldBe "invalid price"
    }

    @Nested
    inner class BookItem {
        @Test
        fun `should able to parse valid description for Book Item`() {
            itemParser.parse("1 book at 10.00") shouldBe Book("book", 1, 10.0F, false)
        }
    }

    @Nested
    inner class MedicalItem {
        @Test
        fun `should able to parse valid description for Medical Item`() {
            itemParser.parse("1 box of medicines at 10.00") shouldBe Medical("box of medicines", 1, 10.0F, false)
        }

        @Test
        fun `should able to parse valid description for Medical Item with different term`() {
            itemParser.parse("1 medical kit at 10.00") shouldBe Medical("medical kit", 1, 10.0F, false)
        }
    }

    @Nested
    inner class FoodItem {
        @Test
        fun `should able to parse valid description for Food Item`() {
            itemParser.parse("1 box of chocolates at 10.00") shouldBe Food("box of chocolates", 1, 10.0F, false)
        }

        @Test
        fun `should able to parse valid description for Food Item with different term`() {
            itemParser.parse("1 food box at 10.00") shouldBe Food("food box", 1, 10.0F, false)
        }
    }
}