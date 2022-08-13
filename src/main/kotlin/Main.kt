import model.Item
import service.ItemParser
import service.TaxCalculator

fun main(args: Array<String>) {
    println("Enter number of articles")
    val N = readLine()!!.toInt()
    val items = mutableListOf<Item>()
    val parser = ItemParser()
    println("For each article enter description one by one")
    repeat(N){
        val description = readLine()!!.trim()
        val item = parser.parse(description)
        items.add(item)
    }

    val calculator = TaxCalculator(items)
    calculator.printReceipt()
}