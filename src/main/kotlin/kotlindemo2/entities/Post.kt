package kotlindemo2.entities

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Post {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null

    var title: String? = null
    var content: String? = null
    @Column(name = "creator_id") var creatorId: Long? = null
    @Column(name = "created_at", columnDefinition = "DATETIME") val createdAt: Timestamp = Timestamp.valueOf(LocalDateTime.now())
    @Column(name = "updated_at", columnDefinition = "DATETIME") var updatedAt: Timestamp? = null
    internal constructor()
    constructor(title: String, content: String) {
        this.title = title
        this.content = content
    }
}
