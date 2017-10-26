package kotlindemo2.entities

import javax.persistence.*

@Entity
class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        @Column(unique = true)
        val email: String = "",

        @Column(unique = true)
        var username: String = "",

        var password: String = ""
)
