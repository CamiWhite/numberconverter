package com.sonatype.numberconverter.util

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StringUtilsTest {

    @Test
    fun `A string is successfully chunked into pieces of 3` () {
        val string = "ThisIsaStringWithThirtyEightCharacters"
        val stringInChunks = StringUtils.splitInChunks(string)

        Assertions.assertEquals(13, stringInChunks.size)
        Assertions.assertEquals(stringInChunks.first, "Th")
        Assertions.assertEquals(stringInChunks.last, "ers")
        Assertions.assertEquals(string, stringInChunks.reduce { acc, s -> acc + s })
    }

    @Test
    fun `A string smaller than size 3 is not chunked` () {
        val string = "hey"
        val stringInChunks = StringUtils.splitInChunks(string)

        Assertions.assertEquals(string, stringInChunks.pop())
    }
}