package kotlindemo2.repositories

import kotlindemo2.entities.UserProfile
import org.springframework.data.jpa.repository.JpaRepository

interface UserProfileRepository : JpaRepository<UserProfile, Long> {
}
