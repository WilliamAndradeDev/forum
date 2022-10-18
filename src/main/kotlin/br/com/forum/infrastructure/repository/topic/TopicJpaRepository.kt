package br.com.forum.infrastructure.repository.topic

import br.com.forum.application.topic.repository.TopicRepository
import br.com.forum.domain.entities.Topic
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class TopicJpaRepository(
    private val topicPostgresRepository: TopicPostgresRepository
): TopicRepository {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun createTopic(topic: Topic): Topic {
        return topicPostgresRepository.save(topic)
    }

    override fun listTopic(pageable: Pageable): Page<Topic> {
        logger.info("m=listTopic, stage=init")
        return topicPostgresRepository.findAll(pageable).also {
            logger.info("m=listTopic, stage=end, result={topicPagesSize: ${it.size}}")
        }
    }
}