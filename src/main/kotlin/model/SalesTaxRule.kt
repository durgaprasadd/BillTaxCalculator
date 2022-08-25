package model

class SalesTaxRule: TaxRule() {
    override fun isApplicable(item: Item): Boolean {
        val medicalTerms = listOf("medical", "medicine")
        val bookTerms = listOf("book")
        val foodTerms = listOf("food", "chocolate")
        return (medicalTerms + bookTerms + foodTerms).all { !item.name.contains(it) }
    }

    override fun getTaxPercentage(): Float {
        return 0.1F
    }
}