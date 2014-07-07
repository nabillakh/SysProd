package application.PP


import groovy.transform.ToString
import application.RH.*
import application.CRM.*
import application.communication.*


@ToString(includes='nomKanban')
class Kanban {
    
    
     def kanbanService
     
    String nomKanban
    String description
    
    Date dateLancement= new Date()
    Date dateFinPlanifie
    
    Float chargePlanifiee
    
    Ordonnancement ordo
    Phase phaseActuelle
    Famille famille 
    Effectif chefProjet
    
    Client client
    
    
    SortedSet of
    static hasMany = [compteRendus : Message, of:OF]
    
    static transients = ['chargeRealisee','chargeAgenda', 'chargeRestantAPlanifier', 'chargeRestantARealiser', 'avancementRealise']
    
    public Float getChargeRealisee() {
        kanbanService.chargeKanbanRealise(this)
    }
    public Float getChargeAgenda() {
        kanbanService.chargeKanbanAgenda(this)
    }
    public Float getChargeRestantAPlanifier() {
        chargePlanifiee - chargeAgenda
    }
    public Float getChargeRestantARealiser() {
        chargePlanifiee - chargeRealisee
    }
    public Float getAvancementRealise() {
        chargeRealisee / chargePlanifiee * 100
    }
    public Float getAvancementAgenda() {
        chargeRealisee / chargeAgenda * 100
    }
     
    
    static constraints = {
        compteRendus nullable : true   
        ordo nullable : true
        phaseActuelle nullable :true
        dateFinPlanifie nullable : true
        chargePlanifiee nullable :true
        of nullable:true
        chefProjet nullable : true
        client nullable : true
    }
    
   
    def beforeInsert = {             
        }
        
    transient afterInsert = {
    }
    
    static mappedBy = [compteRendus : 'kanban', of : 'kanban']
}
