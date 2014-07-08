package application.PP

class Ordonnancement {
    
    String nom
    Famille famille
    SortedSet phases
    static hasMany = [phases : Phase]
    
    Float chargeStandard
    
    static constraints = {
        phases nullable : true
    }
    
     static mappedBy = {
         famille : 'ordo'
     }
     
    
    
}
