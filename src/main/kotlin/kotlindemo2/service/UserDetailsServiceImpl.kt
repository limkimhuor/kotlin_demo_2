package kotlindemo2.service

import kotlindemo2.entities.User
import kotlindemo2.repositories.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class UserDetailsServiceImpl(val userRepository: UserRepository) : UserDetailsService {
    @Transactional(readOnly = true)
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepository.findByUsername(username) ?: throw UsernameNotFoundException(username)
        return org.springframework.security.core.userdetails.User(user.username, user.password, emptyList())
    }

    val passwordEncoder: PasswordEncoder
        @Bean
        get() = BCryptPasswordEncoder()

    fun save(user: User) {
        user.password = passwordEncoder.encode(user.password)
        userRepository.save(user)
    }
}
