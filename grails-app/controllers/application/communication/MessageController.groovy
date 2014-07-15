package application.communication


import application.PP.*

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = false)
class MessageController {

    def messageService
    def kanbanService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Message.list(params), model:[messageInstanceCount: Message.count()]
    }

    def show(Message messageInstance) {
        respond messageInstance
    }

    def create() {
        respond new Message(params)
    }

    @Transactional
    def save(Message messageInstance) {
        if (messageInstance == null) {
            notFound()
            return
        }

        if (messageInstance.hasErrors()) {
            respond messageInstance.errors, view:'create'
            return
        }

        messageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'messageInstance.label', default: 'Message'), messageInstance.id])
                redirect messageInstance
            }
            '*' { respond messageInstance, [status: CREATED] }
        }
    }

    def edit(Message messageInstance) {
        respond messageInstance
    }

    @Transactional
    def update(Message messageInstance) {
        if (messageInstance == null) {
            notFound()
            return
        }

        if (messageInstance.hasErrors()) {
            respond messageInstance.errors, view:'edit'
            return
        }

        messageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Message.label', default: 'Message'), messageInstance.id])
                redirect messageInstance
            }
            '*'{ respond messageInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Message messageInstance) {

        if (messageInstance == null) {
            notFound()
            return
        }

        messageInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Message.label', default: 'Message'), messageInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'messageInstance.label', default: 'Message'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    
    
    def posterMessage(String message) {
        println("dans poster message")
        messageService.posterMessage(message)
        render "<script>obtenirMessage()</script>"
    }
    
    
    
    def posterMessageCommentaire() {
        def monId = Long.parseLong(params.monId)
        println("l'id est " + monId)
        def com = params.message
        println("dans commentaire " + com + " : " + monId)
        messageService.posterMessageCommentaire(com,monId)
        render "<script>obtenirMessage()</script>"
    }
    
    
    def obtenirMessage() {
        
        def mesMessages
        if(params.kanban == null) {
            
            mesMessages = Message.list()
        }
        else {
            println("dans controller 1")
            println(params.kanban)
            def monId = Long.parseLong(params.kanban)
            println(monId)
            def monKanban = Kanban.get(monId)
            println("kanban : " + monKanban.id)
            mesMessages = kanbanService.afficherCRKanban(monKanban)
            
            println("mes messages ok")
        }
        def moi = messageService.lookupCurrentPerson()
        [mesMessages:mesMessages.reverse(), moi:moi]
    }
    
     def posterMessageKanban(String message, Long kanban) {
        
        println("controleur updateCR" + message + kanban)
        messageService.posterMessageKanban(message , kanban)
        render "<script>obtenirMessageKanban()</script>"
    }
    
    def obtenirMessageKanban() {
        
            println("dans controller 1")
            println(params.kanban)
            def monId = Long.parseLong(params.kanban)
            println(monId)
            def monKanban = Kanban.get(monId)
            println("kanban : " + monKanban.id)
            def mesMessages = kanbanService.afficherCRKanban(monKanban)
            
            println(mesMessages)
            def moi = messageService.lookupCurrentPerson()
            
        [mesMessages:mesMessages.reverse(), moi:moi]
    }
    
    
    def obtenirMessageEffectif() {
        def mesMessages = Message.list()
        def moi = messageService.lookupCurrentPerson()
        [mesMessages:mesMessages.reverse(), moi:moi]
    }
    
    
}
