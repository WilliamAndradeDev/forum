package br.com.forum.application.topic.controller.v1.dto

import javax.validation.constraints.Size
import org.jetbrains.annotations.NotNull

data class TopicCreateDTO(
    @field:NotNull @field:Size(min = 5, max = 120)
    val title: String,
    @field:NotNull @field:Size(min = 5, max = 250)
    val content: String
)