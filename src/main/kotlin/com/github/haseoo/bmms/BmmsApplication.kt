package com.github.haseoo.bmms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BmmsApplication

fun main(args: Array<String>) {
	runApplication<BmmsApplication>(*args)
}
