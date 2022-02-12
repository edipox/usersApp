package usersapp


import grails.rest.*
import grails.converters.*

class LoginController {
	static responseFormats = ['json']

    static allowedMethods = [login: 'POST']

   def login(){
        String email = request.JSON.email
        String password = request.JSON.password

        UserService userService = new UserService()

        if (userService.validateLogin(email, password)) {
            User user = userService.byEmail(email)
            def map = [user: user]
            render(view: "/login/login", model: map, contentType:"application/json")
        } else {
            render status:401
        }
    }
}
