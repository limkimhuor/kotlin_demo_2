package kotlindemo2.controllers

import kotlindemo2.entities.Post
import kotlindemo2.repositories.PostRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(private var postRepo: PostRepository) {
    @GetMapping("/all")
    fun getAllPost() : ResponseEntity<MutableList<Post>>? = ResponseEntity.ok(postRepo.findAll())

    @PostMapping("/create")
    fun createPost(@RequestBody post: Post): ResponseEntity<Post>? {
        postRepo.save(post)
        return ResponseEntity.ok(post)
    }

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: Long): ResponseEntity<Post>? {
        val post = postRepo.findOne(id)
        return post?.let { ResponseEntity.notFound().build<Post>() } ?: ResponseEntity.ok(post)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody new_post: Post) : ResponseEntity<Post>? {
        try {
            val post = postRepo.findOne(id)
            new_post.title?.let {
                post.title = new_post.title
            }
            new_post.content?.let {
                post.content = new_post.content
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
}