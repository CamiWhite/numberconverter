package com.sonatype.numberconverter.service

import com.sonatype.numberconverter.converter.NumberConverter

/*
 * Defines the required methods to convert a number to its String value equivalent.
 */
interface NumberConverterService {

    /**
     * Converts a number in the form of "1234" to its string value equivalent
     *
     * @param number The number to be converted
     * @return The string value equivalent
     */
    fun convertNumber(number: String): String

    /**
     * Method intended to delegate the converter to be used to the implementing class
     *
     * @return The converter to be used
     */
    fun getConverter(): NumberConverter
}