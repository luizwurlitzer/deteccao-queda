package br.com.deteccaoqueda.converter

import br.com.deteccaoqueda.domain.QuedaHistory
import br.com.deteccaoqueda.model.DeteccaoQuedaMqtt

fun DeteccaoQuedaMqtt.toQuedaHistory(): QuedaHistory {
    return QuedaHistory(
        descricao = this.descricao,
        atividade = this.atividade,
    )
}