package br.com.forum.application.topic.extension

import br.com.forum.application.topic.controller.v1.dto.TopicCreateResponseDTO
import br.com.forum.application.topic.controller.v1.dto.TopicListDTO
import br.com.forum.domain.entities.Topic

fun Topic.toTopicCreateResponseDTO(): TopicCreateResponseDTO =
    TopicCreateResponseDTO(
        this.id,
        this.title,
        this.posts.first().content
    )

fun Topic.toTopicListDTO(): TopicListDTO =
    TopicListDTO(
        this.id,
        this.title,
        this.createdAt,
        this.updatedAt
    )