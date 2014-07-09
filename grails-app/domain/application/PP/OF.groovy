package application.PP


import groovy.transform.ToString
import application.RH.*


@ToString()
class OF  implements Comparable {
// a retirer et passer en transient
    def kanbanService
    
    Kanban kanban
    Phase phase
    Float chargePlanifiee
    Float chargeImputee
    
    Long ordre
    
    static transients = ['chargeRealisee','chargeAgenda', 'chargeRestantAPlanifier', 'chargeRestantARealiser']
    
    public Float getChargeRealisee() {
        kanbanService.chargeOFRealise(this)
    }
    public Float getChargeAgenda() {
        kanbanService.chargeOFAgenda(this)
    }
    public Float getChargeRestantAPlanifier() {
        chargePlanifiee - chargeAgenda
    }
    public Float getChargeRestantARealiser() {
        chargePlanifiee - chargeRealisee
    }
    
    
    Date dateDebutPlanifie
    Date dateFinPlanifie
    
    static hasMany = [affectes : OFEffectif] 
    
    static constraints = {
        chargePlanifiee nullable : true
        chargeImputee nullable : true
        affectes nullable : true
        dateFinPlanifie nullable : true
        dateDebutPlanifie nullable : true
        ordre nullable : true
    }
    
    int compareTo(obj) {
       ordre.compareTo(obj.ordre)
   }
}
