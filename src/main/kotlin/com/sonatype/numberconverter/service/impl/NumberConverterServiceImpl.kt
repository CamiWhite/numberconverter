package com.sonatype.numberconverter.service.impl

import com.sonatype.numberconverter.converter.NumberConverter
import com.sonatype.numberconverter.converter.impl.EnglishNumberConverter
import com.sonatype.numberconverter.service.NumberConverterService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * Service in charge of converting numbers into text, since it doesn't have state it may be treated as a singleton
 */
@Service
object NumberConverterServiceImpl: NumberConverterService {

    private val logger = LoggerFactory.getLogger(NumberConverterServiceImpl::class.java)

    /**
     * Makes the required validations and execution of the number transformation
     *
     * @param number Converts a string number to its text equivalent
     * @return The transformed number
     */
    override fun convertNumber(number: String): String {
        logger.debug("Number conversion started")
        val parsedNumber = number.toLongOrNull() ?: return "Input string is not a valid number"
        if (parsedNumber !in Int.MIN_VALUE..Int.MAX_VALUE) {
            return "Number should be between ${Int.MIN_VALUE} and ${Int.MAX_VALUE}"
        }

        logger.debug("Converting ${number}")
        return getConverter().asWords(parsedNumber.toInt())
    }

    /**
     * Retrieves the convert to be used, this allows to change the converter to any other desired language by changing
     * the return of this method
     *
     * @return A NumberConverter in charge to make the conversions
     */
    override fun getConverter(): NumberConverter {
        return EnglishNumberConverter
    }
}