package br.com.forum.domain.entities

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne


@Entity(name = "post")
data class Post(
    @Id
    val id: UUID = UUID.randomUUID(),
    val content: String,
    @ManyToOne
    val topic: Topic,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)