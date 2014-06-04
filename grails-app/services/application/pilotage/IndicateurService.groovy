package application.pilotage


import grails.transaction.Transactional
import application.PP.*

@Transactional
class IndicateurService {

    def imputationService
    
    def Date[] listeDate(Date deb, Date fin) {
                println("dans service")
            Calendar calDeb = Calendar.getInstance();
            Calendar calFin = Calendar.getInstance();
            calDeb.setTime(deb);
            calFin.setTime(fin);
            
            
        println(fin)
        
        def mesDate = []
        
        def delta = (fin.getTime() - deb.getTime())/(1000*60*60*24)
            println((int)Math.round(delta))
        
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
                
        println(jour)
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
        def mesImput = []
        mesOF.each() {of ->
            
        def query = Imputation.whereAny {
                of == of  
            }            
        def imputations = query.list()
        imputations.each() { imput ->
            mesImput.add(imput)
        }
        }
        
        return mesImput
    }
    
    def Float chargePlanifieJourKanban(Date deb, Imputation[] mesImput) {
        
        
        // création des jours
            Date maDate = deb
            Date dateMax = dateMaxAgenda(mesImput)
            def charge = 0
            Calendar cal = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            
            cal.setTime(maDate);
            cal2.setTime(maDate);
            
            cal2.add(Calendar.DATE,1)
            Date maDate2 = cal2.getTime()
            mesImput.each() {imput ->
                Date debutEvent = imput.eventEffectif.event.startTime
                Date finEvent = imput.eventEffectif.event.endTime
                Calendar calDebutEvent = Calendar.getInstance();
                Calendar calFinEvent = Calendar.getInstance();
                Calendar calMax = Calendar.getInstance();
                calDebutEvent.setTime(debutEvent);
                calFinEvent.setTime(finEvent);   
                calMax.setTime(dateMax);   
                calMax.add(Calendar.DATE,1)
                def charge2 = imput.eventEffectif.event.dureeHeures
            if((calDebutEvent.compareTo(cal2)<0)&&(calFinEvent.compareTo(cal)>0)) {
                    charge += charge2
            }
            else {
                
            }
            
            
            }
        return charge
    }
    
    def Float chargeRealiseJourKanban(Date deb, Imputation[] mesImput) {
        
        
        // création des jours
            Date maDate = deb
            def charge = 0
            Calendar cal = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            
            cal.setTime(maDate);
            cal2.setTime(maDate);
            
            cal2.add(Calendar.DATE,1)
            Date maDate2 = cal2.getTime()
            mesImput.each() {imput ->
                Date debutEvent = imput.eventEffectif.event.startTime
                Date finEvent = imput.eventEffectif.event.endTime
                Calendar calDebutEvent = Calendar.getInstance();
                Calendar calFinEvent = Calendar.getInstance();
                calDebutEvent.setTime(debutEvent);
                calFinEvent.setTime(finEvent);   
                def charge2 = imput.eventEffectif.event.dureeHeures
            if((calDebutEvent.compareTo(cal2)<0)&&(calFinEvent.compareTo(cal)>0)&&imput.realise) {
                    charge += imput.tempsImpute
            }
            else {
                
            }
            
            }
        return charge
    }
    
    def dateMaxAgenda(Imputation[] mesImput) {
        def maDate = new Date()
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        mesImput.each() {imput ->
                Date debutEvent = imput.eventEffectif.event.startTime
                cal.setTime(debutEvent);
                cal2.setTime(maDate);   
                
            if((cal.compareTo(cal2)>0)) {
                    maDate = debutEvent
            }
            else {
                
            }
    }
    return maDate}

    def dateMaxRealise(Imputation[] mesImput) {
        def maDate = new Date()
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        mesImput.each() {imput ->
                Date debutEvent = imput.eventEffectif.event.startTime
                cal.setTime(debutEvent);
                cal2.setTime(maDate);   
                
            if((cal.compareTo(cal2)>0)&&imput.realise) {
                    maDate = debutEvent
            }
            else {
                
            }
    }
    return maDate}
    
    
}
