package com.sonatype.numberconverter

import com.sonatype.numberconverter.service.NumberConverterService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AppApplication: CommandLineRunner {

    private val logger = LoggerFactory.getLogger(AppApplication::class.java)

    @Autowired
    lateinit var numberInterpreter: NumberConverterService

    override fun run(vararg args: String?) {
        logger.debug("Starting number conversion")
        for (i in 0 until args.size) {
            logger.debug("Converting value: ${args[i]}")
            println(numberInterpreter.convertNumber(args[i]!!))
        }
        logger.debug("Number processing finished")
    }
}

fun main(args: Array<String>) {
    runApplication<AppApplication>(*args)
}