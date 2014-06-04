package application.PP


import application.communication.*
import application.RH.*

class Imputation {
    
    OF of
    EventEffectif eventEffectif
    Effectif effectif
    Float tempsImpute
    
    Boolean realise

    static constraints = {
        tempsImpute nullable : true
    }
    
}
