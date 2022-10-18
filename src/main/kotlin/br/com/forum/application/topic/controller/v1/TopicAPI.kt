package br.com.forum.application.topic.controller.v1

import br.com.forum.application.topic.controller.v1.dto.TopicCreateDTO
import br.com.forum.application.topic.controller.v1.dto.TopicCreateResponseDTO
import br.com.forum.application.topic.controller.v1.dto.TopicListDTO
import io.swagger.v3.oas.annotations.tags.Tag
import javax.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.util.UriComponentsBuilder

@Tag(name = "Topics", description = "Endpoint focused on topic related operations")
@RequestMapping("/v1/topic")
interface TopicAPI {

    @PostMapping
    fun createTopic(
        @RequestBody @Valid topicCreateDTO: TopicCreateDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicCreateResponseDTO>

    @GetMapping
    fun listTopic(
        @PageableDefault(sort = ["createdAt"], direction = Sort.Direction.ASC) pagination: Pageable
    ): Page<TopicListDTO>

}
