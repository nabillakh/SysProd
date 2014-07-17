package application.PP

import application.RH.*
import groovy.transform.ToString

@ToString(includes='nom') 

class Phase  implements Comparable {

    transient effectifService
    
    String nom
    Long ordre
    Float cleRepartition
    Boolean valeurAjoutee
    
    Competence competence    
    Ordonnancement monOrdo
    
    static hasMany = [kanbans : Kanban]
    
    static transients = ['affectables']
    
    public Effectif[] getAffectables() {
        def mesEffectifs = effectifService.affectables(competence)
        
        return mesEffectifs
    }
    
    static constraints = {
        valeurAjoutee nullable : true
        kanbans nullable : true
        competence nullable : true
        monOrdo nullable : true
    }
    
    static mappedBy = [kanbans : 'phaseActuelle']
    
    int compareTo(obj) {
       ordre.compareTo(obj.ordre)
   }
}
