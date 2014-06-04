package application.communication

import application.RH.*

class Mail {

    String objet
    String message
    Effectif author
    static hasMany = [recepteur:MailEffectif] 
    Date dateCreated = new Date()
    Conversation conversation
    

    static constraints = {
        recepteur nullable:true
        objet nullable:true
        conversation nullable : true
    }
    
    def beforeInsert = {
    }
    
    transient afterInsert = {
        
    }
    

  
}
