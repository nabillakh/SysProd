package application.RH


import grails.converters.JSON
import grails.plugins.springsecurity.Secured
import org.codehaus.groovy.grails.web.json.JSONObject
import application.pilotage.*
import application.PP.*
import application.communication.*

import application.*

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional


@Transactional(readOnly = false)
class EquipeController {
def springSecurityService
        def kanbanService
        def eventService
        def messageService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Equipe.list(params), model:[equipeInstanceCount: Equipe.count()]
    }

    def show(Equipe equipeInstance) {
        
        respond equipeInstance
    }

    def create() {
        respond new Equipe(params)
    }

    @Transactional
    def save(Equipe equipeInstance) {
        if (equipeInstance == null) {
            notFound()
            return
        }

        if (equipeInstance.hasErrors()) {
            respond equipeInstance.errors, view:'create'
            return
        }

        equipeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'equipeInstance.label', default: 'Equipe'), equipeInstance.id])
                redirect equipeInstance
            }
            '*' { respond equipeInstance, [status: CREATED] }
        }
    }

    def edit(Equipe equipeInstance) {
        respond equipeInstance
    }

    @Transactional
    def update(Equipe equipeInstance) {
        if (equipeInstance == null) {
            notFound()
            return
        }

        if (equipeInstance.hasErrors()) {
            respond equipeInstance.errors, view:'edit'
            return
        }

        equipeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Equipe.label', default: 'Equipe'), equipeInstance.id])
                redirect equipeInstance
            }
            '*'{ respond equipeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Equipe equipeInstance) {

        if (equipeInstance == null) {
            notFound()
            return
        }

        equipeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Equipe.label', default: 'Equipe'), equipeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    
    
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def obtenirKanbanEquipe() {
        println(params.equipe + "dans  equipe ")
        
        def kanbanInstanceList = []
       def  kanbanListParticipants = []
        def query = Effectif.whereAny {                
            equipe { params.equipe }
           }
        def malisteEffectif = query.list()
        println(malisteEffectif + " participants ")
        
           malisteEffectif.each() {user -> 
                 
                kanbanListParticipants = kanbanService.listeKanbanEffectif(user)
                println( kanbanListParticipants + "  kanban participants ")
             kanbanInstanceList.addAll(kanbanListParticipants);
              println( kanbanListParticipants + "  tout le monde ")
        }
        kanbanInstanceList.unique()
       [kanbanInstanceList:kanbanInstanceList]
       
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'equipeInstance.label', default: 'Equipe'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
