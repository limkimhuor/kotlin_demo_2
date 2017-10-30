package kotlindemo2.entities

import javax.persistence.*

@Entity
class Post {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null

    var title: String? = null
    var content: String? = null
    var creator_id: Long? = null

    internal constructor()

    constructor(title: String, content: String) {
        this.title = title
        this.content = content
    }
}
