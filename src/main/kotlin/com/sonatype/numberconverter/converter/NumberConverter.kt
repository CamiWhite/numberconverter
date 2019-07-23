package com.sonatype.numberconverter.converter

/**
 * Interface proving the required behaviours to transform a number to words
 */
interface NumberConverter {

    /**
     * Transform a number to words
     *
     * @param number The number to transform
     * @return The transformed number into text
     */
    fun asWords(number: Int): String
}
