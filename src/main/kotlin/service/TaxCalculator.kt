package service

import model.ImportTaxRule
import model.Item
import model.SalesTaxRule

class TaxCalculator(
    private val items: List<Item>,
    private val printer: (input: String) -> Unit = ::println
) {

    fun printReceipt() {
        var totalSalesTax = 0F
        var total = 0F
        val salesTaxRule = SalesTaxRule()
        val importTaxRule = ImportTaxRule()
        for (item in items) {
            val salesTax = salesTaxRule.applyTax(item)
            val importTax = importTaxRule.applyTax(item)
            val price = item.price + salesTax + importTax
            printer("${item.quantity} ${item.name}: $price")
            totalSalesTax += salesTax
            total += price
        }
        printer("Sales Tax: $totalSalesTax")
        printer("Total: $total")
    }
}