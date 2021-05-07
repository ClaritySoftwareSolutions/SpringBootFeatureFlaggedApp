package uk.co.claritysoftware.featureflaggedapp.config

import org.ff4j.FF4j
import org.ff4j.audit.repository.InMemoryEventRepository
import org.ff4j.property.store.InMemoryPropertyStore
import org.ff4j.store.InMemoryFeatureStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FF4jConfig {

	@Bean
	fun ff4j() : FF4j {

		val ff4j = FF4j()
		ff4j.featureStore = InMemoryFeatureStore()
		ff4j.propertiesStore = InMemoryPropertyStore()
		ff4j.eventRepository = InMemoryEventRepository()

		ff4j.audit(true)
		ff4j.autoCreate(true)


		return ff4j
	}

}