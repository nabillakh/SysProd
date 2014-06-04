package application.communication

import application.RH.*

class MailEffectif {
    
    Effectif recepteur
    Mail mail
    Date dateCreated= new Date()
    
    Boolean lu 
    Boolean archive 
    Boolean favoris
 
    static constraints = {
        lu nullable : true
        archive nullable : true
        favoris nullable : true
    }
    
   
    
}
