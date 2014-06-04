package application.communication


import application.RH.*
import application.PP.*
import application.communication.*


class Message {
    
    Effectif auteur
    Kanban kanban
    
    static hasMany = [recepteurs : MessageEffectif]
    
    Date date = new Date()
    
    String message
    
    static constraints = {
        recepteurs nullable : true
        kanban nullable : true
    }
    
    
    static mappedBy = [recepteurs : 'message']
}
