package application.communication

import application.RH.Effectif

class Commentaire implements Comparable {

    
    static searchable = true    
    
    Effectif auteur
    Date date = new Date()
    String texte
    
    static belongsTo = [message : Message]
    
    
    static constraints = {
    }
    
    
    int compareTo(obj) {
       (obj.date).compareTo(date)
   }
}
