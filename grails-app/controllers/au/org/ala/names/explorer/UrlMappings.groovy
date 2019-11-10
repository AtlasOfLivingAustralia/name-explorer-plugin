package au.org.ala.names.explorer

class UrlMappings {

    static mappings = {
        "/nameExplorer" {
            controller = "nameExplorer"
            action = "index"
        }
        "/"(redirect: "/nameExplorer")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
