package com.sonatype.numberconverter.service.impl

import com.sonatype.numberconverter.converter.NumberConverter
import com.sonatype.numberconverter.converter.impl.EnglishNumberConverter
import com.sonatype.numberconverter.service.NumberConverterService
import org.springframework.stereotype.Service

/**
 * Service in charge of converting numbers into text
 */
@Service
class NumberConverterServiceImpl: NumberConverterService {

    /**
     * Makes the required validations and execution of the number transformation
     *
     * @param number Converts a string number to its text equivalent
     * @return The transformed number
     */
    override fun convertNumber(number: String): String {
        return getConverter().asWords(number.toInt())
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