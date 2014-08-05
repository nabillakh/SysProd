import application.RH.*
import application.communication.*
import application.PP.*
import application.pilotage.*
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
        
        
        def entreprise = new Entreprise(nom:"GRTGaz", tempsTravailJour : 8).save()
        
        def monEquipe = new Equipe(nom:'Service dev', entreprise : entreprise).save(failOnError: true)
        
        def adminRole = new Droit(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Droit(authority: 'ROLE_USER').save(flush: true)

      def testUser = new Effectif(emploi : 'developpeur', username: 'test', entreprise : entreprise, password: 'test', nom : 'Lakhmissi', prenom : 'Nabil', equipe : monEquipe)
      def testUser2 = new Effectif(emploi : 'developpeur js', username: 'test2', entreprise : entreprise, password: 'test2', nom : 'Yemmi', prenom : 'Youcef', equipe : monEquipe)
      
      
        testUser.save(failOnError: true)   
        testUser2.save(failOnError: true)

      EffectifDroit.create testUser, adminRole, true
      EffectifDroit.create testUser2, adminRole, true
                
        def maConversation = new Conversation().save(flush:true)
        def monMail = new Mail(conversation : maConversation, author : testUser2, message:"okokokok", objet : "objet n1").save(failOnError: true,flush: true)
        maConversation.lastmail =monMail
       maConversation.save flush:true
        def monMailEffectif = new MailEffectif(mail : monMail,recepteur : testUser, lu: false, archive: false, favoris: false ).save(failOnError: true,flush: true)
                        
    }
        

    private void createData2() {
        def kanbanService
        def picService
        
        def maCompetence= new Competence( nom:"developpeur")
        
        ["VBA", "Java", "PHP", "Python"].each {nomA -> 
            def competence = new Competence(nom:nomA).save(failOnError: true)
        }
        def entreprise = new Entreprise(nom:"GRTGaz", tempsTravailJour : 8).save()
        
        def monEquipe = new Equipe(nom:'dev', entreprise : entreprise).save(failOnError: true)
        
        def adminRole = new Droit(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Droit(authority: 'ROLE_USER').save(flush: true)

      def testUser = new Effectif(emploi : 'developpeur', username: 'test', entreprise : entreprise, password: 'test', nom : 'Lakhmissi', prenom : 'Nabil', equipe : monEquipe)
      def testUser2 = new Effectif(emploi : 'developpeur js', username: 'test2', entreprise : entreprise, password: 'test2', nom : 'Yemmi', prenom : 'Youcef', equipe : monEquipe)
      
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
                
                 
        
        def maFamille = new Famille(nom : "Etudes", travaille : true).save(failOnError: true, flush : true)  
        def maFamille2 = new Famille(nom : "Projets", travaille : true).save(failOnError: true, flush : true)  
        def maFamille3 = new Famille(nom : "Absence", travaille : false).save(failOnError: true, flush : true)
        def maFamille4 = new Famille(nom : "Management", travaille : true).save(failOnError: true, flush : true)
        
        def monOrdo = new Ordonnancement(nom : "Paramétrage", chargeStandard : 50, famille : maFamille).save(failOnError: true, flush : true) 
        def monOrdo1 = new Ordonnancement(nom : "Nouvelle fonction", chargeStandard : 20, famille : maFamille).save(failOnError: true, flush : true) 
        def monOrdo2 = new Ordonnancement(nom : "nouveau projet dev.", chargeStandard : 20, famille : maFamille2).save(failOnError: true, flush : true) 
        def monOrdo3 = new Ordonnancement(nom : "Absences", chargeStandard : 5, famille : maFamille3).save(failOnError: true, flush : true) 
        def monOrdo4 = new Ordonnancement(nom : "Management", chargeStandard : 50, famille : maFamille4).save(failOnError: true, flush : true) 
        
        def date = new Date()
        
        def now2 = new DateTime()
        def tomorrow2 = now2.plusDays(19)
        Date fin = tomorrow2.toDate()
        def monKanban = new Kanban(chefProjet : testUser , chargePlanifiee : 20 , fini: false, nomKanban : "developpement fonction 1" , description : "c'est un kanban", dateLancement : date, famille : maFamille, dateFinPlanifie : fin)
        
        
        ["Analyse":1, "Algorithme":2, "Developpement":3, "Test":4, "Mise en prod":5].each {nomA,numA -> 
            def phase = new Phase(nom : nomA,ordre:numA, competence:maCompetence, cleRepartition : 0.2, valeurAjoutee : true)
            monKanban.setPhaseActuelle(phase)
            monOrdo.addToPhases(phase)
            phase.save(failOnError: true)
        }
        
        
        ["Definition du besoin":1, "Cadrage":2, "Developpement":3, "Test":4, "Mise en prod":5].each {nomA,numA -> 
            def phase = new Phase(nom : nomA,ordre:numA, competence:maCompetence, cleRepartition : 0.2, valeurAjoutee : true)
            
            monOrdo2.addToPhases(phase)
            phase.save(failOnError: true)
        }
        
        
        ["RTT":1, "Congé annuel":2, "Maladie":3].each {nomA,numA -> 
            def phase = new Phase(nom : nomA,ordre:numA, cleRepartition : 1, valeurAjoutee : false)
            monOrdo3.addToPhases(phase)
            phase.save(failOnError: true)
        }
        
        
        monKanban.setOrdo(monOrdo)
        monOrdo.save(failOnError: true)
        monOrdo3.save(failOnError: true)
        monOrdo2.save(failOnError: true)
        // monKanban.save()
        
        
        // kanbanService.requeteCreation(monKanban) 
        monKanban.save(failOnError: true, flush : true)
        
        
        def pic1 = new Pic(annee : 2013, archive : false, version : 0).save(failOnError: true, flush : true)
        
        def pic2 = new Pic(annee : 2014, archive : false, version : 0).save(failOnError: true, flush : true)
        
        def pic3 = new Pic(annee : 2015, archive : false, version : 0).save(failOnError: true, flush : true)
        
        def pic4 = new Pic(annee : 2016, archive : false, version : 0).save(failOnError: true, flush : true)
        
        def pics = Pic.list()
        pics.each() { pic -> 
        def mesFamilles = Ordonnancement.list()
        mesFamilles.each() {fam ->
            def picFam = new PicFamille(pic : pic, ordo : fam, uniteActivite : 24).save(failOnError: true, flush : true)
            pic.addToPicFamille(picFam)
            picFam.save(failOnError: true, flush : true)
        }
        def picfamilles = PicFamille.list()
        picfamilles.each() {picFam ->
            def mois = 0
            while(mois++<12) {
                def Float unite = 5+mois
                def monPdp = new Pdp(picFamille : picFam , mois : mois, uniteActivite : unite)
            picFam.addToPdp(monPdp)
                .save(failOnError: true, flush : true)
            monPdp.save(failOnError: true, flush : true)
            
        }
        picFam.save(failOnError: true, flush : true)
    }
        pic.save(failOnError: true, flush : true)
        
        }
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
