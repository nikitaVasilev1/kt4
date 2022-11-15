fun main(args: Array<String>) {
    print("""Введите тип карты ("Visa","Мир","Mastercard","Maestro","VK Pay"): """)
    var card = readLine()!!.toString()
    print("Введите сумму перевода: ")
    var amount = readLine()!!.toDouble()
    var result = 0.0
    var amountAtDay = 0.0
    print("Введите сумму переводов в этом месяце: ")
    var transfer = readLine()!!.toDouble()
    if (card != "VK Pay") {
        print("Введите сумму переводов сегодня: ")
        amountAtDay = readLine()!!.toDouble()
    }
    var resultCommission = commission(card, amount, result)
    if (transfer(transfer, card, amount, resultCommission, amountAtDay)) println("Сумма перевода $resultCommission")


}

fun maestroMastercard(amount: Double, results: Double): Double {
    var result = results
    result = if (amount >= 300 && amount <= 75_000) amount else ((amount * 0.06 + 20) + amount)
    return result
}

fun visa(amount: Double, results: Double): Double {
    var result = results
    result = if (amount * 0.75 < 35) (amount + 35.0) else (amount * 0.75 + amount)
    return result
}

fun vkPay(amount: Double, results: Double): Double {
    var result = results
    result = amount
    return result
}

fun commission(card: String, amount: Double, results: Double): Double {
    var result = 0.0
    if (card == "Mastercard" || card == "Maestro") {
        result = maestroMastercard(amount, results)
    } else if (card == "Visa" || card == "Мир") {
        result = visa(amount, results)
    } else result = amount
    return result
}

fun transfer(transfer: Double, card: String, amount: Double, result: Double, amountAtDays: Double): Boolean {

    var limit = transfer + amount
    var amountAtDay = amountAtDays
    if (card == "VK Pay") {
        if (amount > 15_000 || limit > 40_000) {
            println("Перевод невозможен.")
            return false
        }
    } else {
        amountAtDay += amount
        if (limit > 600000 || amountAtDay > 150000) {
            println("Перевод невозможен.")
            return false
        }
    }
    return true
}