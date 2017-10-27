package kotlindemo2.controllers.user

import kotlindemo2.controllers.auth.AuthenticatedController
import kotlindemo2.repositories.UserRepository
import kotlindemo2.serializers.UserSerializer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/api/v1")
class UserController(userRepository: UserRepository) : AuthenticatedController(userRepository) {

    @GetMapping("/users")
    fun getAllUser() = userRepository.findAll()

    @GetMapping("/user")
    fun currentU() : ResponseEntity<UserSerializer>? {

        val user = getCurrentUser()
        return ResponseEntity(UserSerializer(user!!), HttpStatus.OK)
    }
}
