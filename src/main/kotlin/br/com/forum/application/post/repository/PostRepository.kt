package br.com.forum.application.post.repository

import br.com.forum.domain.entities.Post

interface PostRepository {

    fun createPost(post: Post): Post

}