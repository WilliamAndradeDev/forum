package br.com.forum.application.topic.controller.v1.dto

import java.time.LocalDateTime
import java.util.UUID

data class TopicListDTO(
    val id: UUID,
    val title: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)
