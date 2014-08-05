package application.pilotage


import grails.transaction.Transactional
import application.PP.*
import application.RH.*

@Transactional
class IndicateurService {

    def imputationService
    def kanbanService
    
    def Date[] listeDate(Date deb, Date fin) {
        
            Calendar calDeb = Calendar.getInstance();
            Calendar calFin = Calendar.getInstance();
            calDeb.setTime(deb);
            calFin.setTime(fin);
            
            calFin.add(Calendar.DATE,1)  
        
        def mesDate = []
        
        def delta = (fin.getTime() - deb.getTime())/(1000*60*60*24)
        
        
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(deb)
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date jour = cal.getTime()
        mesDate.add(jour)
        
        
        
        cal2.setTime(jour)
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
                
        
        cal2.add(Calendar.DATE,1)
        
        while((cal2.compareTo(calFin)<0)) {
            jour = cal2.getTime()
            mesDate.add(jour)
            cal2.add(Calendar.DATE,1)            
        }
        
        return mesDate
        
    }
    
    def Imputation[] imputations(Kanban kanbanInstance) {
        
        def mesOF = kanbanInstance.of
        def mesKanban = []
        mesOF.each() {of ->
            
        def query = Imputation.whereAny {
                of == of  
            }            
        def imputations = query.list()
        imputations.each() { kanban ->
            mesKanban.add(kanban)
        }
        }
        
        return mesKanban
    }
    
    def Float chargePlanifieJourKanban(Date deb, Imputation[] mesKanban) {
        
        
        // création des jours
            Date maDate = deb
            Date dateMax = dateMaxAgenda(mesKanban)
            def charge = 0
            Calendar cal = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            
            cal.setTime(maDate);
            cal2.setTime(maDate);
            
            cal2.add(Calendar.DATE,1)
            Date maDate2 = cal2.getTime()
            mesKanban.each() {kanban ->
                Date debutEvent = kanban.eventEffectif.event.startTime
                Date finEvent = kanban.eventEffectif.event.endTime
                Calendar calDebutEvent = Calendar.getInstance();
                Calendar calFinEvent = Calendar.getInstance();
                Calendar calMax = Calendar.getInstance();
                calDebutEvent.setTime(debutEvent);
                calFinEvent.setTime(finEvent);   
                calMax.setTime(dateMax);   
                calMax.add(Calendar.DATE,1)
                def charge2 = kanban.eventEffectif.event.dureeHeures
                println("ma charge " + charge2)
            if((calDebutEvent.compareTo(cal2)<0)&&(calFinEvent.compareTo(cal)>0)) {
                    charge += charge2
            }
            else {
                
            }           
            }
        return charge
    }
    
    def Float chargeRealiseJourKanban(Date deb, Imputation[] mesKanban) {
        
        
        // création des jours
            Date maDate = deb
            def charge = 0
            Calendar cal = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            
            cal.setTime(maDate);
            cal2.setTime(maDate);
            
            cal2.add(Calendar.DATE,1)
            Date maDate2 = cal2.getTime()
            mesKanban.each() {kanban ->
                Date debutEvent = kanban.eventEffectif.event.startTime
                Date finEvent = kanban.eventEffectif.event.endTime
                Calendar calDebutEvent = Calendar.getInstance();
                Calendar calFinEvent = Calendar.getInstance();
                calDebutEvent.setTime(debutEvent);
                calFinEvent.setTime(finEvent);   
                def charge2 = kanban.eventEffectif.event.dureeHeures
            if((calDebutEvent.compareTo(cal2)<0)&&(calFinEvent.compareTo(cal)>0)&&kanban.realise) {
                    charge += kanban.tempsImpute
            }
            else {
                
            }
            
            }
        return charge
    }
    
    def dateMaxAgenda(Imputation[] mesKanban) {
        def maDate = new Date()
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        mesKanban.each() {kanban ->
                Date debutEvent = kanban.eventEffectif.event.startTime
                cal.setTime(debutEvent);
                cal2.setTime(maDate);   
                
            if((cal.compareTo(cal2)>0)) {
                    maDate = debutEvent
            }
            else {
                
            }
    }
    return maDate}

    def dateMaxRealise(Imputation[] mesKanban) {
        def maDate = new Date()
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        mesKanban.each() {kanban ->
                Date debutEvent = kanban.eventEffectif.event.startTime
                cal.setTime(debutEvent);
                cal2.setTime(maDate);   
                
            if((cal.compareTo(cal2)>0)&&kanban.realise) {
                    maDate = debutEvent
            }
            else {
                
            }
    }
    return maDate}

    
    
    def chargePlanifieeMois(Date dateDebut,Date dateFin, ArrayList kanbanList) {
        println("dans charge planifiee mois")
        def maCharge = 0
        Calendar calDeb = Calendar.getInstance();
            Calendar calFin = Calendar.getInstance();
            calDeb.setTime(dateDebut);
            calFin.setTime(dateFin);
        
        
           kanbanList.each() { kanban ->
               
            Date debutEvent = kanban.dateLancement
            Date finEvent = kanban.dateFinPlanifie
            
            Calendar calDebutEvent = Calendar.getInstance();
            Calendar calFinEvent = Calendar.getInstance();
            calDebutEvent.setTime(debutEvent);
            calFinEvent.setTime(finEvent);          
            
            Float dureeKanban = nbJoursEntrePeriodes(calDebutEvent, calFinEvent, calDebutEvent, calFinEvent) 
            Float deltaJour = nbJoursEntrePeriodes(calDeb, calFin, calDebutEvent, calFinEvent) 
            maCharge += (kanban.chargePlanifiee / dureeKanban) * deltaJour
            
        }
        
        return maCharge
                    
    }
    
    
    def capacite(Date dateDebut, Date dateFin) {
                def effectifs = Effectif.list()
                Calendar calDeb = Calendar.getInstance();
                Calendar calFin = Calendar.getInstance();
                calDeb.setTime(dateDebut);
                calFin.setTime(dateFin);
                
                def delta = (calFin.get(Calendar.DAY_OF_YEAR) - calDeb.get(Calendar.DAY_OF_YEAR) +1) * effectifs.size()
                def maCharge = 0
                def query2 = Famille.whereAny {
                    travaille == false
                }
                def fams = query2.list()
                
                fams.each() {fam ->
                    def query = Kanban.whereAny {
                famille == fam
            }
            def kanbanList = query.list() // cherche juste avec la famille
            
                delta +=  - chargePlanifieeMois(dateDebut, dateFin, kanbanList)
                
                }
                delta = delta * 5 / 7
                return delta  
    }
    
    
    def capaciteEffectif(Date dateDebut, Date dateFin, Effectif effectif) {
        
                Calendar calDeb = Calendar.getInstance();
                Calendar calFin = Calendar.getInstance();
                calDeb.setTime(dateDebut);
                calFin.setTime(dateFin);
                
                def delta = (calFin.get(Calendar.DAY_OF_YEAR) - calDeb.get(Calendar.DAY_OF_YEAR) +1) 
                def maCharge = 0
                def query2 = Famille.whereAny {
                    travaille == false
                }
                def fams = query2.list()
                
                fams.each() {fam ->
                    def kanbanList = kanbanService.kanbanFamilleEffectif(fam,effectif)
                    delta +=  - chargePlanifieeMois(dateDebut, dateFin, kanbanList)
                
                }
                delta = delta * 5 / 7
                
                return delta  
    }
    
    
    
    def chargePlanifieeEffectif(Date dateDebut,Date dateFin, Effectif effectif, Famille famille) {
        
        def maCharge = 0
        def kanbanList = kanbanService.kanbanFamilleEffectif(famille,effectif)
        
           kanbanList.each() { kanban ->
               kanban.of.each() {of ->
                   if(kanbanService.effectifDansOf(effectif, of)){
                       def ofs = new ArrayList<OF>()
                       ofs.add(of)
                       def chargeOF = chargePlanifieeMoisOF(dateDebut,dateFin, ofs)
                       maCharge += (chargeOF / of.affectes.size())
                   }
               }                    
        }
        
        return maCharge
                    
    }
    
    
    
    
    def chargePlanifieeEffectifOf(Date dateDebut,Date dateFin, OF of) {
        
        def maCharge = 0
        
        def ofs = new ArrayList<OF>()
        ofs.add(of)
        def chargeOF = chargePlanifieeMoisOF(dateDebut,dateFin, ofs)
        maCharge += (chargeOF / of.affectes.size())
        
        return maCharge
                    
    }
    
    
    
    def vad(Date dateDebut, Date dateFin) {        
                def delta = 0
                def query2 = Phase.whereAny {
                    valeurAjoutee == true
                }
                def fams = query2.list()
                
                fams.each() {fam ->
                    def query = OF.whereAny {
                        phase == fam
                    }
                def ofList = query.list() // cherche juste avec phase vad
            
                delta +=   chargePlanifieeMoisOF(dateDebut, dateFin, ofList)
                
                }
                
                return delta  
    }
    
    
    def chargePlanifieeMoisOF(Date dateDebut,Date dateFin, ArrayList ofList) {
        
        def maCharge = 0
        Calendar calDeb = Calendar.getInstance();
            Calendar calFin = Calendar.getInstance();
            calDeb.setTime(dateDebut);
            calFin.setTime(dateFin);
        
        
           ofList.each() { of ->
            Date debutEvent = of.dateDebutPlanifie
            Date finEvent = of.dateFinPlanifie
            
            Calendar calDebutEvent = Calendar.getInstance();
            Calendar calFinEvent = Calendar.getInstance();
            calDebutEvent.setTime(debutEvent);
            calFinEvent.setTime(finEvent);          
            
            Float dureeOf = nbJoursEntrePeriodes(calDebutEvent, calFinEvent, calDebutEvent, calFinEvent) 
                 Float deltaJour = nbJoursEntrePeriodes(calDeb, calFin, calDebutEvent, calFinEvent) 
                maCharge += (of.chargePlanifiee / dureeOf) * deltaJour
               
                    
        }
        
        return maCharge
                    
    }
    
    
    
    def nbJoursEntrePeriodes(Calendar calDeb, Calendar calFin, Calendar calDebutEvent, Calendar calFinEvent) {
        
        if((calDebutEvent.compareTo(calDeb)>0)) { 
            calDeb = calDebutEvent
        }
        if((calFinEvent.compareTo(calFin)<0)) { 
            calFin = calFinEvent
        }
        
        def delta = calFin.get(Calendar.DAY_OF_YEAR) - calDeb.get(Calendar.DAY_OF_YEAR) +1
        if(delta<0) {
            delta = 0
        }
        return delta
    }
    
    
}
