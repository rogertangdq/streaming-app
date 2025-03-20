package org.cyberelay.streaming.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StreamingAppApplication

fun main(args: Array<String>) {
	runApplication<StreamingAppApplication>(*args)
}
