import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun maestroMastercardNoCommission() {
        val amount1 = 1000.0
        val result1 = 0.0
        val maestroMastercard1 = maestroMastercard(amount1,result1)
        assertEquals(amount1,maestroMastercard1,0.0)
    }

    @Test
    fun maestroMastercardWithCommission() {
        val amount1 = 100.0
        val result1 = 0.0
        val result2 = amount1 * 0.06 + 20 + amount1
        val maestroMastercard2 = maestroMastercard(amount1,result1)
        assertEquals(result2,maestroMastercard2,0.0)
    }

    @Test
    fun visaPlus35() {
        val amount1 = 10.0
        val result1 = 0.0
        val result2 = amount1 + 35
        val visa = visa(amount1,result1)
        assertEquals(result2,visa,0.0)
    }

    @Test
    fun visaCommision() {
        val amount1 = 1000.0
        val result1 = 0.0
        val result2 = amount1 * 0.75 + amount1
        val visa = visa(amount1,result1)
        assertEquals(result2,visa,0.0)
    }

    @Test
    fun vkPay() {
        val amount1 = 1000.0
        val result1 = 0.0
        val vkpay:Double = vkPay(amount1,result1)
        assertEquals(amount1,vkpay,0.0)
    }

    @Test
    fun commissionVisa() {
        val card = "Visa"
        val amount = 100.0
        val result = 0.0
        val commissionVisa = visa(amount,result)
        val Resultcommission = commission(card,amount,result)
        assertEquals(commissionVisa,Resultcommission,0.0)

    }

    @Test
    fun commissionMir() {
        val card = "Мир"
        val amount = 100.0
        val result = 0.0
        val commissionMir = visa(amount,result)
        val Resultcommission = commission(card,amount,result)
        assertEquals(commissionMir,Resultcommission,0.0)
    }

    @Test
    fun commissionMastercard() {
        val card = "Mastercard"
        val amount = 100.0
        val result = 0.0
        val commissionMastercard = maestroMastercard(amount,result)
        val Resultcommission = commission(card,amount,result)
        assertEquals(commissionMastercard,Resultcommission,0.0)
    }

    @Test
    fun commissionMaestro() {
        val card = "Maestro"
        val amount = 100.0
        val result = 0.0
        val commissionMaestro = maestroMastercard(amount,result)
        val Resultcommission = commission(card,amount,result)
        assertEquals(commissionMaestro,Resultcommission,0.0)
    }

    @Test
    fun commissionVK_Pay() {
        val card = "VK Pay"
        val amount = 100.0
        val result = 0.0
        val Resultcommission = commission(card,amount,result)
        assertEquals(amount,Resultcommission,0.0)
    }

    @Test
    fun transferVisaWithoutAmountAtDaysAndTransfer() {
        val card = "Visa"
        val amount = 100.0
        val result = 0.0
        val transfer = 0.0
        val amountAtDays = 0.0
        val trasferVisa = true
        assertEquals(trasferVisa,transfer(transfer,card,amount,result,amountAtDays))
    }

    @Test
    fun transferVisaWithAmountAtDaysAndTransfer() {
        val card = "Visa"
        val amount = 100.0
        val result = 0.0
        val transfer = 0.0
        val amountAtDays = 150_000.0
        val trasferVisa = false
        assertEquals(trasferVisa,transfer(transfer,card,amount,result,amountAtDays))
    }

    @Test
    fun transferVisaWithoutAmountAtDaysAndWithTransfer() {
        val card = "Visa"
        val amount = 100.0
        val result = 0.0
        val transfer = 600_000.0
        val amountAtDays = 0.0
        val trasferVisa = false
        assertEquals(trasferVisa,transfer(transfer,card,amount,result,amountAtDays))
    }

    @Test
    fun transferVK_Pay() {
        val card = "VK Pay"
        val amount = 100.0
        val result = 0.0
        val transfer = 0.0
        val amountAtDays = 0.0
        val transferVK_Pay = true
        assertEquals(transferVK_Pay,transfer(transfer,card,amount,result,amountAtDays))
    }

    @Test
    fun transferVK_PayWithAmount() {
        val card = "VK Pay"
        val amount = 100_000.0
        val result = 0.0
        val transfer = 0.0
        val amountAtDays = 0.0
        val transferVK_Pay = false
        assertEquals(transferVK_Pay,transfer(transfer,card,amount,result,amountAtDays))
    }

    @Test
    fun transferVK_PayWithTransfer() {
        val card = "VK Pay"
        val amount = 10_000.0
        val result = 0.0
        val transfer = 100_000.0
        val amountAtDays = 0.0
        val transferVK_Pay = false
        assertEquals(transferVK_Pay,transfer(transfer,card,amount,result,amountAtDays))
    }

}