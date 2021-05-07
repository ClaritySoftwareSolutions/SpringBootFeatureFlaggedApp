package uk.co.claritysoftware.featureflaggedapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FeatureflaggedappApplication

fun main(args: Array<String>) {
	runApplication<FeatureflaggedappApplication>(*args)
}
