package kotlindemo2.entities

import javax.persistence.*

@Entity
open class User(
        @Column(unique = true)
        var username: String = "",

        var password: String = ""
) {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = (arrayOf(JoinColumn(name = "user_id"))), inverseJoinColumns = (arrayOf(JoinColumn(name = "role_id"))))
    lateinit var roles: Set<Role>
}
