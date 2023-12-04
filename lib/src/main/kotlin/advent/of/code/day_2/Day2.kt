val numbersMap = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9
)
private val asciiZero = 48

fun parseSpelledIntFromString(input: String) : Int {
    val firstDigit = parseDigitFromString(input)
    val secondDigit = parseDigitFromString(input, true)

    return (firstDigit * 10) + secondDigit
}

fun parseDigitFromString(input: String, reversed: Boolean = false) : Int {
    if (input.length == 0) {
        return 0
    }

    val targetInput = if (reversed) input.reversed() else input

    val nextChar = targetInput.first()
    if (nextChar.isDigit()) {
        return parseDigit(nextChar.code)
    }

    // Check for spelled out digit
    val possibleDigit = numbersMap.keys.find { key ->
        val searchKey = if (reversed) key.reversed() else key
        if (key == "one" && reversed) {
            println(searchKey)
            println(targetInput)
        }
        targetInput.startsWith(searchKey)
    }
    if (reversed) {
        println(possibleDigit)
    }
    return if(possibleDigit != null) {
        numbersMap.get(possibleDigit) ?: 0
    } else {
        val nextInput = if (reversed) targetInput.drop(1).reversed() else targetInput.drop(1)
        parseDigitFromString(nextInput, reversed)
    } 
}

private fun parseDigit(ascii: Int) : Int {
    return ascii - asciiZero
}
