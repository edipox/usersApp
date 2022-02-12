package usersapp

import grails.testing.mixin.integration.Integration
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.*

@Integration
class LoginControllerIntegrationSpec extends Specification implements ControllerUnitTest<LoginController> {

    @Autowired
    RoleService roleService
    UserService userService

    void setupData() {
        Role adminRole = roleService.create('TestAdmin')
        userService.create('Test', 'test@admin.com', adminRole, 'password123')
    }

     void 'login - with valid credentials'() {
        given:
        setupData()

        when: 'the credentials are valid'
        request.method = 'POST'
        controller.request.JSON = [email: 'test@admin.com', password: 'password123']
        controller.login()

        then: 'the status is successful'
        response.status == 200
     }

     void 'login - with invalid email'() {
        given:
        setupData()

        when: 'the email is invalid'
        request.method = 'POST'
        controller.request.JSON = [email: 'invalid@admin.com', password: 'password123']
        controller.login()

        then: 'the status is unauthorized'
        response.status == 401
     }


     void 'login - with invalid password'() {
        given:
        setupData()

        when: 'the email is invalid'
        request.method = 'POST'
        controller.request.JSON = [email: 'test@admin.com', password: 'invalid-password']
        controller.login()

        then: 'the status is unauthorized'
        response.status == 401
     }
}
