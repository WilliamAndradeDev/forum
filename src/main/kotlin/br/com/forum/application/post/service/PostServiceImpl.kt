package br.com.forum.application.post.service

import br.com.forum.application.post.repository.PostRepository
import br.com.forum.domain.entities.Post
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    private val postRepository: PostRepository
): PostService {

    override fun createPost(post: Post): Post {
        return postRepository.createPost(post)
    }

}