package br.com.forum.application.topic.controller.v1.dto

import java.util.UUID

data class TopicCreateResponseDTO(
    val id: UUID,
    val title: String,
    val content: String
)
