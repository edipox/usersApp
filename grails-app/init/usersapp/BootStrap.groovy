package usersapp

class BootStrap {

    def init = { servletContext ->
        RoleService roleService = new RoleService()

        Role adminRole = roleService.create('Admin')
        Role userRole = roleService.create('user')

        UserService userService = new UserService()
        userService.create('Edipo Admin', 'edipo@admin.com', adminRole, 'password123')
        userService.create('Edipo User', 'edipo@user.com', userRole, 'password123')
    }

    def destroy = {
    }
}
