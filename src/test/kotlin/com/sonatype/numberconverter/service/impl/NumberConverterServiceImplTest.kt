package com.sonatype.numberconverter.service.impl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NumberConverterServiceImplTest {

    private val numberConverterService = NumberConverterServiceImpl

    private val errorNumberRangeMessage = "Number should be between ${Int.MIN_VALUE} and ${Int.MAX_VALUE}"
    private val errorIllegalNumberMessage = "Input string is not a valid number"

    @Test
    fun `Number should not be below Int#MIN_VALUE` () {
        Assertions.assertEquals(errorNumberRangeMessage,
            numberConverterService.convertNumber("-2147483649"))
    }

    @Test
    fun `Number should not exceed Int#MAX_VALUE` () {
        Assertions.assertEquals(errorNumberRangeMessage,
            numberConverterService.convertNumber("2147483648"))
    }

    @Test
    fun `No decimals allowed and a message is returned` () {
        Assertions.assertEquals(errorIllegalNumberMessage,
            numberConverterService.convertNumber("1.2"))
    }

    @Test
    fun `Empty strings not allowed and a message is returned` () {
        Assertions.assertEquals(errorIllegalNumberMessage,
            numberConverterService.convertNumber(""))
        Assertions.assertEquals(errorIllegalNumberMessage,
            numberConverterService.convertNumber("  "))
    }

    @Test
    fun `Special characters are not allowed and a message is returned` () {
        Assertions.assertEquals(errorIllegalNumberMessage,
            numberConverterService.convertNumber("$12"))
    }

    @Test
    fun `Number converted successfully` () {
        Assertions.assertEquals("one hundred twenty three",
            numberConverterService.convertNumber("123"))
        Assertions.assertEquals("forty two thousand three hundred fifty three",
            numberConverterService.convertNumber("42353"))
    }

    @Test
    fun `Negative number converted successfully` () {
        Assertions.assertEquals("negative one hundred twenty three",
            numberConverterService.convertNumber("-123"))
        Assertions.assertEquals("negative forty two thousand three hundred fifty three",
            numberConverterService.convertNumber("-42353"))
    }
}