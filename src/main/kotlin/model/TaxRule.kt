package model

abstract class TaxRule {
    abstract fun isApplicable(item: Item): Boolean
    abstract fun getTaxPercentage(): Float
    fun applyTax(item: Item): Float {
        return if(isApplicable(item)){
            getTaxPercentage() * (item.price * item.quantity)
        }else {
            0F
        }
    }
}