package application.RH

import application.PP.*

class Equipe {

    
    
	transient kanbanService
    
    String nom
    static hasMany = [effectifs : Effectif]
    
    Entreprise entreprise
    
    
	static transients = ['listeKanban']
    
        public Kanban[] getListeKanban() { 
            def liste = []
            this.effectifs.each() {eff ->
                eff.getListeKanban().each() { kanban ->
                    liste.add(kanban)
                }
            }
            return liste
        }
        
    
    
    static constraints = {
        effectifs nullable : true
        entreprise nullable : true
    }
}
