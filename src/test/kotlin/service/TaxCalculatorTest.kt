package service

import io.kotlintest.shouldBe
import model.Food
import org.junit.jupiter.api.Test

internal class TaxCalculatorTest {
    var receipt = ""

    @Test
    fun `should printout the receipt for valid articles`() {
        val expected = "1 imported box of chocolates: 10.5" +
                "\nSales Tax: 0.0" +
                "\nTotal: 10.5" +
                "\n"
        val items = listOf(
            Food("imported box of chocolates", 1, 10F, true)
        )
        val calculator = TaxCalculator(items, ::printer)
        calculator.printReceipt()
        receipt shouldBe expected
    }

    fun printer(input: String) {
        receipt += input + "\n"
    }
}