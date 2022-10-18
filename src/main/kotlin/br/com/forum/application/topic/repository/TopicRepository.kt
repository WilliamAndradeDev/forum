package br.com.forum.application.topic.repository

import br.com.forum.domain.entities.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TopicRepository {

    fun createTopic(topic: Topic): Topic
    fun listTopic(pageable: Pageable): Page<Topic>

}