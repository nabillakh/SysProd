package application.PP


import application.RH.*

class OFEffectif {

    Effectif effectif
    
    Float pourcentageTache
    
    static belongsTo = [of : OF]
    
    static constraints = {
        pourcentageTache nullable : true
    }
    
    static mappedBy = [effectif : 'mesOF', of : 'affectes']
    
}
