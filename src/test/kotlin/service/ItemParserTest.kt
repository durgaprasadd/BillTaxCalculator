package service

import exception.InvalidItemDescription
import io.kotlintest.shouldBe
import model.Item
import org.junit.jupiter.api.Test

internal class ItemParserTest {
    private val itemParser = ItemParser()

    @Test
    fun `should able to parse valid description`() {
        itemParser.parse("1 bottle of perfume at 10.00") shouldBe Item("bottle of perfume", 1, 10.0F, false)
    }

    @Test
    fun `should able to parse valid description for imported item`() {
        itemParser.parse("1 imported bottle of perfume at 10.00") shouldBe Item(
            "imported bottle of perfume",
            1,
            10.0F,
            true
        )
    }

    @Test
    fun `should throw exception for invalid quantity`() {
        val exception =
            org.junit.jupiter.api.assertThrows<InvalidItemDescription> { itemParser.parse("x bottle of perfume at 10.00") }
        exception.message shouldBe "invalid quantity"
    }

    @Test
    fun `should throw exception for invalid price`() {
        val exception =
            org.junit.jupiter.api.assertThrows<InvalidItemDescription> { itemParser.parse("1 bottle of perfume at ") }
        exception.message shouldBe "invalid price"
    }
}