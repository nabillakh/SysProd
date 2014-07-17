package application.PP

import grails.transaction.Transactional
import application.CRM.*

@Transactional
class FamilleService {

    def serviceMethod() {

    }
    
    def projetsFinis(Famille familleInstance) {
        
        
            def query = Kanban.whereAny {
                famille == familleInstance
            }
            def listeProjet = query.list()
            def listeProjets = []
            listeProjet.each() {projet ->
                if(projet.fini) {
                    listeProjets.add(projet)
                }
        }
        
        return listeProjets
    }
    
    def kanbanFamilleClient(ArrayList<Kanban> kanbanList , Client client) {
        def kanbanClient = []
        kanbanList.each() {kanban ->
            if(kanban.client == client) {
                kanbanClient.add(kanban)
            }
        }
        return kanbanClient
    }
}
