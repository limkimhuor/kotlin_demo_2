package kotlindemo2.entities

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.ArrayList
import java.util.stream.Collectors


class CustomUserDetail : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return user!!.roles
                .stream()
                .map{SimpleGrantedAuthority("ROLE_" + it.roleType)}
                .collect(Collectors.toList())
    }


    var user: User? = null

    constructor(user: User) {
        this.user = user
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return user!!.username
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return user!!.password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}