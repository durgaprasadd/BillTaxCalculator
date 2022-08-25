package service

import io.kotlintest.shouldBe
import model.Item
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TaxCalculatorTest {
    var receipt = ""

    @BeforeEach
    fun setup(){
        receipt = ""
    }

    @Test
    fun `should printout the receipt for valid articles`() {
        val expected = "1 imported box of chocolates: 10.5" +
                "\nSales Tax: 0.0" +
                "\nTotal: 10.5" +
                "\n"
        val items = listOf(
            Item("imported box of chocolates", 1, 10F, true)
        )
        val calculator = TaxCalculator(items, ::printer)
        calculator.printReceipt()
        receipt shouldBe expected
    }

    @Test
    fun `should printout the receipt for valid articles where no tax applied`() {
        val expected = "1 box of chocolates: 10.0" +
                "\nSales Tax: 0.0" +
                "\nTotal: 10.0" +
                "\n"
        val items = listOf(
            Item("box of chocolates", 1, 10F, false)
        )
        val calculator = TaxCalculator(items, ::printer)
        calculator.printReceipt()
        receipt shouldBe expected
    }

    @Test
    fun `should printout the receipt for the articles where sales tax and import tax applied`() {
        val expected = "1 imported bottle of perfume: 54.625" +
                "\nSales Tax: 4.75" +
                "\nTotal: 54.625" +
                "\n"
        val items = listOf(
            Item("imported bottle of perfume", 1, 47.50F, true)
        )
        val calculator = TaxCalculator(items, ::printer)
        calculator.printReceipt()
        receipt shouldBe expected
    }

    @Test
    fun `should printout the receipt for the articles where sales tax applied`() {
        val expected = "1 bottle of perfume: 52.25" +
                "\nSales Tax: 4.75" +
                "\nTotal: 52.25" +
                "\n"
        val items = listOf(
            Item("bottle of perfume", 1, 47.50F, false)
        )
        val calculator = TaxCalculator(items, ::printer)
        calculator.printReceipt()
        receipt shouldBe expected
    }

    fun printer(input: String) {
        receipt += input + "\n"
    }
}