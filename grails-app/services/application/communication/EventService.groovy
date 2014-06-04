package application.communication

import org.springframework.transaction.annotation.Transactional

import application.PP.*
import application.PP.KanbanService
import application.RH.*


class EventService {

    
    def springSecurityService
    
    def imputation(EventEffectif e, OF of)  {
        println("dans imputation service")
        def monEventOf = new Imputation(eventEffectif : e, of : of, realise : false, tempsImpute : 0, effectif : e.recepteur)
        monEventOf.save()       
        println("creation de l'imputation?" + monEventOf.id)
      
    }
    
    def simputer(Imputation imput, Float temps) {
        imput.setRealise(true)
        imput.setTempsImpute(temps)
        imput.save()            
    }
    // pour ma todo
       private OF[] maToDo() {
        def lesOF = [] 
        def aujourdhui = new Date()
        def per = Effectif.get(springSecurityService.principal.id)
        try {
            def query = OF.whereAny {
                affectes {per}
                dateFinPlanifie > aujourdhui + 1
            }
            lesOF = query.list()
        }
        
        catch (NullPointerException n){
        }
        
        return lesOF
    }
    
    
    // associe l'organisateur aux participants à la création de l'event
    private EventEffectif organiserEvent(Event e) {
        def per = Effectif.get(springSecurityService.principal.id)
        def eventEffectif = new EventEffectif(event : e, recepteur : per, participe : true)
        eventEffectif.save(flush:true)
        e.organisateur=per
        e.addToParticipants(eventEffectif)
        e.save(flush:true)
        println("mon event effectif :" + eventEffectif.id)
        return eventEffectif
    }

     // liste d'event concernant le principal
     
    private Event[] mesEvent() {
        def lesEventEffectif = [] 
        def lesEvent = [] 
        def per = Effectif.get(springSecurityService.principal.id)
        try {
            def query = EventEffectif.whereAny {
                recepteur == per
            }
            lesEventEffectif = query.list()
            lesEventEffectif.each() { ee ->
                lesEvent.add(ee.event)            
            }
        }
        
        catch (NullPointerException n){
        }
        
        return lesEvent
    }
    
    

}
