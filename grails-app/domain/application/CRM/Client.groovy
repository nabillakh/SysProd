package application.CRM

import application.PP.*

class Client {

    String nom
    
    static hasMany = [projets : Kanban]
    
    static constraints = {
        projets nullable : true
    }
    
    
    static mappedBy = [projets : 'client']
}
