package br.com.forum.infrastructure.repository.post

import br.com.forum.application.post.repository.PostRepository
import br.com.forum.domain.entities.Post
import org.springframework.stereotype.Component

@Component
class PostJpaRepository(
    private val postPostgresRepository: PostPostgresRepository
): PostRepository {

    override fun createPost(post: Post): Post {
        return postPostgresRepository.save(post)
    }

}