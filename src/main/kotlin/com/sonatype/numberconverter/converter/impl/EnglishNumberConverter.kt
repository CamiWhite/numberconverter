package com.sonatype.numberconverter.converter.impl

import com.sonatype.numberconverter.converter.NumberConverter
import pl.allegro.finance.tradukisto.ValueConverters

/**
 * Singleton english converter using the tradukisto library to convert numbers to its text equivalent in english
 */
object EnglishNumberConverter: NumberConverter {

    /**
     * Converter to transform the number into words
     */
    private val englishConverter = ValueConverters.ENGLISH_INTEGER

    /**
     * Transform a number to english words. Eg: 123 -> one hundred twenty-three
     *
     * @param number The number to transform
     * @return The transformed number into text
     */
    override fun asWords(number: Int): String {
        return englishConverter.asWords(number)
    }
}