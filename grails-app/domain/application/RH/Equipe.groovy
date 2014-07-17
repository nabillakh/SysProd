package application.RH

class Equipe {

    String nom
    static hasMany = [effectifs : Effectif]
    
    Entreprise entreprise
    
    static constraints = {
        effectifs nullable : true
        entreprise nullable : true
    }
}
