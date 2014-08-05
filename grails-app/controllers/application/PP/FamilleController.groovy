package application.PP



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.JSON
import grails.plugins.springsecurity.Secured
import org.codehaus.groovy.grails.web.json.JSONObject
import application.pilotage.*
import application.PP.*
import application.RH.*
import application.*
import application.CRM.*

@Transactional(readOnly = false)
class FamilleController {
    def kanbanService
    def familleService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def familleList = Famille.list()
        [familleList: familleList]
    }

    def show(Famille familleInstance) {
        respond familleInstance
    }
    
    def projetFamille(Famille familleInstance) {
        
        def kanbanList = kanbanService.projetsFamille(familleInstance)
        [familleInstance: familleInstance, kanbanList : kanbanList]
        
    }
    def indicateurFamille(Famille familleInstance) {
        
        
        def kanbanList = kanbanService.projetsFamille(familleInstance)
        def kanbansFinis = familleService.projetsFinis(familleInstance)
        def kanbansEnCours = Math.round(kanbanList.size() - kanbansFinis.size())
        
        def chargeRealisee = 0
        def chargeFacturee = 0
        kanbansFinis.each() { kanban ->
            chargeRealisee += kanbanService.chargeKanbanRealise(kanban)
            chargeFacturee += kanban.chargePlanifiee
        }
        
        chargeRealisee = Math.round(chargeRealisee/kanbansFinis.size()*100)/100
        chargeFacturee = Math.round(chargeFacturee/kanbansFinis.size()*100)/100
        
        [familleInstance: familleInstance, kanbansFinis : kanbansFinis, kanbanList : kanbanList, kanbansEnCours : kanbansEnCours, chargeRealisee : chargeRealisee, chargeFacturee:chargeFacturee]
        
    }

    def create() {
        respond new Famille(params)
    }

    @Transactional
    def save(Famille familleInstance) {
        if (familleInstance == null) {
            notFound()
            return
        }

        if (familleInstance.hasErrors()) {
            respond familleInstance.errors, view:'create'
            return
        }

        familleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'familleInstance.label', default: 'Famille'), familleInstance.id])
                redirect familleInstance
            }
            '*' { respond familleInstance, [status: CREATED] }
        }
    }

    def edit(Famille familleInstance) {
        respond familleInstance
    }

    @Transactional
    def update(Famille familleInstance) {
        if (familleInstance == null) {
            notFound()
            return
        }

        if (familleInstance.hasErrors()) {
            respond familleInstance.errors, view:'edit'
            return
        }

        familleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Famille.label', default: 'Famille'), familleInstance.id])
                redirect familleInstance
            }
            '*'{ respond familleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Famille familleInstance) {

        if (familleInstance == null) {
            notFound()
            return
        }

        familleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Famille.label', default: 'Famille'), familleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'familleInstance.label', default: 'Famille'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def volumesClient = {
        
        // hypothese nbannee = nb pic
        def monId = Long.parseLong(params.monId)
        
              def maFamille = Famille.get(monId)
              
        
        def ArrayList<Kanban> kanbansFinis = familleService.projetsFinis(maFamille)
        def ArrayList<Kanban> kanbans = kanbanService.projetsFamille(maFamille)
        
        def clients = []
        kanbansFinis.each() {kanban ->
            clients.add(kanban.client)
        }
        clients.unique()
        def volumeClient = []
        clients.each() {client ->
            def listeClient = familleService.kanbanFamilleClient(kanbansFinis,client)
            def listeClient2 = familleService.kanbanFamilleClient(kanbans,client)
            
            def mesClients = new LinkedHashMap()
            mesClients.put("client",client.nom.toString())
            mesClients.put("volume",listeClient.size())
            mesClients.put("volume total",listeClient2.size())
            
             volumeClient << (mesClients)
        }
        
        
        [volumeClient: volumeClient]
        render volumeClient as JSON
    }
    
    
    
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def prodClient = {
        // hypothese nbannee = nb pic
        def monId = Long.parseLong(params.monId)
        
              def maFamille = Famille.get(monId)
              
        
        def ArrayList<Kanban> kanbansFinis = familleService.projetsFinis(maFamille)
        def ArrayList<Kanban> kanbans = kanbanService.projetsFamille(maFamille)
        
        def clients = []
        kanbansFinis.each() {kanban ->
            clients.add(kanban.client)
        }
        clients.unique()
        def volumeClient = []
        clients.each() {client ->
            def listeClient = familleService.kanbanFamilleClient(kanbansFinis,client)
            def listeClient2 = familleService.kanbanFamilleClient(kanbans,client)
            
            
        def chargeRealisee = 0
        def chargeFacturee = 0
        listeClient.each() { kanban ->
            chargeRealisee += kanbanService.chargeKanbanRealise(kanban)
            chargeFacturee += kanban.chargePlanifiee
        }
        
        chargeRealisee = Math.round(chargeRealisee/listeClient.size()*100)/100
        chargeFacturee = Math.round(chargeFacturee/listeClient.size()*100)/100
            
            
            def mesClients = new LinkedHashMap()
            mesClients.put("client",client.nom.toString())
            mesClients.put("charge facturee",chargeFacturee)
            mesClients.put("charge realisee",chargeRealisee)
            
             volumeClient << (mesClients)
        }
        
        
        [volumeClient: volumeClient]
        render volumeClient as JSON
    }
    
    
    def formOrdo() {
        
    }
    
}
