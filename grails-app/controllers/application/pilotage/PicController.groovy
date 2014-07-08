package application.pilotage

import static org.springframework.http.HttpStatus.*
import grails.plugins.springsecurity.Secured
import grails.transaction.Transactional
import application.PP.*
import org.joda.time.DateTime

@Transactional(readOnly = false)
class PicController {
    
    def picService
    
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def maDate = new DateTime()
        def year = maDate.year
        
        def pic1 = picService.picAnnee(year - 1)
        def pic2 = picService.picAnnee(year)
        def pic3 = picService.picAnnee(year + 1)
        def pic4 = picService.picAnnee(year + 2)
        
        def mesFamilles = Famille.list()
        
        
        
        def picLists = picService.planPluriAnnuel(pic1, pic2, pic3, pic4)
               
        
        [picInstanceList: picLists, mesFamilles : mesFamilles, year:year, pic1:pic1, pic2:pic2, pic3:pic3, pic4:pic4]
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(Pic picInstance) {
        respond picInstance
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def create() {
        respond new Pic(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def save(Pic picInstance) {
        
        if (!picInstance.save(flush: true)) {
            render(view: "create", model: [picInstance: picInstance])
            return
        }
            // ajouter par NL
            // permet de creer des OF a la creation d'un Pic
        
        picService.generationPicFamille(picInstance)

        
        
        flash.message = message(code: 'default.created.message', args: [message(code: 'pic.label', default: 'Pic'), picInstance.id])
        // redirect(action: "show", id: picInstance.id)
        redirect(action:"index")
    }
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(Pic picInstance) {
        respond picInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update(Pic picInstance) {
        if (picInstance == null) {
            notFound()
            return
        }

        if (picInstance.hasErrors()) {
            respond picInstance.errors, view:'edit'
            return
        }

        picInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pic.label', default: 'Pic'), picInstance.id])
                redirect picInstance
            }
            '*'{ respond picInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete(Pic picInstance) {

        if (picInstance == null) {
            notFound()
            return
        }

        picInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pic.label', default: 'Pic'), picInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'picInstance.label', default: 'Pic'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
