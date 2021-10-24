package br.com.deteccaoqueda.repository

import br.com.deteccaoqueda.domain.QuedaHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface DeteccaoQuedaRepository: JpaRepository<QuedaHistory, UUID>{

    //fun findTopByOrderByCreatedAt(): QuedaHistory?
    @Query("""select qh.* from deteccao_queda.queda_history qh order by created_at desc limit 1""",nativeQuery = true)
    fun findLastQueda(): QuedaHistory?
//fun findFirstByOrderByCreatedAtAsc(): QuedaHistory?
    @Query("""SELECT qh.*, AGE(qh.created_at, NOW()) FROM deteccao_queda.queda_history qh where qh.created_at >= NOW() - (interval '1 minutes')* ?1 order by created_at desc""",nativeQuery = true)
    fun findPorMinuto(minuto: Int): List<QuedaHistory>?

    @Query("""select * from "deteccao-queda".deteccao_queda.queda_history qh""",nativeQuery = true)
    fun findAllQuedas(): List<QuedaHistory>?


}
