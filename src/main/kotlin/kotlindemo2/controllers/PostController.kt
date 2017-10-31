package kotlindemo2.controllers

import kotlindemo2.entities.CustomUserDetail
import kotlindemo2.entities.Post
import kotlindemo2.repositories.PostRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(private var postRepo: PostRepository) {
    @GetMapping("/all")
    fun getAllPost() : ResponseEntity<MutableList<Post>>? {
        return ResponseEntity.ok(postRepo.findByCreatorId(authenticatedUserId()))
    }

    @PostMapping("/create")
    fun createPost(@RequestBody post: Post): ResponseEntity<Post>? {
        post.creatorId = authenticatedUserId()
        postRepo.save(post)
        return ResponseEntity.ok(post)
    }

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: Long): ResponseEntity<Post>? {
        val post = postRepo.findOne(id)
        return post?.let { ResponseEntity.notFound().build<Post>() } ?: ResponseEntity.ok(post)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody newPost: Post) : ResponseEntity<Post>? {
        try {
            val post = postRepo.findOne(id)
            newPost.title?.let {
                post.title = newPost.title
            }
            newPost.content?.let {
                post.content = newPost.content
            }
            postRepo.save(post)
            return ResponseEntity.ok(post)
        } catch (e: NullPointerException) {
            return ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): String {
        try {
            postRepo.delete(id)
            return "Deleted success post: $id"
        } catch (e: EmptyResultDataAccessException) {
            return "Delete fail"
        }
    }

    private fun authenticatedUserId(): Long? {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val userDetail: CustomUserDetail = authentication.principal as CustomUserDetail
        return userDetail.user!!.id
    }
}