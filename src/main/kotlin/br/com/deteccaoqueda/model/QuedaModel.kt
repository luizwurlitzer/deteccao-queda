package br.com.deteccaoqueda.model

import java.util.*

data class QuedaResponse(
    val atividade: Int,
    val descricao: String,
    val datahora: String
)

data class DeteccaoQuedaMqtt(
    val device: String,
    val atividade: Int,
    val descricao: String
)

