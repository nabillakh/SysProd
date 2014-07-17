package application.PP


import application.RH.*

class OFEffectif {

    Effectif effectif
    
    Float pourcentageTache
    Competence competence 
    
    static belongsTo = [of : OF]
    
    static constraints = {
        pourcentageTache nullable : true
        competence nullable : true
    }
    
    static mappedBy = [effectif : 'mesOF', of : 'affectes']
    
}
