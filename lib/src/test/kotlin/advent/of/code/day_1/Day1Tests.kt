import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@DisplayName("Day 1 Tests")
class Day1Tests {

    @Test
    @DisplayName("Should return 142 for small inputs")
    fun should_return_small_input() {
        val path = Paths.get("src/test/kotlin/advent/of/code/day_1/Day1Small.txt")
        val strList = readStringListFromPath(path)

        val sum = strList.map(::parseIntFromString).sum()
        assertEquals(142, sum)
    }

    @Test
    @DisplayName("Should return 56_397 for big inputs")
    fun should_return_big_input() {
        val path = Paths.get("src/test/kotlin/advent/of/code/day_1/Day1Big.txt")
        val strList = readStringListFromPath(path)

        val sum = strList.map(::parseIntFromString).sum()
        assertEquals(56_397, sum)
    }

    @Test
    @DisplayName("Should return 15 for 'a1b3c5de'")
    fun should_parse_number_from_string() {
        val input = "a1b3c5de"
        val number = parseIntFromString(input)
        assertEquals(15, number)
    }
}
