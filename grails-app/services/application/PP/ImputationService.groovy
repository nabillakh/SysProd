package application.PP

import grails.transaction.Transactional
import application.RH.*

@Transactional
class ImputationService {

    def springSecurityService
    
    def serviceMethod() {

    }
    
    def Imputation[] monImputation() {
        def per = Effectif.get(springSecurityService.principal.id)
        // def imputations = Imputation.list()
        
        def query = Imputation.whereAny {
                effectif == per
            }
            
        def imputations = query.list()    
        
    }
    
    def Imputation[] monImputationEntreDates(Date deb, Date fin) {
        def per = Effectif.get(springSecurityService.principal.id)
        // def imputations = Imputation.list()
        
            Calendar calDeb = Calendar.getInstance();
            Calendar calFin = Calendar.getInstance();
            calDeb.setTime(deb);
            calFin.setTime(fin);
            
        def query = Imputation.whereAny {
                effectif == per    
            }            
        def imputations = query.list()
        
        def mesImput = []
        imputations.each() { imput ->
            Date debutEvent = imput.eventEffectif.event.startTime
            Date finEvent = imput.eventEffectif.event.endTime
            
            Calendar calDebutEvent = Calendar.getInstance();
            Calendar calFinEvent = Calendar.getInstance();
            calDebutEvent.setTime(debutEvent);
            calFinEvent.setTime(finEvent);          
            
            if((calDebutEvent.compareTo(calFin)<0)) {
                if((calFinEvent.compareTo(calDeb)>0)) {
                    mesImput.add(imput)
                }
            }
        }
        return mesImput
        println(mesImput)
        
    }
    
    // deb est le premier jour de la semaine selectionee
    def monImputationParJour(Date deb, Imputation[] mesImput) {
        
        def lignes = []
        
        def mesOF = [] // a extraire des imputations
        mesImput.each() { imputation ->
            mesOF.add(imputation.of)
        }
        mesOF.unique()
        
        // création des jours
            Date lundi2 = deb
            Calendar cal = Calendar.getInstance();
            Calendar lundi = Calendar.getInstance();
            Calendar mardi = Calendar.getInstance();
            Calendar mercredi = Calendar.getInstance();
            Calendar jeudi = Calendar.getInstance();
            Calendar vendredi = Calendar.getInstance();
            Calendar samedi = Calendar.getInstance();
            Calendar dimanche = Calendar.getInstance();
            
            cal.setTime(lundi2);
            lundi.setTime(lundi2);
            
            cal.add(Calendar.DATE,1)
            Date mardi2 = cal.getTime()
            mardi.setTime(mardi2);
            
            cal.add(Calendar.DATE,1)
            Date mercredi2 = cal.getTime()
            mercredi.setTime(mercredi2);
            
            cal.add(Calendar.DATE,1)
            Date jeudi2 = cal.getTime()
            jeudi.setTime(jeudi2);
            
            cal.add(Calendar.DATE,1)
            Date vendredi2 = cal.getTime()
            vendredi.setTime(vendredi2);
            
            cal.add(Calendar.DATE,1)
            Date samedi2 = cal.getTime()
            samedi.setTime(samedi2);
            
            cal.add(Calendar.DATE,1)
            Date dimanche2 = cal.getTime()
            dimanche.setTime(dimanche2);
            
            
        
        
        
        mesOF.each() { of ->
            def uneLigne = new LinkedHashMap()
            
            uneLigne.put("Of",of)
            
            def imputs = mesImput.findAll {it.of == of}
            
            def listeLundi = []
            def listeMardi = []
            def listeMercredi = []
            def listeJeudi = []
            def listeVendredi = []
            def listeSamedi = []
            def listeDimanche = []
            
            imputs.each() {imput ->
                Date debutEvent = imput.eventEffectif.event.startTime
                Date finEvent = imput.eventEffectif.event.endTime
                Calendar calDebutEvent = Calendar.getInstance();
                Calendar calFinEvent = Calendar.getInstance();
                calDebutEvent.setTime(debutEvent);
                calFinEvent.setTime(finEvent);        
            if((calDebutEvent.compareTo(mardi)<0)) {
                if((calFinEvent.compareTo(lundi)>0)) {
                    listeLundi.add(imput)
                }
            }
            if((calDebutEvent.compareTo(mercredi)<0)) {
                if((calFinEvent.compareTo(mardi)>0)) {
                    listeMardi.add(imput)
                }
            }
            if((calDebutEvent.compareTo(jeudi)<0)) {
                if((calFinEvent.compareTo(mercredi)>0)) {
                    listeMercredi.add(imput)
                }
            }
            if((calDebutEvent.compareTo(vendredi)<0)) {
                if((calFinEvent.compareTo(jeudi)>0)) {
                    listeJeudi.add(imput)
                }
            }
            if((calDebutEvent.compareTo(samedi)<0)) {
                if((calFinEvent.compareTo(vendredi)>0)) {
                    listeVendredi.add(imput)
                }
            }
            if((calDebutEvent.compareTo(dimanche)<0)) {
                if((calFinEvent.compareTo(samedi)>0)) {
                    listeSamedi.add(imput)
                }
            }
            
            }
            uneLigne.put("Lundi",listeLundi)
            uneLigne.put("Mardi",listeMardi)
            uneLigne.put("Mercredi",listeMercredi)
            uneLigne.put("Jeudi",listeJeudi)
            uneLigne.put("Vendredi",listeVendredi)  
            uneLigne.put("Samedi",listeJeudi)
            uneLigne.put("Dimanche",listeDimanche)  
            
            lignes << (uneLigne)
        }
        return lignes
    }
    
    def Date premierJour(int annee, int semaine) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.WEEK_OF_YEAR, semaine);
        calendar.set(Calendar.YEAR, annee);
        // permet d'avoir le premier jour de la semaine de la date en cours
        Date premierJour = calendar.getTime();
        return premierJour
    }
    
        def Date premierJourMois(int annee, int mois) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, mois);
        calendar.set(Calendar.YEAR, annee);
        // permet d'avoir le premier jour de la semaine de la date en cours
        Date premierJour = calendar.getTime();
        
        return premierJour
    }
    
    def Date dernierJour(int annee, int semaine) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.WEEK_OF_YEAR, semaine);
        calendar.set(Calendar.YEAR, annee);
        calendar.add(Calendar.DATE,7)
        // permet d'avoir le premier jour de la semaine de la date en cours
        Date dernierJour = calendar.getTime();
        return dernierJour
    }
    
    def Date dernierJourMois(int annee, int mois) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, mois +1);
        calendar.set(Calendar.YEAR, annee);
        
        calendar.add(Calendar.DATE, -1)
        // permet d'avoir le premier jour de la semaine de la date en cours
        Date dernierJour = calendar.getTime();
        
        return dernierJour
    }
    
}
