package application.communication



import static org.springframework.http.HttpStatus.*
import grails.plugins.springsecurity.Secured
import grails.transaction.Transactional

@Transactional(readOnly = false)
class MailEffectifController {
   def mailService 
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MailEffectif.list(params), model:[mailEffectifInstanceCount: MailEffectif.count()]
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(MailEffectif mailEffectifInstance) {
        mailService.messageLu(mailEffectifInstance)

        def mailRecepteurs =  mailService.afficherRecepteurs(mailEffectifInstance)
        [mailEffectifInstance: mailEffectifInstance, mailRecepteurs : mailRecepteurs ]
        

        respond mailEffectifInstance

    } 
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def Archiver(MailEffectif mailEffectifInstance) {
        mailService.messageArchiver(mailEffectifInstance)
        respond mailEffectifInstance 
        redirect(controller: "mail", action: "index")
       
       }
       @Secured(['IS_AUTHENTICATED_REMEMBERED'])
     def Favoriser(MailEffectif mailEffectifInstance) {
        mailService.messagefavoris(mailEffectifInstance)
        respond mailEffectifInstance 
        redirect(controller: "mail", action: "index")
       
       }
    
    
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def create() {
        respond new MailEffectif(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def save(MailEffectif mailEffectifInstance) {
        if (mailEffectifInstance == null) {
            notFound()
            return
        }

        if (mailEffectifInstance.hasErrors()) {
            respond mailEffectifInstance.errors, view:'create'
            return
        }

        mailEffectifInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mailEffectifInstance.label', default: 'MailEffectif'), mailEffectifInstance.id])
                redirect mailEffectifInstance
            }
            '*' { respond mailEffectifInstance, [status: CREATED] }
        }
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(MailEffectif mailEffectifInstance) {
        respond mailEffectifInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update(MailEffectif mailEffectifInstance) {
        if (mailEffectifInstance == null) {
            notFound()
            return
        }

        if (mailEffectifInstance.hasErrors()) {
            respond mailEffectifInstance.errors, view:'edit'
            return
        }

        mailEffectifInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MailEffectif.label', default: 'MailEffectif'), mailEffectifInstance.id])
                redirect mailEffectifInstance
            }
            '*'{ respond mailEffectifInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete(MailEffectif mailEffectifInstance) {

        if (mailEffectifInstance == null) {
            notFound()
            return
        }

        mailEffectifInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MailEffectif.label', default: 'MailEffectif'), mailEffectifInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailEffectifInstance.label', default: 'MailEffectif'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
