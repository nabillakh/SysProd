package application.PP


import grails.validation.ValidationException
import org.springframework.transaction.annotation.Transactional
import application.PP.*
import application.RH.*
import application.communication.EventService
import application.communication.*
import org.joda.time.DateTime 


class KanbanService {

    def springSecurityService
    
    
    
   //--- pour la taglib------------- 
   
     private Kanban[] afficherKanban() {
       try { def query = Kanban.whereAny {                
           
           }
        def leskanban = query.list()
        return leskanban
        }
        catch (NullPointerException n){
            return null
        }
    }

    //--- pour la taglib'administration------------- 
   // mettre a jour les listes pour filtrer au niveau d'une entreprise
     private Kanban[] listeKanban() {
       def maListe = []
        // maListe = Kanban.list(sort: "dateLancement", order: "desc")
        maListe = Kanban.list()
        return maListe
    }
    
    private Kanban[] listeKanbanEffectif(Effectif effectifInstance) {
        
       def maListe = []
       
       def ofes = OFEffectif.findAll("from OFEffectif as b where b.effectif=?", [effectifInstance])
           ofes.each() { ofeff ->
           maListe.add(ofeff.of.kanban)
       }
        maListe.unique()
        return maListe
    }
    
     

           // liste des OF pour les event

    private OF[] mesOF(Effectif effectifInstance) {
        def lesOF = []         
       def ofes = OFEffectif.findAll("from OFEffectif as b where b.effectif=?", [effectifInstance])
       println(ofes)
        ofes.each() {ofe ->
            lesOF.add(ofe.of)            
        }
        return lesOF
    }
    
    
        //--- pour la taglib'administration------------- 
   // mettre a jour les listes pour filtrer au niveau d'une entreprise
     private Famille[] listeFamille() {
       def maListe = []
        maListe = Famille.list(sort: "nom", order: "desc")
        return maListe
    }
    
            //--- pour la taglib'administration------------- 
   // mettre a jour les listes pour filtrer au niveau d'une entreprise
     private Phase[] listePhase() {
       def maListe = []
        maListe = Phase.list(sort: "ordre", order: "desc")
        return maListe
    }
            //--- pour la taglib'administration------------- 
   // mettre a jour les listes pour filtrer au niveau d'une entreprise
     private Ordonnancement[] listeOrdo() {
       def maListe = []
        maListe = Ordonnancement.list()
        
        return maListe
    }
    
    //____________________________
    
    private Effectif[] listeEffectif() {
       def maListe = []
        maListe = Effectif.list(sort: "nom", order: "desc")
        return maListe
    }
    //__________________________
     private Competence[] listeCompetence() {
       def maListe = []
        maListe = Competence.list(sort: "nom", order: "desc")
        return maListe
    }
    //_________________________________
    private Droit[] listeDroit() {
       def maListe = []
        maListe = Droit.list(sort: "authority", order: "desc")
        return maListe
    }
    //_________________________________
    private Message[] listeMessage() {
       def maListe = []
        maListe = Message.list()
        return maListe
    }
   //---------------------
    
    
    // montre les phases auxquelles un kanban va passer
    @Transactional
    OF[] montrerOF(Kanban monKanban) {
        def ofs
        try{
            // requete SQL
            ofs = OF.findAll("from OF as b where b.kanban=?", [monKanban])
            ofs.sort{a,b-> a.phase.ordre<=>b.phase.ordre}
        }
        catch (NullPointerException n) {
            
        }
        return ofs
    }        
    // montre les phases auxquelles un kanban va passer dans l'ordo initial
    @Transactional
    Phase[] montrerPhasesInitiales(Kanban kanban) {
        def ordo = kanban.getOrdo()
                println("recherche de l'ordo du kanban : "+ordo.nom)
        try{
            println("dans try")
             return ordo.getPhases()
           // return Phase.findAll("from Phase as b where b.monOrdo=? order by b.ordre", [ordo])
            println("liste de phases ok")
            }
        catch (NullPointerException n) {
            println("nullpointer")
            return null
        }
    }        
    // creation d'of automatique apres chaque saisie de kanban 
    @Transactional
    void requeteCreation(Kanban monKanban){
        
        try {
            def famille = monKanban.getFamille()
            // monKanban.setOrdo(famille.getOrdo())
            def ofs = OF.findAll("from OF as b where b.kanban=?", [monKanban])
            if(!ofs)  {
                montrerPhasesInitiales(monKanban).each() { maPhase ->
                    def of = new OF(phase : maPhase, kanban : monKanban, ordre : maPhase.ordre, fini : false)
                    chargeInitialeOF(of)
                    
                    if(maPhase.ordre == 1) {
                        monKanban.phaseActuelle = maPhase
                    }
                    
                    of.save()
                }
            ordonnancementOF(monKanban)
            }
            else {
            }
        }
        catch(ValidationException e){
            System.out.println("ofs non crees")
        }
    }
    
    // permet de préordonnancer les of et de les étaler dans le temps
    void ordonnancementOF(Kanban kanban) {
        
        def ofs = OF.findAll("from OF as b where b.kanban=?", [kanban])
        Date dateFin = kanban.getDateFinPlanifie()
        Date dateDeb = kanban.getDateLancement()
        
        def delta = (dateFin.getTime() - dateDeb.getTime())/(1000*60*60*24)
            println(delta)
        def d = 0
        
        def charge = 0
        ofs.each() {of ->
            charge += of.chargePlanifiee
        }
            println(charge)
        
        ofs.each() { of ->
            
            DateTime maDate = new DateTime(dateDeb)
            def dateDebut = maDate.plusDays((int)Math.round(d))
            d += ((of.chargePlanifiee * delta)/charge)   
            DateTime maDate2 = new DateTime(dateDeb)         
            def jours = Math.round(d)            
            maDate2 = maDate2.plusDays((int)jours)
            
            of.setDateDebutPlanifie(dateDebut.toDate())
            of.setDateFinPlanifie(maDate2.toDate())
            of.save()
        }
        
        
    }


    
    // permet de charger les OF au debut
    @Transactional
    void chargeInitialeOF(OF of) {
        try{
            float maCharge = ((of.getKanban().getChargePlanifiee()) * (of.getPhase().getCleRepartition()))
            of.setChargePlanifiee(maCharge)
        }
        catch(NullPointerException n ) {
            
        }
    }
    
    @Transactional
    Message[] afficherCRKanban(Kanban monKanban){
        println("dans kanban service")
        try{
            // requete SQL
            return Message.findAll("from Message as b where b.kanban=?", [monKanban])
        }
        catch (NullPointerException n) {
            return null
        }
    }
    
    // permet de charger la charge d'une famille en requetant les kanbans associés
    // mettre periode temporelle
    private Float chargeFamille(Famille famille) {
        def listeCharge = []
        listeCharge = Kanban.findAll("from Kanban as b where b.famille=?", [famille])
        
    }
    // permet de charger la charge d'un kanban en requetant les kanbans associés
    // mettre periode temporelle
    private Float chargeKanbanPlanifie(Kanban kanban) {
        def listeCharge = []
        listeCharge = OF.findAll("from OF as b where b.kanban=?", [kanban])
        def charge = 0
        listeCharge.each() { monOF ->
            charge += monOF.charge
        }
        return charge
    }
    //
    //// permet de charger la charge realise d'un OF en requetant les imputations associées
    // mettre periode temporelle
    private Float chargeOFRealise(OF of) {
        def listeCharge = []
        listeCharge = Imputation.findAll("from Imputation as b where b.of=?", [of])
        def charge = 0
        listeCharge.each() { monImputation ->
            // test si l'imput est déclarée comme realisee
            if(monImputation.realise) {
                charge += monImputation.eventEffectif.event.durationMinutes /60 / 8
            }
        }
        return charge
    }   
    
    // permet d'avoir la charge realisee par kanban
    
    private Float chargeKanbanRealise(Kanban kanban) {
        def maCharge = 0
        kanban.of.each() {of ->
               maCharge += chargeOFRealise(of)     
        }
        return maCharge
    }    
    // permet d'avoir la charge deja dans l'agenda par effectif
    
    private Float chargeEffectifRealise() {
        def maCharge = 0        
        
        def lesOF = [] 
        def aujourdhui = new Date()
        def per = Effectif.get(springSecurityService.principal.id)
        try {
            def query = OF.whereAny {
                affectes {per}
                dateFinPlanifie > aujourdhui + 1
            }
            lesOF = query.list()
        }
        
        catch (NullPointerException n){
        }
        
        lesOF.each() {of ->
            maCharge += chargeOFRealise(of)
        }
        return maCharge
    }   
    
    
    //   //// permet de charger la charge deja dans l'agenda
    private Float chargeOFAgenda(OF of) {
        def listeCharge = []
        listeCharge = Imputation.findAll("from Imputation as b where b.of=?", [of])
        def charge = 0
        listeCharge.each() { monImputation ->
            charge += monImputation.eventEffectif.event.durationMinutes / 60 / 8
        }
        return charge
    }   
    
    // permet d'avoir la charge deja dans l'agenda par kanban
    
    private Float chargeKanbanAgenda(Kanban kanban) {
        def maCharge = 0
        kanban.of.each() {of ->
               maCharge += chargeOFAgenda(of)     
        }
        return maCharge
    }   
    // permet d'avoir la charge deja dans l'agenda par effectif
    
    private Float chargeEffectifAgenda() {
        def maCharge = 0        
        
        def lesOF = [] 
        def aujourdhui = new Date()
        def per = Effectif.get(springSecurityService.principal.id)
        try {
            def query = OF.whereAny {
                affectes {per}
                dateFinPlanifie > aujourdhui + 1
            }
            lesOF = query.list()
        }
        
        catch (NullPointerException n){
        }
        
        lesOF.each() {of ->
            maCharge += chargeOFAgenda(of)
        }
        return maCharge
    }   
    
    
    //   rend les kanbans par famille
    // mettre par annee aussi
    private Kanban[] projetsFamille(Famille famille) {
        def listeProjets = []
        listeProjets = Kanban.findAll("from Kanban as b where b.famille=?", [famille])
        
        return listeProjets
    }
    
    
    
     OF[] afficherOFKanban(Kanban monKanban){
        try{
            // requete SQL
            return OF.findAll("from OF as b where b.kanban=?", [monKanban])
        }
        catch (NullPointerException n) {
            return null
        }
    }
}
