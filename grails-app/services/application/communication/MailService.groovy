package application.communication

import grails.transaction.Transactional
import application.communication.*
import application.RH.*


@Transactional
class MailService {
    def springSecurityService
    
    
   //-------mail reçu et non archivé ---------  
    private MailEffectif[] afficherMail() {
        def per = Effectif.get(springSecurityService.principal.id)
        try { def query = MailEffectif.whereAny {                
            (recepteur { username == per.username }) && (archive == false)
           }
        def leMail = query.list(max : 10,sort : "dateCreated",order:"desc")
        
            return leMail
        }
        catch (NullPointerException n){
            return null
        }
    }
    
    
    
    
    //Corbeille--------------------------
       private MailEffectif[] afficherMailArchiver() {
        def per = Effectif.get(springSecurityService.principal.id)
        try { def query = MailEffectif.whereAny {                
            (recepteur { username == per.username }) && (archive == true)
           }
        def leMail1 = query.list(max: 10, sort:"dateCreated", order:"desc")
        
        
       
           return leMail1
        }
        catch (NullPointerException n){
            return null
        }
    }
//---------- mails favoris ---------------------
    
    private MailEffectif[] afficherMailFavoris() {
        def per = Effectif.get(springSecurityService.principal.id)
        try { def query = MailEffectif.whereAny {                
            (recepteur { username == per.username }) && (favoris == true)
           }
        def leMail2 = query.list(max: 10, sort:"dateCreated", order:"desc")
        
        
       
           return leMail2
        }
        catch (NullPointerException n){
            return null
        }
    }
    
//---------------------------------------------
    
//----------- listes des recepteurs --------------    
    
    
    
   private MailEffectif[] afficherRecepteurs(MailEffectif mailEffectifInstance) {
        def m = MailEffectif.get(mailEffectifInstance.id)
       
        try { def query = MailEffectif.whereAny {                
            ( mail { id == m.mail.id }) 
           }
        def leMail2 = query.list(max: 10, sort:"dateCreated", order:"desc")
        
        
       
           return leMail2
        }
        catch (NullPointerException n){
            return null
        }
    } 
    
//------------------------------------------------    
    
 
    
//--------- liste des mails-------------
   private Mail[] mailInbox() {
       def listeMailEffectif = afficherMail()
       // le * permet de faire boucler la liste
       def listeMailInbox=listeMailEffectif*.mail 
       return listeMailInbox
   }
   
       
//--------- liste des conversations a partir de la liste de mail-------------

    private Conversation[] mesConversations() {
        def listeMail = mailInbox()
        //je mets arraylist pour forcer le type. il y avait incompatobilite de type.
      def LesConversations = new ArrayList<Conversation>()
        def mesConversations = new ArrayList<Conversation>()
        listeMail.each() {mail -> 
            mesConversations.add(mail.conversation)
        }
        mesConversations.unique()
        // appeller la fonction qui donne le dernier mail pour chaque conversation
        mesConversations.sort{a,b-> b.lastmail.dateCreated<=>a.lastmail.dateCreated}
        return mesConversations
    }
    
    //____________________ Liste des mails à afficher dans une conversation en entrée _____________
    private Mail[] AfficherConversation(Conversation conversationInstance) {
        def lesmail = []
          def mailIN = mailInbox()
          def mailOUT =  mailenvoyer()
          def listeMail =  []
          listeMail.addAll(mailIN)
          listeMail.addAll(mailOUT)
         
          
          def maConversation = Conversation.get( conversationInstance.id)
         listeMail.each() { mail ->
        if(( mail.conversation == maConversation ) && (!lesmail.contains(mail))){
             lesmail.add(mail)     }
            
         }
        // Créer une liste de contenu unique basée sur les éléments de ArrayList
    Set mySet = new HashSet( lesmail)
 
    // Créer une Nouvelle ArrayList à partir de Set
  def lesmail2 = new ArrayList<Mail>(mySet); 
        
        lesmail2.sort{a,b-> b.dateCreated<=>a.dateCreated}

        return lesmail2
    }
//_____________________________________________________________________________
//_______________________Last Mail____________________________________________
 private Mail[] LastMail ()
 {
     def leslastmail = new ArrayList<Mail>()
    def lesConversations = mesConversations()
      
    lesConversations.each() { conversation ->
          def mailsconversation = AfficherConversation(conversation)
         // deja classé dans la fonction AfficherConversation
         //    mailsconversation.sort{a,b-> b.dateCreated<=>a.dateCreated}
         def lelastmail =  mailsconversation.getAt(0)
         
         leslastmail.add(lelastmail)  
     }
     
     return leslastmail
 }
 //___________________________________________________________________
//_____________ LE last mail pour répondre au author ________________
private  LEastMail ( Conversation conversationInstance )
 {
        def lesmail = []
        def maConversation = Conversation.get( conversationInstance.id)
        def mailIN = mailInbox()
  mailIN.each() { mail ->
        if(( mail.conversation == maConversation ) && (!lesmail.contains(mail))){
             lesmail.add(mail)     }
                }
                 lesmail.sort{a,b-> b.dateCreated<=>a.dateCreated}
                 def Monlastmail =  lesmail.getAt(0)
                 
     return Monlastmail
 }
 //___________________________________________________________________

//________________________________________________________
//--------- liste des mailsEffectifs par conversation a partir de la liste de mailEffectif-------------    
    private listeMailEffectif(Conversation conversation, MailEffectif[] maListe) {
        def mesMailsEffectifs = []
        conversation.mails.each() {mail ->
            maListe.each() {mailEffectif ->
            if(mailEffectif.mail == mail) {
                mesMailsEffectifs << mailEffectif
            }
                
            }
        }
        return mesMailsEffectifs
    }
    
    private Mail[] mailArchiver() {
       def listeMailEffectifArchiver = afficherMailArchiver()
       // le * permet de faire boucler la liste
       def listeMailArchiver=listeMailEffectifArchiver*.mail 
       return listeMailArchiver
   }
   private Mail[] mailFavoris() {
       def listeMailEffectifFavoris = afficherMailFavoris()
       // le * permet de faire boucler la liste
       def listeMailFavoris=listeMailEffectifFavoris*.mail 
       return listeMailFavoris
   }
   //----- mails envoyés ------------
    private Mail[] mailenvoyer() {
        def perSent = Effectif.get(springSecurityService.principal.id)
        try { def query = Mail.whereAny {                
            author { username == perSent.username }
            
        }
        def leMailSent = query.list(max: 10, sort:"dateCreated", order:"desc")
            return leMailSent
        }
        catch (NullPointerException n){
            return null
        }
    }
    
    //------- mails non lus--------------
     private MailEffectif[] mailnLu(MailEffectif[] mailNLU){
         def mailNonLu = []
         mailNLU.each() { NONLU -> 
             if(NONLU.lu == false) {
                 mailNonLu.add(NONLU)
             }
             
         }
         return mailNonLu
        
     }
    
    
        
//--------- liste des mails-------------
   private Mail[] mailHistoriques() {
       def listeMailEffectif = afficherMail()
       // le * permet de faire boucler la liste
       def listeMailInbox=listeMailEffectif*.mail // les classer par date de creation
       // faire une boucle sur cette liste : si mail.mailPrecedent non null on ajoute le mailPrecedent à une nouvelle liste
       // et on le supprime de listeMailInbox
        
        
       return listeMailInbox
   }
    
    
     //-------- id du user connecté------------------------------------
    private lookupCurrentPerson() {
        Effectif.get(springSecurityService.principal.id)
    }
    //----------- modification des valeurs des mails------------
    private messageLu(Conversation conversationInstance) {
        def per = Effectif.get(springSecurityService.principal.id)
        def Conver = Conversation.get(conversationInstance.id)
        Conver.mails.each() { mail ->
            mail.recepteur.each() { maileff ->
            if(  maileff.recepteur == per ){
                 maileff.lu = true
         maileff.save flush:true }
        }
        
    } 
    }
    
     private messageArchiver(MailEffectif mailEffectifInstance) {
        def mailEffectif = MailEffectif.get(mailEffectifInstance.id)
        mailEffectif.archive = true
        mailEffectif.favoris = false
        mailEffectif.save flush:true
    }
    
    private messagefavoris(MailEffectif mailEffectifInstance) {
        def mailEffectif = MailEffectif.get(mailEffectifInstance.id)
        mailEffectif.favoris = true
        mailEffectif.save flush:true
    }
    
    
    
}