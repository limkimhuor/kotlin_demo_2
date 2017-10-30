package kotlindemo2.repositories

import kotlindemo2.entities.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findByTitle(title: String): Post?
}
