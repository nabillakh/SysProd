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
            
            monKanban.save(flush : true)
        }
        else {
            
            def monId2 = Long.parseLong(monId)
            
            monKanban = Kanban.get(monId2)
            
            monKanban.setNomKanban(nomKanban)
            
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
        
        def monKanban = Kanban.get(monId)
        
        def mesOF = kanbanService.afficherOFKanban(monKanban)
        mesOF.each() {of -> 
            
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
                 picList.put((maPicFamille.ordo.nom.toString()),(maPicFamille.getChargePlanifie()))
            }
             picLists << (picList)
        }
        
        [picInstanceList: picLists]
        render picLists as JSON
    }
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def listeFamille = {
        
        def query2 = Famille.whereAny {
            travaille == true
        }
        def fams = query2.list()
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
    def listeFamillePIC = {
        
        def fams = Ordonnancement.list()
        def famLists = []
        fams.each{ fam ->
            famLists.add(fam.nom.toString())
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
        
        def chargesList = []
        
        def query2 = Famille.whereAny {
            travaille == true
        }
        def fams = query2.list()
        for(Integer i = 1; i<13;i++) {
            
            def maCharge = 0
            def chargeLists = new LinkedHashMap()
            chargeLists.put("mois",i)
            def dateDebut = imputationService.premierJourMois(2014, i)
            def dateFin = imputationService.dernierJourMois(2014, i)
            
            def maCapa = (indicateurService.capacite(dateDebut, dateFin))
            
        fams.each() {fam->
            def query3 = Kanban.whereAny {
            famille == fam
        }
        def kanbanList = query3.list()               
                
            maCharge += (indicateurService.chargePlanifieeMois(dateDebut,dateFin, kanbanList))
            
                
        }
        
            def charge = maCapa - maCharge
            chargeLists.put("charge", Math.round(charge * 10) / 10)
            chargesList << (chargeLists)
        }
        
        [chargesInstanceList: chargesList]
        render chargesList as JSON
    }
    
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def chargeCapaFamille = {
        def kanbans = Kanban.list()
        def effectifs = Effectif.list()
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
                    def kanbanList = new ArrayList<Kanban>()
                    def query = Kanban.whereAny {
                        famille == fam
                    }
                    
                kanbanList = query.list() // cherche juste la famille
                
                def maCharge = indicateurService.chargePlanifieeMois(dateDebut,dateFin, kanbanList)
                println(maCharge)
                chargesList.put(fam.nom.toString(),Math.round(maCharge * 10) / 10)
                
                
        }
        
                famLists << (chargesList)
      
        }
        
        [famInstanceList: famLists]
        render famLists as JSON
    }
    
    
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def vadMensuelle = {
                
        def famLists = []
            for(Integer i = 1; i<13;i++) {
                def chargesList = new LinkedHashMap()
                chargesList.put("mois",i)
                def dateDebut = imputationService.premierJourMois(2014, i)
                def dateFin = imputationService.dernierJourMois(2014, i)
                
                def delta = indicateurService.capacite(dateDebut, dateFin) 
                
                def vad = indicateurService.vad(dateDebut, dateFin) 
                
                def maVad = (Float)(vad / delta)
                
                def txVad = (Math.round(maVad * 1000) / 10 )
            
                chargesList.put("vadPlan" ,txVad)
                
        
                famLists << (chargesList)
      
        }
        
        [famInstanceList: famLists]
        render famLists as JSON
    }
    
    
    
    
    
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def chargeCapaFamilleEffectif = {
        def idEffectif = params.monId        
        def monId = Long.parseLong(idEffectif)
        def effectif = Effectif.get(monId)
        def query2 = Famille.whereAny {
            travaille == true
        }
        
        def fams = query2.list()
        def famLists = []
            for(Integer i = 1; i<13;i++) {
                def chargesList = new LinkedHashMap()
                chargesList.put("mois",i)
                def dateDebut = imputationService.premierJourMois(2014, i)
                
                def dateFin = imputationService.dernierJourMois(2014, i)               
                def capacite = indicateurService.capaciteEffectif(dateDebut, dateFin, effectif)
                chargesList.put("capacite" , Math.round(capacite * 10) / 10)
                fams.each{ fam ->
                    def maCharge = indicateurService.chargePlanifieeEffectif(dateDebut,dateFin, effectif, fam)
                    chargesList.put(fam.nom.toString(),Math.round(maCharge * 10) / 10)
                
        }
        
                famLists << (chargesList)
      
        }
        
        [famInstanceList: famLists]
        render famLists as JSON
    }
    
    
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def chargeCapaFamilleEquipe = {
        def idEquipe = params.monId        
        def monId = Long.parseLong(idEquipe)
        def equipe = Equipe.get(monId)
        def query2 = Famille.whereAny {
            travaille == true
        }
        
        def fams = query2.list()
        def famLists = []
            for(Integer i = 1; i<13;i++) {
                def chargesList = new LinkedHashMap()
                chargesList.put("mois",i)
                def dateDebut = imputationService.premierJourMois(2014, i)
                
                def dateFin = imputationService.dernierJourMois(2014, i)               
                def capacite = 0
                equipe.effectifs.each() {effectif ->
                    capacite += indicateurService.capaciteEffectif(dateDebut, dateFin, effectif)
                }
                chargesList.put("capacite" , Math.round(capacite * 10) / 10)
                fams.each{ fam ->      
                    def maCharge = 0
                    equipe.effectifs.each() {effectif ->
                        maCharge += indicateurService.chargePlanifieeEffectif(dateDebut,dateFin, effectif, fam)
                    }
                    chargesList.put(fam.nom.toString(),Math.round(maCharge * 10) / 10)
                
        }
        
                famLists << (chargesList)
      
        }
        
        [famInstanceList: famLists]
        render famLists as JSON
    }
    
    
    
    
    // envoie data pour indicateur de 
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def deltaChargeEffectif = {
        
        def idEffectif = params.monId        
        def monId = Long.parseLong(idEffectif)
        def effectif = Effectif.get(monId)
        def chargesList = []
        def query2 = Famille.whereAny {
            travaille == true
        }
        def fams = query2.list()
        for(Integer i = 1; i<13;i++) {
            
            def maCharge = 0
            def chargeLists = new LinkedHashMap()
            chargeLists.put("mois",i)
            def dateDebut = imputationService.premierJourMois(2014, i)
            def dateFin = imputationService.dernierJourMois(2014, i)
            
            def maCapa = indicateurService.capaciteEffectif(dateDebut, dateFin, effectif)
            
        fams.each() {fam->
                    maCharge += indicateurService.chargePlanifieeEffectif(dateDebut,dateFin, effectif, fam)            
            }
        
           def charge = maCapa - maCharge
            chargeLists.put("charge", Math.round(charge*100)/100)
            chargesList << (chargeLists)
        }
        
        [chargesInstanceList: chargesList]
        render chargesList as JSON
    }
    
                
          
    
    // envoie data pour indicateur de 
    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def deltaChargeEquipe = {
        
        def idEffectif = params.monId        
        def monId = Long.parseLong(idEffectif)
        def equipe = Equipe.get(monId)
        def chargesList = []
        def query2 = Famille.whereAny {
            travaille == true
        }
        def fams = query2.list()
        for(Integer i = 1; i<13;i++) {
            
            def maCharge = 0
            def chargeLists = new LinkedHashMap()
            chargeLists.put("mois",i)
            def dateDebut = imputationService.premierJourMois(2014, i)
            def dateFin = imputationService.dernierJourMois(2014, i)
            
            def maCapa = 0
            equipe.effectifs.each() {effectif ->
                maCapa += indicateurService.capaciteEffectif(dateDebut, dateFin, effectif)
            }
            
        fams.each() {fam->
            equipe.effectifs.each() {effectif ->
                maCharge += indicateurService.chargePlanifieeEffectif(dateDebut,dateFin, effectif, fam)  
            }   
        }
        
           def charge = maCapa - maCharge
            chargeLists.put("charge", Math.round(charge*100)/100)
            chargesList << (chargeLists)
        }
        
        [chargesInstanceList: chargesList]
        render chargesList as JSON
    }
    
                
                
    
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def donutChargeEffectif = {
        println("ok pour donut)")
        def idEffectif = params.monId        
        def monId = Long.parseLong(idEffectif)
        def effectif = Effectif.get(monId)
        def query2 = Famille.whereAny {
            travaille == true
        }
        
        def fams = query2.list()
        def famLists = []
        def dateDebut = imputationService.premierJourMois(2014, 1)
        def dateFin = imputationService.dernierJourMois(2014, 12)
        def capacite = indicateurService.capaciteEffectif(dateDebut, dateFin, effectif)
        def chargesList= new LinkedHashMap()
                    
        // chargesList.put("capacite" , Math.round(capacite * 10) / 10)
        fams.each{ fam ->
            chargesList = new LinkedHashMap()
            def maCharge = indicateurService.chargePlanifieeEffectif(dateDebut,dateFin, effectif, fam)
            if(maCharge>0){
                chargesList.put("label",fam.nom.toString())
                chargesList.put("value",Math.round(maCharge * 10) / 10)
                famLists << (chargesList)
                capacite += -maCharge
            }
        }
        
                    
          chargesList = new LinkedHashMap()
                chargesList.put("label","Libre")
                chargesList.put("value",Math.round(capacite * 10) / 10)            
            
           famLists << (chargesList)
        
                
      
        
        
        [famInstanceList: famLists]
        render famLists as JSON
    }       
                
    
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def donutChargeEquipe = {
        println("ok pour donut)")
        def idEffectif = params.monId        
        def monId = Long.parseLong(idEffectif)
        def equipe = Equipe.get(monId)
        def query2 = Famille.whereAny {
            travaille == true
        }
        
        def fams = query2.list()
        def famLists = []
        def dateDebut = imputationService.premierJourMois(2014, 1)
        def dateFin = imputationService.dernierJourMois(2014, 12)       
                def capacite = 0
                equipe.effectifs.each() {effectif ->
                    capacite += indicateurService.capaciteEffectif(dateDebut, dateFin, effectif)
                }
        def chargesList= new LinkedHashMap()
                    
        // chargesList.put("capacite" , Math.round(capacite * 10) / 10)
        fams.each{ fam ->
            chargesList = new LinkedHashMap()         
                def maCharge = 0
                equipe.effectifs.each() {effectif ->
                    maCharge += indicateurService.chargePlanifieeEffectif(dateDebut,dateFin, effectif, fam)
                    println("la charge est : " + maCharge)
                }
            if(maCharge>0){
                chargesList.put("label",fam.nom.toString())
                chargesList.put("value",Math.round(maCharge * 10) / 10)
                famLists << (chargesList)
                capacite += -maCharge
            }
        }
        
                    
          chargesList = new LinkedHashMap()
                chargesList.put("label","Libre")
                chargesList.put("value",Math.round(capacite * 10) / 10)            
            
           famLists << (chargesList)
        
                      
        
        [famInstanceList: famLists]
        render famLists as JSON
    }
    
    
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def donutCompetenceEffectif = {
        
        def idEffectif = params.monId        
        def monId = Long.parseLong(idEffectif)
        def effectif = Effectif.get(monId)
        def mesOfs = []
        def mesOf = kanbanService.mesOF(effectif)
        mesOf.each() { off ->
            if(off.kanban.famille.operationnel) {
                mesOfs.add(off)
            }
        }
        println("liste des ofs " + mesOfs)
        def competences = []
        mesOfs.each() {monOf ->
            competences.add(monOf.phase.competence)
        }
        competences.unique()
        def famLists = []
        def dateDebut = imputationService.premierJourMois(2014, 1)
        def dateFin = imputationService.dernierJourMois(2014, 12)
        
        def chargesList= new LinkedHashMap()
        
        
            def maCharge2 = 0
            mesOfs.each() {of->
                maCharge2 += indicateurService.chargePlanifieeEffectifOf(dateDebut,dateFin, of)
            }
        
                    
        // chargesList.put("capacite" , Math.round(capacite * 10) / 10)
        competences.each{ fam ->
            chargesList = new LinkedHashMap()
            def maCharge = 0
            mesOfs.each() {of->
                if(of.phase.competence == fam) {
                        maCharge += indicateurService.chargePlanifieeEffectifOf(dateDebut,dateFin, of)
                    }
            }
            if(maCharge>0){
                chargesList.put("label",fam.nom.toString())
                chargesList.put("value",Math.round((maCharge/maCharge2)*100*100)/100)
                famLists << (chargesList)
            }
        }
                
        [famInstanceList: famLists] 
        render famLists as JSON
    
    }
    // envoie la liste de famille pour parising dans le graphe 1
    @Secured(['IS_AUTHENTICATED_REMEMBERED']) 
    def donutCompetenceEquipe = {
        
        def idEffectif = params.monId        
        def monId = Long.parseLong(idEffectif)
        def equipe = Equipe.get(monId)
        def mesOfs = []
        
        def dateDebut = imputationService.premierJourMois(2014, 1)
        def dateFin = imputationService.dernierJourMois(2014, 12)
        def maCharge2 = 0
        equipe.effectifs.each() { effectif ->
            kanbanService.mesOF(effectif).each() {of ->
                if(of.kanban.famille.operationnel) {
                mesOfs.add(of)
                // mulitplier par le nombre deffectif de lequipe dans l'of
                maCharge2 += indicateurService.chargePlanifieeEffectifOf(dateDebut,dateFin, of) }
            }
        }
        
        println("liste des ofs " + mesOfs)
        def competences = []
        mesOfs.each() {monOf ->
            competences.add(monOf.phase.competence)
        }
        competences.unique()
        def famLists = []
        
        def chargesList= new LinkedHashMap()
        
                    
        // chargesList.put("capacite" , Math.round(capacite * 10) / 10)
        competences.each{ fam ->
            chargesList = new LinkedHashMap()
            def maCharge = 0
            mesOfs.each() {of->
                if(of.phase.competence == fam) {
                    maCharge += indicateurService.chargePlanifieeEffectifOf(dateDebut,dateFin, of)
                }
            }
            if(maCharge>0){
                println(fam)
                chargesList.put("label",fam.nom.toString())
                chargesList.put("value",Math.round((maCharge/maCharge2)*100*100)/100)
                famLists << (chargesList)
            }
        } 
                
        [famInstanceList: famLists]
        render famLists as JSON
    }
    
}
