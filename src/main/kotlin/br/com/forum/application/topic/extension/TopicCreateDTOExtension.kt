package br.com.forum.application.topic.extension

import br.com.forum.application.topic.controller.v1.dto.TopicCreateDTO
import br.com.forum.domain.entities.Post
import br.com.forum.domain.entities.Topic

fun TopicCreateDTO.toTopic(): Topic =
    Topic(
        title = this.title
    )

fun TopicCreateDTO.toPost(topic: Topic): Post =
    Post(
        content = this.content,
        topic = topic
    )