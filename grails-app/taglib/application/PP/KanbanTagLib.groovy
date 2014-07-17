package application.PP

import application.PP.KanbanService
import application.RH.*

class KanbanTagLib {
    static namespace = 'kanbans'
    
    def kanbanService
    def eventService
    def springSecurityService
    
    def kanbanmini = { attrs ->
        
       
        def per = Effectif.get(springSecurityService.principal.id)
       def mesOF = []
       def mesOfs = kanbanService.mesOF(per)
       mesOfs.each() {of ->
            if(!of.kanban.fini) {
                mesOF.add(of)
            }}
        mesOF.eachWithIndex { OF, counter ->
            out << g.render(template: '/kanban/minikanban', model: [mesOF : mesOF, ofCounter: counter])
        }
    }
    
    def toDoList = {attrs -> 
    
    def maToDo = eventService.maToDo()
    def maCharge = kanbanService.chargeEffectifRealise()
    maToDo.eachWithIndex { Of, counter ->
            out << g.render(template: '/kanban/maToDo', model: [maToDo : maToDo, ofCounter: counter, maCharge : maCharge])      
        }
    
    }
}