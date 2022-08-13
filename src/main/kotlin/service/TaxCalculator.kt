package service

import model.Item
import model.Other

class TaxCalculator(
    private val items: List<Item>,
    private val printer: (input:String) -> Unit = ::println
) {

    fun printReceipt() {
        var totalSalesTax = 0F
        var total = 0F
        for (item in items) {
            val salesTax = calculateSalesTax(item)
            val importTax = calculateImportTax(item)
            val price = item.price + salesTax + importTax
            printer("${item.quantity} ${item.name}: $price")
            totalSalesTax += salesTax
            total += price
        }
        printer("Sales Tax: $totalSalesTax")
        printer("Total: $total")
    }

    private fun calculateSalesTax(item: Item): Float {
        return when (item) {
            is Other -> item.price * 0.1F
            else -> 0F
        }
    }

    private fun calculateImportTax(item: Item): Float {
        return when (item.imported) {
            true -> item.price * 0.05F
            false -> 0F
        }
    }
}