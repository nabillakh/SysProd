package application.PP


import application.RH.*

class OFEffectif {

    Effectif effectif
    
    static belongsTo = [of : OF]
    
    static constraints = {
    }
    
    static mappedBy = [effectif : 'mesOF', of : 'affectes']
    
}
