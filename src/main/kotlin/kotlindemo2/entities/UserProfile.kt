package kotlindemo2.entities

import java.util.*
import javax.persistence.*
import javax.persistence.JoinColumn
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue



@Entity
class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    var fullName: String? = null
    var age: Int? = null
    var joinDate: Date? = null

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "userId")
    var user: User? = null

    internal constructor()
    constructor(fullName: String, age: Int, joinDate: Date, user: User) {
        this.fullName = fullName
        this.age = age
        this.joinDate = joinDate
        this.user = user
    }
}
