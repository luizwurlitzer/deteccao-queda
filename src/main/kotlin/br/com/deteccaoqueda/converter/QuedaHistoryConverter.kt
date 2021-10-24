package br.com.deteccaoqueda.converter

import br.com.deteccaoqueda.domain.OrientacaoHistory
import br.com.deteccaoqueda.domain.QuedaHistory
import br.com.deteccaoqueda.model.DeteccaoQuedaMqtt
import br.com.deteccaoqueda.model.OrientacaoMqtt

fun OrientacaoMqtt.toOrientacaoHistory(): OrientacaoHistory {
    return OrientacaoHistory(
        orientacaoDescricao = this.orientacaoDescricao,
        orientacaoId = this.orientacaoId

    )
}