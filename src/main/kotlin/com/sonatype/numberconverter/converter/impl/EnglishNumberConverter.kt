package com.sonatype.numberconverter.converter.impl

import com.sonatype.numberconverter.converter.NumberConverter
import java.util.*
import kotlin.math.ceil

/**
 * Singleton english converter to convert numbers to its text equivalent in english
 */
object EnglishNumberConverter: NumberConverter {

    private val numbers = mapOf(
        0 to "",
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
        10 to "ten",
        11 to "eleven",
        12 to "twelve",
        13 to "thirteen",
        14 to "fourteen",
        15 to "fifteen",
        16 to "sixteen",
        17 to "seventeen",
        18 to "eighteen",
        19 to "nineteen",
        20 to "twenty",
        30 to "thirty",
        40 to "forty",
        50 to "fifty",
        60 to "sixty",
        70 to "seventy",
        80 to "eighty",
        90 to "ninety"
    )

    private val thousands = listOf(
        "billion", "million", "thousand"
    )

    /**
     * Transform a number to english words by diving the number into chunks of 3 and transforming each chunk into its
     * english equivalent, then joins the result with respective thousands
     *
     * @param number The number to transform
     * @return The transformed number into text
     */
    override fun asWords(number: Int): String {
        if (number == 0) {
            return "zero"
        }
        val numberAsString = number.toString()
        val chunkedNumbers = splitInChunks(numberAsString)
        val chunksTotalSize = chunkedNumbers.size
        val result = StringJoiner(" ")

        for (index in 0 until chunkedNumbers.size) {
            val chunk = chunkedNumbers.pop()
            result.add(hundredsToString(chunk.toInt()))

            if (index < chunksTotalSize - 1) {
                result.add(thousands[thousands.size - (chunksTotalSize - (index + 1))])
            }
        }

        return result.toString()
    }

    /**
     * Transform numbers of 3 digits to its english equivalent.
     * Eg: 324 -> three hundred twenty four
     * Eg: 912 -> nine hundred twelve
     *
     * @param number The number to transform
     * @return The string equivalent
     */
    private fun hundredsToString(number: Int): String {
        val resultBuilder = StringJoiner(" ")
        var mutableNumber: Int = number

        val hundred = mutableNumber / 100
        if (hundred > 0) {
            resultBuilder.add("${numbers[hundred]}")
            resultBuilder.add("hundred")
        }
        mutableNumber %= 100
        if (mutableNumber < 20) {
            resultBuilder.add("${numbers[mutableNumber]}")
        } else {
            val tens = mutableNumber / 10
            resultBuilder.add("${numbers[tens * 10]}")
            resultBuilder.add("${numbers[mutableNumber % 10]}")
        }
        return resultBuilder.toString()
    }

    /**
     * Splits the string into chunks of size 3
     *
     * @param string The string to be divided
     * @return A stack with the chunks
     */
    private fun splitInChunks(string: String): Deque<String> {
        val chunks = ArrayDeque<String>()

        if(string.length < 3) {
            chunks.push(string)
            return chunks
        }

        val numberOfChunks = ceil(string.length / 3.0).toInt()
        var min = string.length - 3
        var max = string.length

        for (i in 0 until numberOfChunks) {
            chunks.push(string.substring(min, max))
            max = min
            min = if(min < 3) 0 else min - 3
        }

        return chunks
    }
}