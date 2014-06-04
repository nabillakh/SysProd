class UrlMappings {

	static mappings = {
            "/list"(controller: "event", action: "list")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
