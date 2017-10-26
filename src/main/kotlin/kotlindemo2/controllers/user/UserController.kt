package kotlindemo2.controllers.user

import kotlindemo2.repositories.UserRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(val userRepository: UserRepository) {
    fun findAll() = userRepository.findAll()
}
