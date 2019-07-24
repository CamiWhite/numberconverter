package com.sonatype.numberconverter.util

import java.util.*
import kotlin.math.ceil

/**
 * String utilities to work with strings
 */
object StringUtils {

    /**
     * Splits the string into chunks of size 3
     *
     * @param string The string to be divided
     * @return A stack with the chunks
     */
    fun splitInChunks(string: String): Deque<String> {
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