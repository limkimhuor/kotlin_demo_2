package kotlindemo2.repositories

import kotlindemo2.entities.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDateTime

interface PostRepository : JpaRepository<Post, Long> {
    fun findByTitle(title: String): Post?

    @Query("FROM Post p WHERE p.creatorId = :creator_id")
    fun findByCreatorId(@Param("creator_id") creatorId: Long?) : MutableList<Post>

    @Query("FROM Post p WHERE p.createdAt = :created_at")
    fun findByCreatedTime(@Param("created_at") createdAt: LocalDateTime) : MutableList<Post>
}
