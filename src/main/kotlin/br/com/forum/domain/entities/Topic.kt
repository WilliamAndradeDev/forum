package br.com.forum.domain.entities

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "topic")
data class Topic(
    @Id
    val id: UUID = UUID.randomUUID(),
    var title: String,
    @OneToMany(mappedBy = "topic")
    val posts: List<Post> = emptyList(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)