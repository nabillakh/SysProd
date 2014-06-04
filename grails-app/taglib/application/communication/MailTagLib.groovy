package application.communication

class MailTagLib {
    static namespace = 'messagerie'
    
    def mailService
    
    
    def miniMessagerie = { attrs ->
        
       def mesEffectifsMails = mailService.afficherMail()
       def mesMails = mailService.mailInbox()
     
       def mailNonLu = mailService.mailnLu(mesEffectifsMails)
       
        mesMails.eachWithIndex { mail, counter ->
            out << g.render(template: '/mail/miniInbox', model: [mailMessage: mail, messageCounter: counter, mailNonLu : mailNonLu, mesEffectifsMails : mesEffectifsMails])
        }
    }
      def gaucheMessagerie = { attrs ->
        
       def mesEffectifsMails = mailService.afficherMail()
       def mesMails = mailService.mailInbox()
     
       def mailNonLu = mailService.mailnLu(mesEffectifsMails)
       
        mesMails.eachWithIndex { mail, counter ->
            out << g.render(template: '/mail/miniMessagerie', model: [mailMessage: mail, messageCounter: counter, mailNonLu : mailNonLu, mesEffectifsMails : mesEffectifsMails])
        }
    }
    
    def listMessagerie = { attrs ->
        
       def mesmailEffectifFavoris =  mailService.afficherMailFavoris()
       def mesMailsFavoris = mailService.mailFavoris()
       def mesEffectifsMails = mailService.afficherMail()
       def mesMails = mailService.mailInbox()
       def mesMailsSent = mailService.mailenvoyer()
     
       def mesEffectifMailsArchiver = mailService.afficherMailArchiver() 
       def mesMailsArchiver = mailService.mailArchiver()
       def mailNonLu = mailService.mailnLu(mesEffectifsMails)
       
        mesMails.eachWithIndex { mail, counter ->
            out << g.render(template: '/mail/listmessages', model: [mailMessage: mail, messageCounter: counter, mailList: mesMails, mailList: mesMailsArchiver, maList: mesMailsFavoris, mesmailEffectifFavoris: mesmailEffectifFavoris, mesEffectifMailsArchiver:mesEffectifMailsArchiver,  mesEffectifsMails : mesEffectifsMails, mesMailsSent : mesMailsSent, mailNonLu:mailNonLu])
        }
    }
    
    
    
    
    
}
