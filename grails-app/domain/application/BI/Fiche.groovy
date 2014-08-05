package application.BI

import application.pilotage.*

class Fiche {

    Boolean actif
    
    Date dateCreation = new Date()
    Date dateMaj = new Date()
    
    
    Date dateDebut
    Date dateFin
    
    // gestion des capacités
    
    Float capaciteTotale
    Float capaciteTheorique
    Float capacitePlanifiee
    Float capaciteRealisee
    
    // gestion des unités d'activité
    
    Float uaTotale
    Float uaTheorique
    Float uaPlanifiee
    Float uaRealisee
    // gestion des unités d'activité
    
    Float tempsStandard
    Float tempsMoyenPlanifie
    Float tempsMoyenRealise
    
    // gestion des charges
    
    Float chargeTotale
    Float chargeTheorique
    Float chargePlanifiee
    Float chargeRealisee
    
    // fiches qui mettent a jour celle ci
    static hasMany = [ficheSource : FicheAFiche, actions : Action]
    
    // baseline precedente
    Fiche baseline
    // baseline a venir
    Fiche baselineAVenir
    
    public Fiche(Object obj) {
        
    }
    
    static constraints = {
        actions nullable :true
        ficheSource nullable : true
        // gestion des capacités
    
        capaciteTotale nullable : true
        capaciteTheorique nullable : true
        capacitePlanifiee nullable : true
         capaciteRealisee nullable : true
        
    
    // gestion des unités d'activité
    
        uaTotale nullable : true
        uaTheorique nullable : true
        uaPlanifiee nullable : true
        uaRealisee nullable : true
        
    // gestion des unités d'activité
    
        tempsStandard nullable : true
        tempsMoyenPlanifie nullable : true
        tempsMoyenRealise nullable : true
        
    
    // gestion des charges
    
        chargeTotale nullable : true
        chargeTheorique nullable : true
        chargePlanifiee nullable : true
        chargeRealisee nullable : true
        
    }
    static mappedBy = [ficheSource : 'destinataire']
}
