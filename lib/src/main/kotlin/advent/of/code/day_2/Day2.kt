enum class Color {
    RED, GREEN, BLUE
}

data class Draw(val redCount: Int, val greenCount: Int, val blueCount: Int)

data class MinBallCount(val redCount: Int, val greenCount: Int, val blueCount: Int)
data class Game(val id: Int, val drawList: List<Draw>)

val gameRegex = "Game (\\d+)".toRegex()
fun parseGame(input: String): Game {
    // Drop 'Game \d: '
    val colonIndex = input.indexOf(':')
    val trimmedInput = input.drop(colonIndex + 2)
    val rawDrawList = trimmedInput.split(';')
    val drawList = rawDrawList.map(::parseDraw)

    val matchResult = gameRegex.find(input)
    val gameId = matchResult?.groups?.get(1)?.value?.toInt() ?: 0
    return Game(gameId, drawList)
}

fun parseDraw(input: String): Draw {
    val rawCountList = input.split(',')
    val countList = rawCountList.map(::parseCount)

    val redCount = countList.find { it.first == Color.RED }?.second ?: 0
    val greenCount = countList.find { it.first == Color.GREEN }?.second ?: 0
    val blueCount = countList.find { it.first == Color.BLUE }?.second ?: 0

    return Draw(redCount, greenCount, blueCount)
}

fun isPossibleGame(game: Game): Boolean {
    return game.drawList.all(::isPossibleDraw)
}

fun isPossibleDraw(draw: Draw): Boolean {
    val validRedCount = draw.redCount <= 12
    val validGreenCount = draw.greenCount <= 13
    val validBlueCount = draw.blueCount <= 14
    return validRedCount && validGreenCount && validBlueCount
}

typealias Count = Int
val numberRegex = "(\\d+)".toRegex()
fun parseCount(input: String): Pair<Color, Count> {
    return if (input.contains("green")) {
        val matchResult = numberRegex.find(input)
        val green = matchResult?.groups?.get(1)
        val greenCount = green?.value?.toInt() ?: 0
        Pair(Color.GREEN, greenCount)
    } else if (input.contains("blue")) {
        val matchResult = numberRegex.find(input)
        val blue = matchResult?.groups?.get(1)
        val blueCount = blue?.value?.toInt() ?: 0
        Pair(Color.BLUE, blueCount)
    } else if (input.contains("red")) {
        val matchResult = numberRegex.find(input)
        val red = matchResult?.groups?.get(1)
        val redCount = red?.value?.toInt() ?: 0
        Pair(Color.RED, redCount)
    } else {
        val matchResult = numberRegex.find(input)
        val red = matchResult?.groups?.get(1)
        val redCount = red?.value?.toInt() ?: 0
        Pair(Color.RED, redCount)
    }
}

fun calculateMinBallCount(game: Game) : MinBallCount {
    val redCount = game.drawList.map { it.redCount }.max()
    val blueCount = game.drawList.map { it.blueCount }.max()
    val greenCount = game.drawList.map { it.greenCount }.max()
    return MinBallCount(redCount, greenCount, blueCount)
}
