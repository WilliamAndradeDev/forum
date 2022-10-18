package br.com.forum.infrastructure.repository.topic

import br.com.forum.domain.entities.Topic
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface TopicPostgresRepository: JpaRepository<Topic,UUID> {
}