package application.RH

import groovy.transform.ToString


@ToString(includes= 'nom')
class Competence {
    
    String nom
    
    static hasMany = [effectifs : Effectif]
    
    static constraints = {
    }
}
