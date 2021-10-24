package br.com.deteccaoqueda

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class DeteccaoQuedaServiceApplication

fun main(args: Array<String>) {
	runApplication<DeteccaoQuedaServiceApplication>(*args)
}
/*
@Bean
fun corsConfigurer(): WebMvcConfigurer? {
	return object : WebMvcConfigurer {
		override fun addCorsMappings(registry: CorsRegistry) {
			registry.addMapping("/v1/adm/queda").allowedOrigins("*")
		}
	}
	}
	*/

