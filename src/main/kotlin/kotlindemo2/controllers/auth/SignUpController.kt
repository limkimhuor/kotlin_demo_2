package kotlindemo2.controllers.auth

import kotlindemo2.entities.User
import kotlindemo2.service.UserDetailsServiceImpl
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign-up")
class SignUpController(val userDetailsServiceImpl: UserDetailsServiceImpl) {

    @PostMapping
    fun signUp(@RequestBody user: User): String {
        userDetailsServiceImpl.save(user)
        return "create success"
    }
}
