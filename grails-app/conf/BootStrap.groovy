import application.RH.*
import application.communication.*
import application.PP.*
import org.joda.time.DateTime
import static org.joda.time.DateTimeConstants.MONDAY
import static org.joda.time.DateTimeConstants.WEDNESDAY
import static org.joda.time.DateTimeConstants.FRIDAY


class BootStrap {

    def init = { servletContext ->
 environments {
            production {
     createData()
                // prod initialization
            }
            test {
    createData()
                // test initialization
            }
            development {
    createData()
                // dev initialization
            }
  }
    }
    def destroy = {
    }
    
    private void createData() {
        def kanbanService
        
        def maCompetence= new Competence( nom:"developpeur")
        
        ["VBA", "Java", "PHP", "Python"].each {nomA -> 
            def competence = new Competence(nom:nomA).save(failOnError: true)
        }
        def entreprise = new Entreprise(nom:"GRTGaz", tempsTravailJour : 8).save()
        
        def monEquipe = new Equipe(nom:'dev', entreprise : entreprise).save(failOnError: true)
        
        def adminRole = new Droit(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Droit(authority: 'ROLE_USER').save(flush: true)

      def testUser = new Effectif(username: 'test', entreprise : entreprise, password: 'test', nom : 'Lakhmissi', prenom : 'Nabil', equipe : monEquipe)
      def testUser2 = new Effectif(username: 'test2', entreprise : entreprise, password: 'test2', nom : 'Yemmi', prenom : 'Youcef', equipe : monEquipe)
      
        maCompetence.addToEffectifs(testUser)
        maCompetence.addToEffectifs(testUser2)
        testUser.save(failOnError: true)   
        testUser2.save(failOnError: true)   

      EffectifDroit.create testUser, adminRole, true
      EffectifDroit.create testUser2, adminRole, true
                
        maCompetence.save(failOnError: true)
        def maConversation = new Conversation().save(flush:true)
        def monMail = new Mail(conversation : maConversation, author : testUser2, message:"okokokok", objet : "objet n1").save(failOnError: true,flush: true)
        maConversation.lastmail =monMail
       maConversation.save flush:true
        def monMailEffectif = new MailEffectif(mail : monMail,recepteur : testUser, lu: false, archive: false, favoris: false ).save(failOnError: true,flush: true)
                
                 
        
        def maFamille = new Famille(nom : "Famille1", travaille : true).save(failOnError: true, flush : true)  
        def maFamille2 = new Famille(nom : "Famille2", travaille : true).save(failOnError: true, flush : true)  
        def maFamille3 = new Famille(nom : "Famille3", travaille : false).save(failOnError: true, flush : true)
        
        def monOrdo = new Ordonnancement(nom : "produit1", chargeStandard : 50, famille : maFamille).save(failOnError: true, flush : true) 
        def monOrdo2 = new Ordonnancement(nom : "produit2", chargeStandard : 50, famille : maFamille2).save(failOnError: true, flush : true) 
        def monOrdo3 = new Ordonnancement(nom : "grille3", chargeStandard : 50, famille : maFamille3).save(failOnError: true, flush : true) 
        def monOrdo4 = new Ordonnancement(nom : "grille4", chargeStandard : 50, famille : maFamille3).save(failOnError: true, flush : true) 
        
        
        def monKanban = new Kanban( nomKanban : "developpement fonction 1" , description : "c'est un kanban", famille : maFamille)
        
        
        ["Analyse":1, "Algorithme":2, "Developpement":3, "Test":4, "Mise en prod":5].each {nomA,numA -> 
            def phase = new Phase(nom : nomA,ordre:numA, competence:maCompetence, cleRepartition : 0.2, valeurAjoutee : true)
            monKanban.setPhaseActuelle(phase)
            monOrdo.addToPhases(phase)
            phase.save(failOnError: true)
        }
        
        
        
        monKanban.setOrdo(monOrdo)
        monOrdo.save(failOnError: true)
        monKanban.save(failOnError: true, flush : true)
        
        
        
        // event
        
        TimeZone.setDefault(TimeZone.getTimeZone('GMT'))

        def now = new DateTime()
        def tomorrow = now.plusDays(1)
        def nextMonday = now.withDayOfWeek(MONDAY).plusWeeks(1)

        // Creating a weekly event that occurs every MWF
        def event = new Event(title: 'evenement 1').with {
            startTime = now.toDate()
            endTime = now.plusHours(1).toDate()
            location = "Regular location"
            organisateur = testUser
            save(flush: true)
        }

        // Non-repeating single event that replaces the one excluded next Monday
        def event2 = new Event(title:  'event 2').with {
            startTime = nextMonday.toDate()
            endTime = nextMonday.plusHours(9).toDate()
            location = "New one-time location"
            organisateur = testUser
            save()
        }

        // Plain old non-repeating event
        def event3 = new Event(title: 'event isole').with {
            startTime = tomorrow.toDate()
            endTime = tomorrow.plusMinutes(240).toDate()
            organisateur = testUser2
            save()
        }
        
        def ee1 = new EventEffectif(event : event, recepteur : testUser, participe : true).save(flush : true)
        def ee2 = new EventEffectif(event : event2, recepteur : testUser, participe : true).save(flush : true)
        def ee3 = new EventEffectif(event : event3, recepteur : testUser2, participe : true).save(flush : true)
        
        
        
    }
        

        
} 
