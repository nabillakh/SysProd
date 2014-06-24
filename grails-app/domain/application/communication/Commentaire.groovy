package application.communication

import application.RH.Effectif
class Commentaire {

    Effectif auteur
    Date date
    String texte
    
    static belongsTo = [message : Message]
    
    
    static constraints = {
    }
}
