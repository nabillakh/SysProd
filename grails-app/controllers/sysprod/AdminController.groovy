package sysprod

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.grails.plugins.excelimport.*
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import application.RH.*
import application.PP.*

class AdminController {
    def excelImportService
    
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
     ]
    ]
    
     Map CONFIG_FAMILLE_COLUMN_MAP = [
     sheet:'Famille',
     startRow: 1,
     columnMap:  [
      //Col, Map-Key
      'A':'id',
      'B':'nom',
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
      'E':'ordo',
      'F':'competence',
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
        
        
        competenceList.each() {Map comp -> 
            new Competence(nom : comp.nom).save()
        }
        equipeList.each() {Map comp -> 
            new Equipe(nom : comp.nom).save()
        }
        effectifList.each() {Map comp -> 
            def monEquipe = Equipe.findByNom(comp.equipe)
            new Effectif(username: comp.username, password: comp.password, nom : comp.nom, prenom : comp.prenom, equipe : monEquipe).save()
        }
        familleList.each() {Map comp -> 
            new Famille(nom : comp.nom).save()
        }
        ordoList.each() {Map comp -> 
            def maFamille = Famille.findByNom(comp.famille)
            new Ordonnancement(nom : comp.nom, chargeStandard : comp.chargeStandard, famille : maFamille).save()
        }
        phaseList.each() {Map comp -> 
            def maCompetence = Competence.findByNom(comp.competence)      
            def monOrdo = Ordonnancement.findByNom(comp.ordo)
            def phase = new Phase(nom : comp.nom,ordre:comp.ordre, competence:maCompetence, cleRepartition :comp.cleRepartition)
            monOrdo.addToPhases(phase)
            phase.save(failOnError: true)
        }
        
        
 }
}
