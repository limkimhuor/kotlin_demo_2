package kotlindemo2.controllers.auth

import kotlindemo2.model.UpdatePasswordReq
import kotlindemo2.repositories.UserRepository
import kotlindemo2.service.UserDetailsServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/update-password")
class UpdatePasswordController(userRepository: UserRepository, val userDetailsServiceImpl: UserDetailsServiceImpl) : AuthenticatedController(userRepository) {
    @PostMapping
    fun updatePassword(@RequestBody updatePasswordReq: UpdatePasswordReq): String {
        val currentUser = getCurrentUser()
        currentUser!!.password = updatePasswordReq.password
        userDetailsServiceImpl.save(currentUser)
        return "update success"
    }
}
