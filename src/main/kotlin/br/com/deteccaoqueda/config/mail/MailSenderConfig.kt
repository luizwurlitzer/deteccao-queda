package br.com.deteccaoqueda.config.mail

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.*

@Profile("manual")
@ConstructorBinding
class MailSenderProperties(
    val host: String,
    val port: Int,
    val username: String,
    val password: String,
    val protocol: String,
    val auth: Boolean,
    val starttlsEnable: Boolean,
    val debug: Boolean
)

@Profile("manual")
@Configuration
class MailSenderConfig(
    @Value("\${spring.mail.host}") val mailHost: String,
    @Value("\${spring.mail.port}") val mailPort: Int,
    @Value("\${spring.mail.username}") val mailUsername: String,
    @Value("\${spring.mail.password}") val mailPassword: String,
    @Value("\${spring.mail.protocol}") val mailProtocol: String,
    @Value("\${spring.mail.auth}") val mailAuth: Boolean,
    @Value("\${spring.mail.starttlsEnable}") val mailStarttlsEnable: Boolean,
    @Value("\${spring.mail.debug}") val mailDebug: Boolean,
) {
    @Bean
    fun javaMailSender(): JavaMailSender {
        val mailSender = JavaMailSenderImpl()
        mailSender.host = mailHost
        mailSender.port = mailPort
        mailSender.username = mailUsername
        mailSender.password = mailPassword

        configureJavaMailProperties(mailSender.javaMailProperties)
        return mailSender
    }

    private fun configureJavaMailProperties(properties: Properties) {
        properties["mail.transport.protocol"] = mailProtocol
        properties["mail.smtp.auth"] = mailAuth
        properties["mail.smtp.starttls.enable"] = mailStarttlsEnable
        properties["mail.debug"] = mailDebug
    }
}