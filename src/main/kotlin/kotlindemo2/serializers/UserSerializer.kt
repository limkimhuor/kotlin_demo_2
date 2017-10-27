package kotlindemo2.serializers

import kotlindemo2.entities.User

class UserSerializer(user: User) {
    var id = user.id
    var username = user.username
}
