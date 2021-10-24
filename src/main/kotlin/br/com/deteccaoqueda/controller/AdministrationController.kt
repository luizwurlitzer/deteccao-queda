package br.com.deteccaoqueda.controller

import br.com.deteccaoqueda.domain.OrientacaoHistory
import br.com.deteccaoqueda.domain.QuedaHistory
import br.com.deteccaoqueda.model.OrientacaoResponse
import br.com.deteccaoqueda.model.QuedaResponse
import br.com.deteccaoqueda.service.AdministrationService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(AdministrationController.URL)
class AdministrationController(
    private val administrationService: AdministrationService
) {

    companion object {
        @JvmStatic
        private val logger = LoggerFactory.getLogger(AdministrationController::class.java)
        const val URL = "/v1/adm"
    }

    @GetMapping("/queda")
    @ResponseStatus(HttpStatus.OK)
    fun getLastQueda(): QuedaResponse {
        logger.info("Obtendo ultima queda registrada")
        return administrationService.getLastQueda()
    }

    @GetMapping("/queda/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllQueda(): List<QuedaHistory> {
        logger.info("Obtendo todas as quedas")
        return administrationService.getAllQueda()
    }

    @GetMapping("/queda/min/{min}")
    @ResponseStatus(HttpStatus.OK)
    fun getPorMinuto(@PathVariable min: Int): List<QuedaHistory>? {
        logger.info("Obtendo as quedas por minuto")
        return administrationService.getPorMinuto(min)
    }

    @GetMapping("/orientacao/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllOrientation(): List<OrientacaoHistory>? {
        logger.info("Obtendo o historico de orientacao")
        return administrationService.getAllOrientation()
    }

    @GetMapping("/orientacao/")
    @ResponseStatus(HttpStatus.OK)
    fun getLastOrientation(): List<OrientacaoHistory>? {
        logger.info("Obtendo ultima orientacao")
        return administrationService.getAllOrientation()
    }
}

