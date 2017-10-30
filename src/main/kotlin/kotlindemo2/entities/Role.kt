package kotlindemo2.entities

import javax.persistence.*

@Entity
@Table(name = "roles")
class Role(id: Int, role_type: RoleType) {
    enum class RoleType { ADMIN, NORMAL}

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    var id: Int = id

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    var roleType = role_type
}