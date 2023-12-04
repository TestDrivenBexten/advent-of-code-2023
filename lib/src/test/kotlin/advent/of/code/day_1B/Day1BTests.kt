import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@DisplayName("Day 1B Tests")
class Day1BTests {

    @Test
    @DisplayName("Should return 142 for small inputs")
    fun should_return_small_input() {
        val path = Paths.get("src/test/kotlin/advent/of/code/day_1B/Day1BSmall.txt")
        val strList = readStringListFromPath(path)

        val sum = strList.map(::parseSpelledIntFromString).sum()
        assertEquals(281, sum)
    }

    @Test
    @DisplayName("Should return 55_701 for big inputs")
    fun should_return_big_input() {
        val path = Paths.get("src/test/kotlin/advent/of/code/day_1B/Day1BBig.txt")
        val strList = readStringListFromPath(path)

        val sum = strList.map(::parseSpelledIntFromString).sum()
        assertEquals(55_701, sum)
    }

    @Test
    @DisplayName("Should return 21 for 'ntwoxonel'")
    fun should_parse_spelled_out_string() {
        val input = "ntwoxonel"
        val number = parseSpelledIntFromString(input)
        assertEquals(21, number)
    }

    @Test
    @DisplayName("Should return 13 for 'x1two3n'")
    fun should_parse_digits_from_string() {
        val input = "x1two3n"
        val number = parseSpelledIntFromString(input)
        assertEquals(13, number)
    }
}