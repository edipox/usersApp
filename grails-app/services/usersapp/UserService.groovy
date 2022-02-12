package usersapp

import grails.gorm.transactions.Transactional

@Transactional
class UserService {
    def create(String username, String email, Role role, String password) {
        new User(
            name: username,
            email: email,
            role: role,
            encryptedPassword: encryptPassword(password)
        ).save()
    }

    // TODO: handle this via plugin
    def encryptPassword(String password) {
        // fake encryption
        password.bytes.encodeBase64().toString()
    }

    // TODO: handle this via plugin
    def validateLogin(String email, String password) {
        User user = byEmail(email)

        if (user == null) { return false }

        encryptPassword(password) == user.encryptedPassword
    }

    def byEmail(String email) { User.findByEmail(email) }
}
