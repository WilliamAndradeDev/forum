package br.com.forum.application.topic.controller.v1

import br.com.forum.application.topic.controller.v1.dto.TopicCreateDTO
import br.com.forum.application.topic.controller.v1.dto.TopicCreateResponseDTO
import br.com.forum.application.topic.controller.v1.dto.TopicListDTO
import br.com.forum.application.topic.extension.toTopicCreateResponseDTO
import br.com.forum.application.topic.extension.toTopicListDTO
import br.com.forum.application.topic.service.TopicService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
class TopicController(
    private val topicService: TopicService
): TopicAPI {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun createTopic(
        topicCreateDTO: TopicCreateDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicCreateResponseDTO> {
        val topic = topicService.createTopic(topicCreateDTO)
        val uri = uriBuilder.path("/v1/topic/{id}").buildAndExpand(topic.id).toUri()
        return ResponseEntity.created(uri).body(topic.toTopicCreateResponseDTO())
    }

    override fun listTopic(
        pagination: Pageable
    ): Page<TopicListDTO> {
        logger.info("m=listTopics, stage=init")
        val topicListPages = topicService.listTopic(pagination).map { it.toTopicListDTO() }
        logger.info("m=listTopics, stage=end, result={topicListPagesSize: ${topicListPages.size}")
        return topicListPages
    }

}