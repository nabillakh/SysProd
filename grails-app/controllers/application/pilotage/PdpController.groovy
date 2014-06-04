package application.pilotage

import static org.springframework.http.HttpStatus.*
import grails.plugins.springsecurity.Secured
import grails.transaction.Transactional

@Transactional(readOnly = false)
class PdpController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pdp.list(params), model:[pdpInstanceCount: Pdp.count()]
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(Pdp pdpInstance) {
        respond pdpInstance
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def create() {
        respond new Pdp(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def save(Pdp pdpInstance) {
        if (pdpInstance == null) {
            notFound()
            return
        }

        if (pdpInstance.hasErrors()) {
            respond pdpInstance.errors, view:'create'
            return
        }

        pdpInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pdpInstance.label', default: 'Pdp'), pdpInstance.id])
                redirect pdpInstance
            }
            '*' { respond pdpInstance, [status: CREATED] }
        }
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(Pdp pdpInstance) {
        respond pdpInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update(Pdp pdpInstance) {
        if (pdpInstance == null) {
            notFound()
            return
        }

        if (pdpInstance.hasErrors()) {
            respond pdpInstance.errors, view:'edit'
            return
        }

        pdpInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pdp.label', default: 'Pdp'), pdpInstance.id])
                redirect pdpInstance
            }
            '*'{ respond pdpInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete(Pdp pdpInstance) {

        if (pdpInstance == null) {
            notFound()
            return
        }

        pdpInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pdp.label', default: 'Pdp'), pdpInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pdpInstance.label', default: 'Pdp'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    
    
}
