package com.sonatype.numberconverter.shell

import com.sonatype.numberconverter.service.NumberConverterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class NumberConverterCommands {

    @Autowired
    lateinit var numberConverter: NumberConverterService

    @ShellMethod("Converts a number to its text equivalent")
    fun convert(number: String): String {
        return numberConverter.convertNumber(number)
    }
}