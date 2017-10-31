package kotlindemo2.controllers

import kotlindemo2.entities.UserProfile
import kotlindemo2.repositories.UserProfileRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/profiles")
class UserUserProfileController(private val profileRepo: UserProfileRepository) {
    @GetMapping("/all")
    fun getAllUserProfile() : ResponseEntity<MutableList<UserProfile>>? = ResponseEntity.ok(profileRepo.findAll())

    @PostMapping("/create")
    fun createUserProfile(@RequestBody profile: UserProfile): ResponseEntity<UserProfile>? {
        profileRepo.save(profile)
        return ResponseEntity.ok(profile)
    }

    @GetMapping("/{id}")
    fun getUserProfile(@PathVariable id: Long): ResponseEntity<UserProfile>? {
        val profile = profileRepo.findOne(id)
        return profile?.let { ResponseEntity.notFound().build<UserProfile>() } ?: ResponseEntity.ok(profile)
    }

    @PutMapping("/{id}")
    fun updateUserProfile(@PathVariable id: Long, @RequestBody newUserProfile: UserProfile) : ResponseEntity<UserProfile>? {
        try {
            val userProfile = profileRepo.findOne(id)
            newUserProfile.fullName?.let {
                userProfile.fullName = newUserProfile.fullName
            }
            newUserProfile.age?.let {
                userProfile.age = newUserProfile.age
            }
            newUserProfile.joinDate?.let {
                userProfile.joinDate = newUserProfile.joinDate
            }
            profileRepo.save(userProfile)
            return ResponseEntity.ok(userProfile)
        } catch (e: NullPointerException) {
            return ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUserProfile(@PathVariable id: Long): String {
        try {
            profileRepo.delete(id)
            return "Deleted success profile: $id"
        } catch (e: EmptyResultDataAccessException) {
            return "Delete fail"
        }
    }
}
