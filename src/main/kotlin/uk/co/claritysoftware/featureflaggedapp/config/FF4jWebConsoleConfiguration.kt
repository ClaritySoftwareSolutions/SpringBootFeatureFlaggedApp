package uk.co.claritysoftware.featureflaggedapp.config

import org.ff4j.FF4j
import org.ff4j.web.FF4jDispatcherServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FF4jWebConsoleConfiguration : SpringBootServletInitializer() {

	@Bean
	fun ff4jServlet(ff4j: FF4j) : FF4jDispatcherServlet {
		val ff4jServlet = FF4jDispatcherServlet()
		ff4jServlet.ff4j = ff4j
		return ff4jServlet
	}

	@Bean
	fun registerFF4jServlet(ff4jServlet: FF4jDispatcherServlet) =
			ServletRegistrationBean(ff4jServlet, "/ff4j-web-console/*")
}