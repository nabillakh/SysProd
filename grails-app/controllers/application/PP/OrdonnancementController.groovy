package application.PP



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OrdonnancementController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Ordonnancement.list(params), model:[ordonnancementInstanceCount: Ordonnancement.count()]
    }

    def show(Ordonnancement ordonnancementInstance) {
        respond ordonnancementInstance
    }

    def create() {
        println("ok dans create")
        respond new Ordonnancement(params)
    }

    def creerOrdo() {
        println("creerOrdo ok")
        def ordonnancementInstance = new Ordonnancement()
        println(ordonnancementInstance)
        render "<script>obtenirFormulaireOrdo()</script>"
        [ordonnancementInstance : ordonnancementInstance]
    }

    @Transactional
    def save(Ordonnancement ordonnancementInstance) {
        if (ordonnancementInstance == null) {
            notFound()
            return
        }

        if (ordonnancementInstance.hasErrors()) {
            respond ordonnancementInstance.errors, view:'create'
            return
        }

        ordonnancementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ordonnancementInstance.label', default: 'Ordonnancement'), ordonnancementInstance.id])
                redirect ordonnancementInstance
            }
            '*' { respond ordonnancementInstance, [status: CREATED] }
        }
    }

    def edit(Ordonnancement ordonnancementInstance) {
        respond ordonnancementInstance
    }

    @Transactional
    def update(Ordonnancement ordonnancementInstance) {
        if (ordonnancementInstance == null) {
            notFound()
            return
        }

        if (ordonnancementInstance.hasErrors()) {
            respond ordonnancementInstance.errors, view:'edit'
            return
        }

        ordonnancementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Ordonnancement.label', default: 'Ordonnancement'), ordonnancementInstance.id])
                redirect ordonnancementInstance
            }
            '*'{ respond ordonnancementInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Ordonnancement ordonnancementInstance) {

        if (ordonnancementInstance == null) {
            notFound()
            return
        }

        ordonnancementInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Ordonnancement.label', default: 'Ordonnancement'), ordonnancementInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ordonnancementInstance.label', default: 'Ordonnancement'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
