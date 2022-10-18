package br.com.forum.infrastructure.repository.post

import br.com.forum.domain.entities.Post
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface PostPostgresRepository: JpaRepository<Post,UUID> {
}