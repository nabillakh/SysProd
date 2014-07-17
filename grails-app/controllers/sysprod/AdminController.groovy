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

class AdminController {
    def excelImportService
    def kanbanService
    
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
            new Effectif(emploi : comp.emploi, username: comp.username, password: comp.password, nom : comp.nom, prenom : comp.prenom, equipe : monEquipe).save()
        }
        familleList.each() {Map comp -> 
            new Famille(nom : comp.nom, travaille : comp.travaille).save()
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
            def phase = new Phase(valeurAjoutee : comp.valeurAjoutee, nom : comp.nom,ordre:comp.ordre, competence:maCompetence, cleRepartition : (comp.cleRepartition)).save()
            println(monOrdo)
            println(phase)
            monOrdo.addToPhases(phase) 
            phase.save(failOnError: true)
            monOrdo.save()
        }
        kanbanList.each() {Map comp ->   
            def monOrdo = Ordonnancement.findByNom(comp.ordo)
            def monClient = Client.findByNom(comp.Client)
            def maFamille = Famille.findByNom(comp.famille)
            def chefProjet = Effectif.findByUsername(comp.chefProjet)
            def dateLancement = comp.dateLancement.toDateTimeAtStartOfDay().toDate()
            def dateFinPlanifie = comp.dateFinPlanifie.toDateTimeAtStartOfDay().toDate()
            def monKanban = new Kanban(client : monClient, ordo : monOrdo, chefProjet : chefProjet , chargePlanifiee : comp.chargePlanifie , fini: comp.fini, nomKanban : comp.nomKanban , description : comp.description, dateLancement : dateLancement, famille : maFamille, dateFinPlanifie : dateFinPlanifie)
        
            monKanban.save(failOnError: true)
        }
                
      redirect(action:"services")  
 }
 
    def services = {
        println("lancement des services")
        def kanbans = Kanban.list()
        kanbans.each() { kanban ->
            kanbanService.requeteCreation(kanban)
        }
      redirect(view:"index")  
    }
}
