package com.sonatype.numberconverter.converter.impl


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EnglishNumberConverterTest {

    private val englishNumberConverter = EnglishNumberConverter

    @Test
    fun `Short positive number is correctly translated` () {
        assertEquals("one hundred twenty three", englishNumberConverter.asWords(123))
    }

    @Test
    fun `Long positive number is correctly translated` () {
        assertEquals("one billion three hundred twenty five million seven hundred sixty three thousand seven hundred eighty six",
            englishNumberConverter.asWords(1_325_763_786))
    }

    @Test
    fun `Negative numbers are correctly translated` () {
        assertEquals("negative one hundred twenty three", englishNumberConverter.asWords(-123))
    }

    @Test
    fun `0 return Zero` () {
        assertEquals("zero", englishNumberConverter.asWords(0))
    }
}