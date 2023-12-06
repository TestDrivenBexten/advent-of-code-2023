import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@DisplayName("Day 2 Tests")
class Day2Tests {
    @Test
    @DisplayName("Should parse game with one draw")
    fun should_parse_game_with_one_draw() {
        val input = "Game 3: 8 green, 6 blue, 20 red"
        val game = parseGame(input)

        val expectedDraw = Draw(20, 8, 6)
        val expectedGame = Game(3, listOf(expectedDraw))
        assertEquals(expectedGame, game)
    }

    @Test
    @DisplayName("Should parse game with two draws")
    fun should_parse_game_with_two_draws() {
        val input = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green"
        val game = parseGame(input)

        val expectedFirstDraw = Draw(20, 8, 6)
        val expectedSecondDraw = Draw(4, 13, 5)
        val expectedGame = Game(3, listOf(expectedFirstDraw, expectedSecondDraw))
        assertEquals(expectedGame, game)
    }

    @Test
    @DisplayName("Should solve for small input")
    fun should_solve_for_small_input() {
        val path = Paths.get("src/test/kotlin/advent/of/code/day_2/Day2Small.txt")
        val strList = readStringListFromPath(path)

        val gameList = strList.map(::parseGame)
        val possibleGameList = gameList.filter(::isPossibleGame)

        val sum = possibleGameList.map { it.id }.sum()
        assertEquals(8, sum)
    }

    @Test
    @DisplayName("Should solve for big input")
    fun should_solve_for_big_input() {
        val path = Paths.get("src/test/kotlin/advent/of/code/day_2/Day2Big.txt")
        val strList = readStringListFromPath(path)

        val gameList = strList.map(::parseGame)
        val possibleGameList = gameList.filter(::isPossibleGame)

        val sum = possibleGameList.map { it.id }.sum()
        assertEquals(2_593, sum)
    }

    @Test
    @DisplayName("Should solve for small input part 2")
    fun should_solve_for_small_input_part_2() {
        val path = Paths.get("src/test/kotlin/advent/of/code/day_2/Day2Small.txt")
        val strList = readStringListFromPath(path)

        val gameList = strList.map(::parseGame)
        val minBallCountList = gameList.map(::calculateMinBallCount)

        val sum = minBallCountList.map { it.redCount * it.greenCount * it.blueCount }.sum()
        assertEquals(2_286, sum)
    }

    @Test
    @DisplayName("Should solve for big input part 2")
    fun should_solve_for_big_input_part_2() {
        val path = Paths.get("src/test/kotlin/advent/of/code/day_2/Day2Big.txt")
        val strList = readStringListFromPath(path)

        val gameList = strList.map(::parseGame)
        val minBallCountList = gameList.map(::calculateMinBallCount)

        val sum = minBallCountList.map { it.redCount * it.greenCount * it.blueCount }.sum()
        assertEquals(54_699, sum)
    }
}
