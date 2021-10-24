package br.com.deteccaoqueda.handlers

import br.com.deteccaoqueda.model.DeteccaoQuedaMqtt
import br.com.deteccaoqueda.service.AdministrationService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.slf4j.LoggerFactory
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHandler
import org.springframework.messaging.MessagingException
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class QuedaMessageHandler(
    private val administrationService: AdministrationService
    ) : MessageHandler {

    companion object {
        val mapper = jacksonObjectMapper()
        @JvmStatic
        private val logger = LoggerFactory.getLogger(QuedaMessageHandler::class.java)
    }

    @Throws(MessagingException::class)
    override fun handleMessage(message: Message<*>) {
        try {
            logger.info("Received Message: " + message.payload.toString())
            val content = mapper.readValue<DeteccaoQuedaMqtt>(message.payload.toString())
            administrationService.saveAndSendMail(content)
            logger.info(content.descricao)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}