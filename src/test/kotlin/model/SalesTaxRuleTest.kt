package model

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class SalesTaxRuleTest {

    @Nested
    class Applicable {
        private val salesTaxRule = SalesTaxRule()
        @Test
        fun `should return false for book item`(){
            val item  = Item("book", 1,100F,false)
            salesTaxRule.isApplicable(item) shouldBe false
        }
    }
}