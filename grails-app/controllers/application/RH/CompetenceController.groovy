package application.RH



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompetenceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Competence.list(params), model:[competenceInstanceCount: Competence.count()]
    }

    def show(Competence competenceInstance) {
        respond competenceInstance
    }

    def create() {
        respond new Competence(params)
    }

    @Transactional
    def save(Competence competenceInstance) {
        if (competenceInstance == null) {
            notFound()
            return
        }

        if (competenceInstance.hasErrors()) {
            respond competenceInstance.errors, view:'create'
            return
        }

        competenceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'competenceInstance.label', default: 'Competence'), competenceInstance.id])
                redirect competenceInstance
            }
            '*' { respond competenceInstance, [status: CREATED] }
        }
    }

    def edit(Competence competenceInstance) {
        respond competenceInstance
    }

    @Transactional
    def update(Competence competenceInstance) {
        if (competenceInstance == null) {
            notFound()
            return
        }

        if (competenceInstance.hasErrors()) {
            respond competenceInstance.errors, view:'edit'
            return
        }

        competenceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Competence.label', default: 'Competence'), competenceInstance.id])
                redirect competenceInstance
            }
            '*'{ respond competenceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Competence competenceInstance) {

        if (competenceInstance == null) {
            notFound()
            return
        }

        competenceInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Competence.label', default: 'Competence'), competenceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'competenceInstance.label', default: 'Competence'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
