package kotlindemo2.controllers.auth

import kotlindemo2.entities.User
import kotlindemo2.repositories.UserRepository
import org.springframework.security.core.context.SecurityContextHolder


open class AuthenticatedController(var userRepository: UserRepository) {

    fun getCurrentUser() : User? {
        val auth = SecurityContextHolder.getContext().authentication
        return userRepository.findByUsername(auth.name)
    }
}
