package uk.co.claritysoftware.featureflaggedapp

import org.assertj.core.api.Assertions.assertThat
import org.ff4j.FF4j
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@SpringBootTest
@AutoConfigureMockMvc
class FeatureFlaggedAppApplicationTests {

	@Autowired
	private lateinit var mvc : MockMvc

	@Autowired
	private lateinit var ff4j : FF4j

	@Nested
	inner class TestControllersThatUseFFj4Api {

		@Test
		@DirtiesContext
		fun featureFlagGetsCreatedAutomatically() {
			// Given
			// feature flag does not exist to start with
			assertThat(ff4j.exist("englishLanguage")).isFalse()

			// When
			val result = mvc.perform(get("/helloWorld"))
					.andReturn()

			// Then
			assertThat(result.response.contentAsString).isEqualTo("Bonjour le monde!")
			// feature flag now exists
			assertThat(ff4j.exist("englishLanguage")).isTrue()
			// and is false
			assertThat(ff4j.check("englishLanguage")).isFalse()
		}

		@Test
		@DirtiesContext
		fun enableFeatureFlag() {
			// Given
			// feature flag does not exist to start with
			assertThat(ff4j.exist("englishLanguage")).isFalse()

			// When
			ff4j.enable("englishLanguage")
			val result = mvc.perform(get("/helloWorld"))
					.andReturn()

			// Then
			assertThat(result.response.contentAsString).isEqualTo("Hello World!")
			// feature flag now exists
			assertThat(ff4j.exist("englishLanguage")).isTrue()
			// and is false
			assertThat(ff4j.check("englishLanguage")).isTrue()
		}

		@Test
		@DirtiesContext
		fun toggleFeatureFlagOnRunningApp() {
			// Given
			// hit the endpoint and assert the current response as determined by the feature flag
			var result = mvc.perform(get("/helloWorld"))
					.andReturn()
			assertThat(result.response.contentAsString).isEqualTo("Bonjour le monde!")

			// When
			ff4j.enable("englishLanguage")
			result = mvc.perform(get("/helloWorld"))
					.andReturn()

			// Then
			assertThat(result.response.contentAsString).isEqualTo("Hello World!")
		}
	}


	@Nested
	inner class TestControllersThatUseServiceUsingFFj4Flipping {

		@Test
		@DirtiesContext
		fun featureFlagGetsCreatedAutomatically() {
			// Given
			// feature flag does not exist to start with
			assertThat(ff4j.exist("englishLanguage")).isFalse()

			// When
			val result = mvc.perform(get("/helloWorldFromService"))
					.andReturn()

			// Then
			assertThat(result.response.contentAsString).isEqualTo("Bonjour le monde!")
			// feature flag now exists
			assertThat(ff4j.exist("englishLanguage")).isTrue()
			// and is false
			assertThat(ff4j.check("englishLanguage")).isFalse()
		}

		@Test
		@DirtiesContext
		fun enableFeatureFlag() {
			// Given
			// feature flag does not exist to start with
			assertThat(ff4j.exist("englishLanguage")).isFalse()

			// When
			ff4j.enable("englishLanguage")
			val result = mvc.perform(get("/helloWorldFromService"))
					.andReturn()

			// Then
			assertThat(result.response.contentAsString).isEqualTo("Hello World!")
			// feature flag now exists
			assertThat(ff4j.exist("englishLanguage")).isTrue()
			// and is false
			assertThat(ff4j.check("englishLanguage")).isTrue()
		}

		@Test
		@DirtiesContext
		fun toggleFeatureFlagOnRunningApp() {
			// Given
			// hit the endpoint and assert the current response as determined by the feature flag
			var result = mvc.perform(get("/helloWorldFromService"))
					.andReturn()
			assertThat(result.response.contentAsString).isEqualTo("Bonjour le monde!")

			// When
			ff4j.enable("englishLanguage")
			result = mvc.perform(get("/helloWorldFromService"))
					.andReturn()

			// Then
			assertThat(result.response.contentAsString).isEqualTo("Hello World!")
		}
	}

}
