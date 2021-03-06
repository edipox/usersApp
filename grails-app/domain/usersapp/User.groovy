package usersapp

class User {

    String name
    String description
    String email
    Role role
    String encryptedPassword

    static constraints = {
        name maxSize: 255
        email maxSize: 255
        encryptedPassword maxSize: 255
        description maxSize: 255, nullable: true
    }
}
