package uk.co.claritysoftware.featureflaggedapp.web

import org.ff4j.FF4j
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(val ff4j: FF4j) {

	@RequestMapping("/helloWorld")
	fun helloWorld() : String {
		if (ff4j.check("englishLanguage")) {
			return "Hello World!"
		} else {
			return "Bonjour le monde!"
		}
	}
}