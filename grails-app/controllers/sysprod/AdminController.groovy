/***********************************************************************
 * Module:  AdminCotroller
 * Author:  Nabil
 * Purpose: Permettre les imports excel
 ***********************************************************************/



package sysprod

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.grails.plugins.excelimport.*
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import application.RH.*
import application.PP.*
import application.CRM.*
import java.util.Random
import application.communication.*
import org.joda.time.DateTime

class AdminController {
    def excelImportService
    def kanbanService
    def effectifService
    def eventService
    
    def index() {
    }
    
    def upload = {
        
     Map CONFIG_COMPETENCE_COLUMN_MAP = [
     sheet:'Competence',
     startRow: 1,
     columnMap:  [
      //Col, Map-Key
      'A':'id',
      'B':'nom',
     ]
     
    ]  
     Map CONFIG_EQUIPE_COLUMN_MAP = [
     sheet:'Equipe',
     startRow: 1,
     columnMap:  [
      //Col, Map-Key
      'A':'id',
      'B':'nom',
     ]
    ]
    
     Map CONFIG_EFFECTIF_COLUMN_MAP = [
     sheet:'Effectif',
     startRow: 1,
     columnMap:  [
      //Col, Map-Key
      'A':'id',
      'B':'username',
      'C':'password',
      'D':'nom',
      'E':'prenom',
      'F':'equipe',
      'G':'emploi',
      'H':'competence',
     ]
    ]
    
     Map CONFIG_FAMILLE_COLUMN_MAP = [
     sheet:'Famille',
     startRow: 1,
     columnMap:  [
      //Col, Map-Key
      'A':'id',
      'B':'nom',
      'C':'travaille',
      'D':'operationnel',
     ]
    ]
     Map CONFIG_CLIENT_COLUMN_MAP = [
     sheet:'Client',
     startRow: 1,
     columnMap:  [
      //Col, Map-Key
      'A':'nom',
     ]
    ]
    
     Map CONFIG_ORDO_COLUMN_MAP = [
     sheet:'Ordo',
     startRow: 1,
     columnMap:  [
      //Col, Map-Key
      'A':'id',
      'B':'nom',
      'C':'chargeStandard',
      'D':'famille',
     ]
    ]
    
     Map CONFIG_PHASE_COLUMN_MAP = [
     sheet:'Phase',
     startRow: 1,
     columnMap:  [
      //Col, Map-Key
      'A':'id',
      'B':'nom',
      'C':'ordre',
      'D':'cleRepartition',
      'E':'ordo',
      'F':'competence',
      'G':'valeurAjoutee',
     ]
    ]
     Map CONFIG_KANBAN_COLUMN_MAP = [
     sheet:'Kanban',
     startRow: 1,
     columnMap:  [
      //Col, Map-Key
      'A':'id',
      'B':'nomKanban',
      'C':'description',
      'D':'dateLancement',
      'E':'dateFinPlanifie',
      'F':'chargePlanifie',
      'G':'ordo',
      'H':'famille',
      'I':'chefProjet',
      'J':'fini',
      'K':'Client',
      'L':'Pareffectif',
     ]
    ]
    
        
     Map CONFIG_ABSENCE_COLUMN_MAP = [
     sheet:'absences',
     startRow: 1,
     columnMap:  [
      //Col, Map-Key
      'A':'id',
      'B':'nomKanban',
      'C':'description',
      'D':'dateLancement',
      'E':'dateFinPlanifie',
      'F':'chargePlanifie',
      'G':'ordo',
      'H':'famille',
      'I':'chefProjet',
      'J':'fini',
      'K':'Client',
      'L':'Pareffectif',
     ]
    ]
    
        MultipartHttpServletRequest mpr = (MultipartHttpServletRequest)request;
        CommonsMultipartFile file = (CommonsMultipartFile) mpr.getFile("file");
        
        Workbook workbook = WorkbookFactory.create(file.inputStream)
        
        def competenceList = excelImportService.columns(workbook, CONFIG_COMPETENCE_COLUMN_MAP)
        def equipeList = excelImportService.columns(workbook, CONFIG_EQUIPE_COLUMN_MAP)
        def effectifList = excelImportService.columns(workbook, CONFIG_EFFECTIF_COLUMN_MAP)
        def familleList = excelImportService.columns(workbook, CONFIG_FAMILLE_COLUMN_MAP)
        def ordoList = excelImportService.columns(workbook, CONFIG_ORDO_COLUMN_MAP)
        def phaseList = excelImportService.columns(workbook, CONFIG_PHASE_COLUMN_MAP)
        def kanbanList = excelImportService.columns(workbook, CONFIG_KANBAN_COLUMN_MAP)
        def absenceList = excelImportService.columns(workbook, CONFIG_ABSENCE_COLUMN_MAP)
        def clientList = excelImportService.columns(workbook, CONFIG_CLIENT_COLUMN_MAP)
        
        
        competenceList.each() {Map comp -> 
            new Competence(nom : comp.nom).save()
        }
        equipeList.each() {Map comp -> 
            new Equipe(nom : comp.nom).save()
        }
        clientList.each() {Map comp -> 
            new Client(nom : comp.nom).save()
        }
        effectifList.each() {Map comp -> 
            def monEquipe = Equipe.findByNom(comp.equipe)
            if(!Effectif.findByNom(comp.nom)) {
                def effectif = new Effectif(emploi : comp.emploi, username: comp.username, password: comp.password, nom : comp.nom, prenom : comp.prenom, equipe : monEquipe).save()
            }
            
        }
        
        
        competenceList.each() {Map comp -> 
            new Competence(nom : comp.nom).save()
        }
            
        effectifList.each() {Map comp2 -> 
            def effectif = Effectif.findByNom(comp2.nom)
            String delims = "[/]";
            String[] competences = comp2.competence.split(delims);
            competences.each() {compe ->    
                
                def competence = Competence.findByNom(compe)
                def ce = new CompetenceEffectif(competence : competence, effectif: effectif)
                ce.save(flush : true)
            }
                    
        }
        
        
        familleList.each() {Map comp -> 
            new Famille(nom : comp.nom, travaille : comp.travaille, operationnel : comp.operationnel).save()
        }
        ordoList.each() {Map comp -> 
            def maFamille = Famille.findByNom(comp.famille)
            def ordo = new Ordonnancement(nom : comp.nom, chargeStandard : (comp.chargeStandard), famille : maFamille).save()
            maFamille.addToOrdo(ordo)
            maFamille.save()
        }
        phaseList.each() {Map comp -> 
            def maCompetence = Competence.findByNom(comp.competence)      
            def monOrdo = Ordonnancement.findByNom(comp.ordo)
            def phase = new Phase(monOrdo : monOrdo, valeurAjoutee : comp.valeurAjoutee, nom : comp.nom,ordre:comp.ordre, competence:maCompetence, cleRepartition : (comp.cleRepartition)).save()
            
            phase.save(failOnError: true)
            monOrdo.addToPhases(phase)
            monOrdo.save()
        }
        kanbanList.each() {Map comp ->   
            def monOrdo = Ordonnancement.findByNom(comp.ordo)
            def monClient = Client.findByNom(comp.Client)
            def maFamille = Famille.findByNom(comp.famille)
            def chefProjet = Effectif.findByUsername(comp.chefProjet)
            
            def dateLancement = comp.dateLancement.toDateTimeAtStartOfDay().toDate()
            def dateFinPlanifie = comp.dateFinPlanifie.toDateTimeAtStartOfDay().toDate()
                def monKanban = new Kanban()
            if(monClient) {
                monKanban = new Kanban(client : monClient, ordo : monOrdo, chefProjet : chefProjet , chargePlanifiee : comp.chargePlanifie , fini: comp.fini, nomKanban : comp.nomKanban , description : comp.description, dateLancement : dateLancement, famille : maFamille, dateFinPlanifie : dateFinPlanifie)
            }
            else {
                monKanban = new Kanban(ordo : monOrdo, chefProjet : chefProjet , chargePlanifiee : comp.chargePlanifie , fini: comp.fini, nomKanban : comp.nomKanban , description : comp.description, dateLancement : dateLancement, famille : maFamille, dateFinPlanifie : dateFinPlanifie)
                
            }
            if(maFamille.operationnel) {
                monKanban.save(failOnError: true)
            }
            else {
                def eff = Effectif.list()
                eff.each() { e ->
                    def unKanban = new Kanban(ordo : monOrdo, chefProjet : e , chargePlanifiee : comp.chargePlanifie , fini: comp.fini, nomKanban : comp.nomKanban , description : comp.description, dateLancement : dateLancement, famille : maFamille, dateFinPlanifie : dateFinPlanifie)
                    unKanban.save()
                }
            }
        }
                
      redirect(action:"services")  
 }
 
    def services = {
        println("lancement des services")
        def kanbans = Kanban.list()
        kanbans.each() { kanban ->
          kanbanService.requeteCreation(kanban)
        }
        
        def ofs = OF.list()        
                
        ofs.each() {of->
            if(of.kanban.famille.operationnel) {
            Random randomizer = new Random();
            def effectifs = of.phase.getAffectables()
            def list = new ArrayList<Effectif>();
            effectifs.each() {effe ->
                list.add(effe)
            }
            String eff = randomizer.nextInt(list.size());
            println("random : " + eff)
            Effectif effectif = list.get(Integer.parseInt(eff))
            println("effectif : " + effectif)
            def competenceEffectif =  effectifService.maCompetenceEffectif(of.phase.competence, effectif)
            def nvOfEff = new OFEffectif(effectif : effectif, of : of, competence : of.phase.competence)
            nvOfEff.save()
            of.addToAffectes(nvOfEff)
            of.save()}
        else {
            def nvOfEff = new OFEffectif(effectif : of.kanban.chefProjet, of : of)
            nvOfEff.save()
            of.addToAffectes(nvOfEff)
            of.save()}
        }       
        
      redirect(action:"event")  
    }
    
    def event = {
        
        def ofs = OF.list()        
               println(ofs) 
        ofs.each() {of->
            DateTime debut = new DateTime(of.dateDebutPlanifie)
            DateTime fin = new DateTime(of.dateFinPlanifie)
            def jours = new ArrayList<Integer>();
            for(int i=1;i<Math.round(of.chargePlanifiee * 2 + 1);i++){
                jours.add(i)
            }
            
            Random randomizer = new Random();
            def eff = (randomizer.nextInt(jours.size()));
            
            for(int i=1;i<eff + 1;i++){
                def debut2 = debut.plusDays(i)
                def start = debut2.plusHours(9)
                def startTime = start.toDate()
                def endTime = start.plusHours(7).toDate()
            println("debut : " + startTime)
            println("debut : " + endTime)
            Event eventInstance = new Event() 
            eventInstance.startTime = startTime
            eventInstance.endTime = endTime
            eventInstance.title = of.kanban.nomKanban + " : " + of.phase.nom
            eventInstance.save(failOnError: true, flush : true)
            println(eventInstance)
            of.affectes.each() { aff ->
                def eventEffectif = eventService.organiserEventEffectif(aff.effectif,eventInstance)
                eventService.imputation(eventEffectif, of)                
            }
            
            }
            
        }
                
      redirect(action:"eventServices")  
    }
    
    def eventServices = {
        def imputations = Imputation.list()
        imputations.each() { imputation -> 
            def date = new Date()
            Calendar calDate = Calendar.getInstance();
            calDate.setTime(date);
            
            Calendar calMax = Calendar.getInstance();
            calMax.setTime(imputation.eventEffectif.event.startTime); 
            def jours = new ArrayList<Float>();
            for(int i=1;i<40;i++) {
                jours.add(1-(22-i)/100)
            }
            
            Random randomizer = new Random();
            def eff = (randomizer.nextInt(jours.size()));
            
        
        if((calDate.compareTo(calMax)>0)) {
            println("imputations")
            println(date)
            println(imputation.eventEffectif.event.startTime)
            println(imputation.eventEffectif.event.getDureeHeures())
            eventService.simputer(imputation, (Float)(jours.get(eff) * imputation.eventEffectif.event.getDureeHeures()))
        }          
            
        }
        
        
      redirect(view:"index")
    }
}
