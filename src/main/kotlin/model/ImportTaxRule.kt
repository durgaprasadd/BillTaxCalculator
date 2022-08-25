package model

class ImportTaxRule : TaxRule() {
    override fun isApplicable(item: Item): Boolean {
        return item.imported
    }

    override fun getTaxPercentage(): Float {
        return 0.05F
    }

}