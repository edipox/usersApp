package usersapp

class UrlMappings {

    static mappings = {
        post "/v1/login"(controller:"login", action:"login")
    }
}
