private val asciiZero = 48

fun parseIntFromString(input: String) : Int {
    val firstDigitCode = input.find { it.isDigit() }?.code ?: asciiZero
    val firstDigit = parseDigit(firstDigitCode)

    val secondDigitCode = input.reversed().find { it.isDigit() }?.code ?: asciiZero
    val secondDigit = parseDigit(secondDigitCode)
    return (firstDigit * 10) + secondDigit
}

private fun parseDigit(ascii: Int) : Int {
    return ascii - 48
}
