package application.communication

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.validation.Validateable
import java.text.SimpleDateFormat
import org.joda.time.DateTime
import grails.converters.JSON

import application.PP.*
import application.RH.*

@Transactional(readOnly = false) 
class EventController {

    def kanbanService
    def eventService
    def springSecurityService
    
    static allowedMethods = [save: "POST", update: "PUT", delete: "POST"]
    
    def index(Integer max) {
        // envoi de la liste d event
        
        def per = Effectif.get(springSecurityService.principal.id)
        def mesOF = kanbanService.mesOF(per)
        
        params.max = Math.min(max ?: 10, 100)
        respond Event.list(params), model:[eventInstanceCount: Event.count(), mesOF : mesOF]
    }
    
    
    
    
    
    def showPopup = {
        println('dans showpopup')
        def eventInstance = Event.get(params.id)
        println(eventInstance.title)
        
        [eventInstance: eventInstance]
        render(template: "showPopup")
        

    }

    def show = {
        def eventInstance = Event.get(params.id)
        

        if (!eventInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), params.id])}"
            redirect(action: "index")
        }
        else {
            def model = [eventInstance: eventInstance, occurrenceStart: occurrenceStart, occurrenceEnd: occurrenceEnd]

            if (request.xhr) {
                render(template: "show", model: model)
            }
            else {
                model
            }
        }

    }
    
    def list = {
        println("dans controlleur")
        def events = eventService.mesEvent()
        
        // def events = Event.list()
        
        def eventList = []

        def displayDateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

        events.each {event ->
          
            DateTime startTime = new DateTime(event.startTime)
            DateTime endTime = new DateTime(event.endTime)

                /*
                    start/end and occurrenceStart/occurrenceEnd are separate because fullCalendar will use the client's local timezone (which may be different than the server's timezone)
                    start/end are used to render the events on the calendar and the occurrenceStart/occurrenceEnd values are passed along to the show popup
                */

                eventList << [
                id: event.id,    
                title: event.title,
                        allDay: false,
                        start: displayDateFormatter.format(startTime.toDate()),
                        end: displayDateFormatter.format(endTime.toDate()),
                ]
            }
                [eventInstanceList: eventList]
           
                render eventList as JSON 
    }

    def create() { 
        respond new Event(params)
    }

    @Transactional
    def save(Event eventInstance) {
        if (eventInstance == null) {
            notFound()
            return
        }

        if (eventInstance.hasErrors()) {
            respond eventInstance.errors, view:'create'
            return
        }
        
        eventInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eventInstance.label', default: 'Event'), eventInstance.id])
                redirect eventInstance
            }
            '*' { respond eventInstance, [status: CREATED] }
        }
    }
    
    
    @Transactional
    def nouveauEvent() {
        // recupere en params le json du nouvel event. traduit en joda les dates puis cree l'event dans la bdd        
        def titre = params.title
        DateTime debut = new DateTime(params.start)
        
        DateTime fin = new DateTime(params.end)
        
        Event eventInstance = new Event()      
            eventInstance.title = titre
            eventInstance.startTime = debut.toDate()
            eventInstance.endTime = fin.toDate()
            
        println("avant save")
        eventInstance.save()
        // met le user principal en organisateur + dans les participants
        eventService.organiserEvent(eventInstance)
        
        [eventInstance : eventInstance]
        redirect action: "list" 
    }
    
    @Transactional
    def nouveauEventKanban() {
        // recupere en params le json du kanban planifie. traduit en joda les dates puis cree l'event dans la bdd        
        def titre = params.title
        println(" titre : " + titre)
        DateTime debut = new DateTime(new Date(params.start))
        
        DateTime fin = new DateTime(new Date(params.end))
        
        println("debut : " + debut)
        
        println("fin : " + fin)
        
        Event eventInstance = new Event()      
            eventInstance.title = titre
            eventInstance.startTime = debut.toDate()
            eventInstance.endTime = fin.toDate()
           
        println("fin a partir de l'event: " + eventInstance.endTime) 
        
        eventInstance.save()
        // met le user principal en organisateur + dans les participants
        def eventEffectif = eventService.organiserEvent(eventInstance)
        println("retour dans controleur : " + eventEffectif.id)
        // creation de l'imputation
        
        eventService.imputation(eventEffectif, OF.get(params.id))
        
        
        
        [eventInstance : eventInstance]
        redirect action: "list" 
    }
    
    @Transactional
    def eventResize() {
        def displayDateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        // recupere en params le json de l'event modifie. traduit en joda les dates puis cree l'event dans la bdd        
        def monId = params.id
        
        def eventInstance = Event.get(monId)
       DateTime debut = new DateTime(new Date(params.start))
        
        DateTime fin = new DateTime(new Date(params.end))
        
        println("debut : " + debut)
        
        println("fin : " + fin)
         eventInstance.startTime = debut.toDate()
            eventInstance.endTime = fin.toDate()
        
        eventInstance.save(flush : true)
        
        
        // eventInstance.save()
        
        // maj de l'imputation
        
        // eventService.imputation(eventInstance, OF.get(params.id))
        
        
        
        [eventInstance : eventInstance]
        redirect action: "list" 
    }
    
    @Transactional
    def delete() {

  println('dans delet') 
  // recupere en params le json de l'event modifie. traduit en joda les dates puis cree l'event dans la bdd        
        def monId = params.id
        println(monId)
        Event eventInstance = Event.get(monId)
  
            

            println('avant suppression')
            println(eventInstance)
            eventInstance.delete flush:true
            println('aprés supptression')
            println(eventInstance)
            redirect action: "list"
        
    }
}
