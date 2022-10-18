package br.com.forum.application.topic.service

import br.com.forum.application.post.service.PostService
import br.com.forum.application.topic.controller.v1.dto.TopicCreateDTO
import br.com.forum.application.topic.extension.toPost
import br.com.forum.application.topic.extension.toTopic
import br.com.forum.application.topic.repository.TopicRepository
import br.com.forum.domain.entities.Topic
import javax.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import toTopic

@Service
class TopicServiceImpl(
    private val topicRepository: TopicRepository,
    private val postService: PostService,
) : TopicService {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Transactional
    override fun createTopic(topicCreateDTO: TopicCreateDTO): Topic {
        logger.info("m=createTopic, stage=init, params={topicCreateDTO: $topicCreateDTO}")
        val topic = topicRepository.createTopic(topicCreateDTO.toTopic())
        return postService.createPost(topicCreateDTO.toPost(topic)).toTopic().also {
            logger.info("m=createTopic, stage=end, params={topic: $it}")
        }
    }

    override fun listTopic(pageable: Pageable): Page<Topic> {
        logger.info("m=listTopic, stage=init")
        return topicRepository.listTopic(pageable).also {
            logger.info("m=listTopic, stage=end, result={topicPagesSize: ${it.size}}")
        }
    }


}