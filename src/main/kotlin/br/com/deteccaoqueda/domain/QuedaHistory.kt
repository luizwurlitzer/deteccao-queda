package br.com.deteccaoqueda.domain

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
open class QuedaHistory (
    @Id
    open var id: UUID = UUID.randomUUID(),
    open val atividade: Int,
    open val descricao: String
): BaseEntity()