package br.com.deteccaoqueda.model

data class OrientacaoResponse(
    val device: String,
    val atividade: Int,
    val descricao: String
)

data class OrientacaoMqtt(
    val orientacaoId: Int,
    val orientacaoDescricao: String
)