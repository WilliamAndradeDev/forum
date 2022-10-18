package br.com.forum.application.post.service

import br.com.forum.domain.entities.Post

interface PostService {

    fun createPost(post: Post): Post

}