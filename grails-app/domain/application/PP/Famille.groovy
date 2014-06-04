package application.PP

import groovy.transform.ToString


@ToString(includes= 'nom')
class Famille {
    
    def kanbanService
    
    String nom
    static hasMany = [ordo : Ordonnancement]
    
    boolean travaille
    
    static transients = ['chargePlanifiee', 'nbProjets']
    
    public int getChargePlanifiee() {
        0
    }
    public int getNbProjets() {
        return kanbanService.projetsFamille(this).size()
        
    }

    
    static constraints = {
        ordo nullable : true
        travaille nullable : true
    }
}
