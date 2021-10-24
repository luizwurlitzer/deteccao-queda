package br.com.deteccaoqueda.repository

import br.com.deteccaoqueda.domain.OrientacaoHistory
import br.com.deteccaoqueda.domain.QuedaHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface OrientacaoRepository: JpaRepository<OrientacaoHistory, UUID>{

    @Query("""select * from deteccao_queda.orientacao_history qh order by created_at desc""",nativeQuery = true)
    fun findAllOrientacao(): List<OrientacaoHistory>?


}


