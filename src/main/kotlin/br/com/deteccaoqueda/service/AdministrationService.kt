package br.com.deteccaoqueda.service

import br.com.deteccaoqueda.converter.toOrientacaoHistory
import br.com.deteccaoqueda.converter.toQuedaHistory
import br.com.deteccaoqueda.domain.OrientacaoHistory
import br.com.deteccaoqueda.domain.QuedaHistory
import br.com.deteccaoqueda.model.DeteccaoQuedaMqtt
import br.com.deteccaoqueda.model.OrientacaoMqtt
import br.com.deteccaoqueda.model.QuedaResponse
import br.com.deteccaoqueda.repository.DeteccaoQuedaRepository
import br.com.deteccaoqueda.repository.OrientacaoRepository
import br.com.deteccaoqueda.service.mail.EmailSenderService
import br.com.deteccaoqueda.utils.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.temporal.Temporal

@Service
class AdministrationService(
    private val deteccaoQuedaRepository: DeteccaoQuedaRepository,
    private val emailSenderService: EmailSenderService,
    private val orientacaoRepository: OrientacaoRepository
) {
    @Transactional
    fun saveAndSendMail(deteccaoQuedaMqtt: DeteccaoQuedaMqtt){
        deteccaoQuedaRepository.save(deteccaoQuedaMqtt.toQuedaHistory())
        emailSenderService.sendEmail(subject = "xxxx", text = "Uma atividade foi reportada: "+deteccaoQuedaMqtt.descricao, targetEmail = "luizwurlitzer@gmail.com")
    }
    @Transactional
    fun saveOrientacao(orientacaoMqtt: OrientacaoMqtt){
       orientacaoRepository.save(orientacaoMqtt.toOrientacaoHistory())
    }

    @Transactional
    fun getLastQueda(): QuedaResponse {
        val deteccaoQueda = deteccaoQuedaRepository.findLastQueda()

        return QuedaResponse(
            atividade = deteccaoQueda!!.atividade,
            descricao = deteccaoQueda.descricao,
            datahora = deteccaoQueda.createdAt.toString()
        )
    }

    fun getAllQueda(): List<QuedaHistory> {

        return deteccaoQuedaRepository.findAll()
    }

    fun getPorMinuto(min: Int): List<QuedaHistory>? {
        return deteccaoQuedaRepository.findPorMinuto(min)
    }

    fun getAllOrientation(): List<OrientacaoHistory>?{
        return orientacaoRepository.findAllOrientacao()
    }

}