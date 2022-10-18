import br.com.forum.domain.entities.Post
import br.com.forum.domain.entities.Topic

fun Post.toTopic(): Topic =
    this.topic.copy(posts = listOf(this))