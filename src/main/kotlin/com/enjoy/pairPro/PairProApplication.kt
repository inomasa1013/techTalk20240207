package com.enjoy.pairPro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PairProApplication

fun main(args: Array<String>) {
	runApplication<PairProApplication>(*args)
	println("http://localhost:8080/api/v1/masas")
}
