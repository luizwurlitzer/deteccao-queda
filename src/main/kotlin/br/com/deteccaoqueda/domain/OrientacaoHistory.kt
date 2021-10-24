package br.com.deteccaoqueda.domain

import javax.persistence.Id
import java.util.UUID
import javax.persistence.Entity

@Entity
open class OrientacaoHistory(
    @Id
    open var id: UUID = UUID.randomUUID(),
    open val orientacaoId: Int,
    open val orientacaoDescricao: String

    ): BaseEntity()
