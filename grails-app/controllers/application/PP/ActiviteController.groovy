package application.PP

import grails.converters.JSON
import grails.plugins.springsecurity.Secured
import org.codehaus.groovy.grails.web.json.JSONObject
import application.pilotage.*
import application.PP.*
import application.RH.*
import application.*

import org.joda.time.DateTime

class ActiviteController {
        
	def springSecurityService
        def kanbanService
        def indicateurService
        def imputationService
        
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def activite(Integer max) {
        
        def kanbanInstanceList = kanbanService.listeKanbanEffectif()
        [kanbanInstanceList:kanbanInstanceList]
    }
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def portefeuille(Integer max) {
        def listeKanban = kanbanService.listeKanban()
        def listeFamille = kanbanService.listeFamille()
        def listePhase = kanbanService.listePhase()
        def listeOrdo = kanbanService.listeOrdo()
        def monKanban = new Kanban()
        def mesOF = monKanban.of
        
        [mesOF : mesOF, monKanban : monKanban, familleInstanceList : listeFamille, phaseInstanceList : listePhase, ordoInstanceList : listeOrdo]
    }
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def nouveauKanban() {
        def nomKanban = params.nomKanban
        // def monId = Long.parseLong(params.monId)
        def monId = params.monId
        DateTime dateLivraison = new DateTime(params.dateLivraison)
        def description = params.description
        def famille = params.famille
        def ordo = params.ordo
        def chargePlanifiee = Float.parseFloat(params.chargePlanifiee)
        
        def monKanban = new Kanban()
        if(monId=="NC") {
            monKanban = new Kanban()
            // monKanban.id = monId
            monKanban.nomKanban = nomKanban
            monKanban.dateFinPlanifie = dateLivraison.toDate()
            monKanban.description = description
            monKanban.famille = Famille.get(Integer.parseInt(famille))
            monKanban.ordo = Ordonnancement.get(Integer.parseInt(ordo))
            monKanban.chargePlanifiee = chargePlanifiee 
            println("1 nom du kanban: " + monKanban.nomKanban) 
            println("1 id du kanban: " + monId) 
            println("1 nom dde famille avec objet: " + monKanban.famille)
            monKanban.save(flush : true)
        }
        else {
            println("dans update") 
            def monId2 = Long.parseLong(monId)
            println("1 id du kanban: " + monId) 
            monKanban = Kanban.get(monId2)
            println("1 nom du kanban chargé: " + monKanban.nomKanban) 
            monKanban.setNomKanban(nomKanban)
            println("1 nom du kanban modifié 2: " + monKanban.nomKanban) 
            monKanban.dateFinPlanifie = dateLivraison.toDate()
            monKanban.description = description
            monKanban.famille = Famille.get(Integer.parseInt(famille))
            monKanban.ordo = Ordonnancement.get(Integer.parseInt(ordo))
            monKanban.chargePlanifiee = chargePlanifiee 
            monKanban.save(flush : true)
        }
        kanbanService.requeteCreation(monKanban)        
        monKanban.save(flush : true)
        
         
    }
    
    
        
    def obtenirOF()  {
        def monId = params.monId
        println("obtenir of ok")
        println(monId)
        def monKanban = Kanban.get(monId)
        println("kanban recuperer ? " + monKanban.nomKanban)
        def mesOF = kanbanService.afficherOFKanban(monKanban)
        mesOF.each() {of -> 
            println("OF recuperes : " + of.phase.nom)
        }
        
       // render(template: '${request.contextPath}/activite/obtenirOF', model: 
            [mesOF : mesOF] 
    }
    
    def listeKanban() {
        def listeKanban = kanbanService.listeKanban()
        
        [kanbanInstanceList: listeKanban.reverse()]
    }
    
    
    
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def indicateur() {
        
    }
    
    
    // envoie data pour indicateur de 
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def chargePIC = {
        def pics = Pic.list()
        // hypothese nbannee = nb pic
              
        def picLists = []
        pics.each {pic ->
            def picList = new LinkedHashMap()
            picList.put("annee",pic.annee.toString())
            
            pic.picFamille.each() { maPicFamille ->
                 picList.put((maPicFamille.famille.nom.toString()),(maPicFamille.chargePlanifie()))
            }
             picLists << (picList)
        }
        
        [picInstanceList: picLists]
        render picLists as JSON
    }
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def listeFamille = {
        
        def fams = Famille.list()
        def famLists = []
        fams.each{ fam ->
            
            def famList = new LinkedHashMap()
            famList.put("Nom",fam.nom.toString())
            famLists << famList
        }
        
        [famInstanceList: famLists]
        render famLists as JSON
    }
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def barPIC = {
        def pics = Pic.list()
        // hypothese nbannee = nb pic
              
        def picLists = []
        pics.each {pic ->
            def picList = new LinkedHashMap()
            picList.put("annee",pic.annee.toString())
            def charge = 0
            pic.picFamille.each() { maPicFamille ->
                 charge += (maPicFamille.chargePlanifie())
            }
            picList.put("charge",charge)
             picLists << (picList)
        }
        
        [picInstanceList: picLists]
        render picLists as JSON
    }
    
    
    
    // envoie data pour indicateur de 
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def deltaCharge = {
        
        def query2 = Famille.whereAny {
            travaille == true
        }
        def fams = query2.list()
        fams.each() {fam->
            def query3 = Kanban.whereAny {
            famille == fam
        }
        def kanbanList = query3.list()
        def chargesLists = []
            for(Integer i = 1; i<13;i++) {
                
                def chargesList = new LinkedHashMap()
                chargesList.put("mois",i)
                def dateDebut = imputationService.premierJourMois(2014, i)
                def dateFin = imputationService.dernierJourMois(2014, i)
                
            def maCharge = 0
            maCharge += (indicateurService.chargePlanifieeMois(dateDebut,dateFin, kanbanList))
            def maCapa = 0
            maCapa += (indicateurService.capacite(dateDebut, dateFin))
            def charge = maCapa - maCharge
            
            chargesList.put("charge", Math.round(charge * 10) / 10)
            
                
                chargesLists << (chargesList)
                
        }
        
        [chargesInstanceList: chargesLists]
        render chargesLists as JSON
    }}
    
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def chargeCapaFamille = {
        
        def query2 = Famille.whereAny {
            travaille == true
        }
        def fams = query2.list()
        def famLists = []
            for(Integer i = 1; i<13;i++) {
                def chargesList = new LinkedHashMap()
                chargesList.put("mois",i)
                def fams2 = fams
                def dateDebut = imputationService.premierJourMois(2014, i)
                def dateFin = imputationService.dernierJourMois(2014, i)
                
                def delta = indicateurService.capacite(dateDebut, dateFin) 
                
                chargesList.put("capacite" , Math.round(delta * 10) / 10)
                fams2.each{ fam ->
            
             def query = Kanban.whereAny {
                famille == fam
            }
            def kanbanList = query.list() // cherche juste la famille
                
            def maCharge = indicateurService.chargePlanifieeMois(dateDebut,dateFin, kanbanList)
            
                chargesList.put(fam.nom.toString(),Math.round(maCharge * 10) / 10)
                
                
        }
        
                famLists << (chargesList)
      
        }
        
        [famInstanceList: famLists]
        render famLists as JSON
    }
    
}
