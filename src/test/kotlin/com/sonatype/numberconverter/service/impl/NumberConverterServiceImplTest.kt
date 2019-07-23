package com.sonatype.numberconverter.service.impl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NumberConverterServiceImplTest {

    private val numberConverterService = NumberConverterServiceImpl

    private val errorNumberRangeMessage = "Number should be between 0 and 1000000"
    private val errorIllegalNumberMessage = "Input string is not a valid number"

    @Test
    fun `Negative numbers are not allowed and a message is returned` () {
        Assertions.assertEquals(errorNumberRangeMessage,
            numberConverterService.convertNumber("-5"))
    }

    @Test
    fun `Number should not exceed 1000000` () {
        Assertions.assertEquals(errorNumberRangeMessage,
            numberConverterService.convertNumber("1000001"))
    }

    @Test
    fun `Special characters are not allowed and a message is returned` () {
        Assertions.assertEquals(errorIllegalNumberMessage,
            numberConverterService.convertNumber("1.2"))
        Assertions.assertEquals(errorIllegalNumberMessage,
            numberConverterService.convertNumber(""))
        Assertions.assertEquals(errorIllegalNumberMessage,
            numberConverterService.convertNumber("  "))
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
}