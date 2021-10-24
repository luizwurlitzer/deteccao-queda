package br.com.deteccaoqueda.domain;

import java.time.Instant
import javax.persistence.MappedSuperclass;
import javax.persistence.PreRemove

@MappedSuperclass
open class BaseEntity(

        open var createdAt: Instant = Instant.now(),
        open var updatedAt: Instant = Instant.now(),
        open var deleted: Boolean = false

) {
        @PreRemove
        private fun beforeRemove() {
                this.deleted = true;
        }
}
