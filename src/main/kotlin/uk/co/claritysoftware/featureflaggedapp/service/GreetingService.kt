package uk.co.claritysoftware.featureflaggedapp.service

import org.ff4j.aop.Flip
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Flip(name="englishLanguage", alterBean = "englishGreetingService")
interface GreetingService {

	fun greet() : String
}

@Service("englishGreetingService")
class EnglishGreetingService :  GreetingService {

	override fun greet() = "Hello World!"
}

@Service("frenchGreetingService")
@Primary
class FrenchGreetingService :  GreetingService {

	override fun greet() = "Bonjour le monde!"
}