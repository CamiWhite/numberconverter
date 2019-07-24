package com.sonatype.numberconverter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
open class AppApplication

fun main(args: Array<String>) {
    System.setProperty("org.jline.terminal.dumb", "true")
    runApplication<AppApplication>(*args)
}