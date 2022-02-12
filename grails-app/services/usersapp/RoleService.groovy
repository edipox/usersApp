package usersapp

import grails.gorm.transactions.Transactional

@Transactional
class RoleService {
    def create(String name) {
        new Role(name: name).save()
    }
}
