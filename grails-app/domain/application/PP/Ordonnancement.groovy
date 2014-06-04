package application.PP

class Ordonnancement {
    
    String nom
    Famille famille
    SortedSet phases
    static hasMany = [phases : Phase]
    
    Float chargeStandard
    
    static constraints = {
        famille nullable:true
        phases nullable : true
    }
    
     static mappedBy = {
         famille : 'ordo'
     }
     
    
    
}
