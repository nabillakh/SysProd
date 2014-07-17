package application.RH



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompetenceEffectifController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompetenceEffectif.list(params), model:[competenceEffectifInstanceCount: CompetenceEffectif.count()]
    }

    def show(CompetenceEffectif competenceEffectifInstance) {
        respond competenceEffectifInstance
    }

    def create() {
        respond new CompetenceEffectif(params)
    }

    @Transactional
    def save(CompetenceEffectif competenceEffectifInstance) {
        if (competenceEffectifInstance == null) {
            notFound()
            return
        }

        if (competenceEffectifInstance.hasErrors()) {
            respond competenceEffectifInstance.errors, view:'create'
            return
        }

        competenceEffectifInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'competenceEffectifInstance.label', default: 'CompetenceEffectif'), competenceEffectifInstance.id])
                redirect competenceEffectifInstance
            }
            '*' { respond competenceEffectifInstance, [status: CREATED] }
        }
    }

    def edit(CompetenceEffectif competenceEffectifInstance) {
        respond competenceEffectifInstance
    }

    @Transactional
    def update(CompetenceEffectif competenceEffectifInstance) {
        if (competenceEffectifInstance == null) {
            notFound()
            return
        }

        if (competenceEffectifInstance.hasErrors()) {
            respond competenceEffectifInstance.errors, view:'edit'
            return
        }

        competenceEffectifInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompetenceEffectif.label', default: 'CompetenceEffectif'), competenceEffectifInstance.id])
                redirect competenceEffectifInstance
            }
            '*'{ respond competenceEffectifInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CompetenceEffectif competenceEffectifInstance) {

        if (competenceEffectifInstance == null) {
            notFound()
            return
        }

        competenceEffectifInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompetenceEffectif.label', default: 'CompetenceEffectif'), competenceEffectifInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'competenceEffectifInstance.label', default: 'CompetenceEffectif'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
