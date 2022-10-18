package br.com.forum.application.topic.service

import br.com.forum.application.topic.controller.v1.dto.TopicCreateDTO
import br.com.forum.domain.entities.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TopicService {

    fun createTopic(topicCreateDTO: TopicCreateDTO): Topic
    fun listTopic(pageable: Pageable): Page<Topic>
}