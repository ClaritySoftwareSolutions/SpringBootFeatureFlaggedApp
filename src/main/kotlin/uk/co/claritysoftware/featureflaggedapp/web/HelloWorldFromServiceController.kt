package uk.co.claritysoftware.featureflaggedapp.web

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.claritysoftware.featureflaggedapp.service.GreetingService

@RestController
class HelloWorldFromServiceController(val greetingService: GreetingService) {

	@RequestMapping("/helloWorldFromService")
	fun helloWorld() = greetingService.greet()

}