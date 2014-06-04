package application.communication

import application.RH.*
import application.communication.*
import grails.plugins.springsecurity.Secured


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = false)
class MailController {
    def mailService  
    def springSecurityService
    
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index(Integer max) {
       
        
        
       def mesmailEffectifFavoris =  mailService.afficherMailFavoris()
       def mesMailsFavoris = mailService.mailFavoris()
       def mesEffectifsMails = mailService.afficherMail()
       def mesMails = mailService.mailInbox()
       def mesMailsSent = mailService.mailenvoyer()
         def mesConversations = mailService.mesConversations()
        def mesEffectifMailsArchiver = mailService.afficherMailArchiver() 
       def mesMailsArchiver = mailService.mailArchiver()
       def mailNonLu = mailService.mailnLu(mesEffectifsMails)
       def  meslastmail = mailService.LastMail()
       
       
       // params.max = Math.min(max ?: 10, 100)
       // respond Mail.list(params), model:[mailInstanceCount: Mail.count()]
        [mailList: mesMails, mailList: mesMailsArchiver, maList: mesMailsFavoris, mesmailEffectifFavoris: mesmailEffectifFavoris, mesEffectifMailsArchiver:mesEffectifMailsArchiver,  mesEffectifsMails : mesEffectifsMails, mesMailsSent : mesMailsSent, mailNonLu:mailNonLu, mesConversations : mesConversations,meslastmail:meslastmail ]
    }
   @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def show(Mail mailInstance) {
        respond mailInstance
    }
    //_______________show Conversation ___________________

   @Secured([ 'IS_AUTHENTICATED_REMEMBERED']) 
   def ShowConversation (Conversation conversationInstance ){
       mailService.messageLu( conversationInstance)
       def Listmail = mailService.AfficherConversation(conversationInstance)
       def Monlastmail = mailService.LEastMail(conversationInstance)
       [Listmail : Listmail ,  conversationInstance : conversationInstance,  Monlastmail: Monlastmail]
       
   }
    
    //______________________________________________________
    
   @Secured(['IS_AUTHENTICATED_REMEMBERED'])
   def create() {
         
        respond new Mail(params)
    }

   @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def save() {
      def author = mailService.lookupCurrentPerson()
      def monMessage = params.message
      def monObjet = params.objet
      //---creation de la conversation pour un nouveau message--------
      def maConversation = new Conversation().save(flush:true)
      // mettre la conversation a la creation du mail
      def mail = new Mail(conversation : maConversation ,message : monMessage, author : author, objet : monObjet).save(flush:true)
       maConversation.lastmail = mail
       maConversation.save flush:true
      def lu = false
      def archive = false 
      def favoris = false
      params.recepteur.each()  {user ->
          def monMailEffectif = new MailEffectif(mail:mail, recepteur:user, lu:lu, archive:archive, favoris:favoris ).save()
      }
      
        redirect action:'index'

    }
 //__________________ReplyALL__________________________ 
   @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def RelierALL() {
        //récupérer lautor de last mail pour l'ajouter a la liste des recepteur 
       def lauthor = params.author
      def authorR = mailService.lookupCurrentPerson()
      def monMessageR = params.message
      //------attribuer l'id de la conversation au nouveau mail-----
      def maconversationR = params.conversation
      def monObjetR = params.objet
     def  listrecepteur = new ArrayList<Effectif>()
     
      params.recepteur.each()  { user ->
         if(user != authorR){ listrecepteur.add(user)} // le filtre ne marche pas il récupere le mail connecté aussi 
         }
         
         listrecepteur.add(lauthor)
         
      
      def mailR = new Mail(message : monMessageR, author : authorR, objet : monObjetR, conversation: maconversationR).save()
      
      def lu = false
      def archive = false 
      def favoris = false
      listrecepteur.each()  {user ->
          def monMailEffectif = new MailEffectif(mail:mailR, recepteur:user, lu:lu, archive:archive, favoris:favoris ).save()
      }
      
        redirect action:'index'

    }
 //_________________________________________________________________
//________________________Repondre à l'auteur seulement_____________
@Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def Relier() {
      def authorR = mailService.lookupCurrentPerson()
      def monMessageR = params.message
      //------attribuer l'id de la conversation au nouveau mail-----
      def maconversationR = params.conversation
      def monObjetR = params.objet
      def mailR = new Mail(message : monMessageR, author : authorR, objet : monObjetR, conversation: maconversationR).save()
       
      def lu = false
      def archive = false 
      def favoris = false
      params.recepteur.each()  {user ->
          def monMailEffectif = new MailEffectif(mail:mailR, recepteur:user, lu:lu, archive:archive, favoris:favoris ).save()
      }
      
        redirect action:'index'

    }
    
//____________________________________________________________
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def save2(Mail mailInstance) {
      def author = mailService.lookupCurrentPerson()
      mailInstance.author = author
      mailInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mailInstance.label', default: 'Mail'), mailInstance.id])
                redirect mailInstance
            }
            '*' { respond mailInstance, [status: CREATED] }
        }
    }
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def edit(Mail mailInstance) {
        respond mailInstance
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update(Mail mailInstance) {
        if (mailInstance == null) {
            notFound()
            return
        }

        if (mailInstance.hasErrors()) {
            respond mailInstance.errors, view:'edit'
            return
        }

        mailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Mail.label', default: 'Mail'), mailInstance.id])
                redirect mailInstance
            }
            '*'{ respond mailInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def delete(Mail mailInstance) {

        if (mailInstance == null) {
            notFound()
            return
        }

        mailInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Mail.label', default: 'Mail'), mailInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailInstance.label', default: 'Mail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    
    
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [MailInstanceList: Mail.list(params), MailInstanceTotal: Effectif.count()]
    }
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def maListe(Integer max) {
        
       def mesEffectifsMails = mailService.afficherMail()
       def mesMails = mailService.mailInbox()
       // params.max = Math.min(max ?: 10, 100)
       // respond Mail.list(params), model:[mailInstanceCount: Mail.count()]
       
       def content = messagerie.miniMessagerie mesMails:mesMails
       
       render content
       
    } 
    
    
    
}
