package application.pilotage

class Pic {

    Integer annee
    Integer version
    Date dateVersion
    Date dateMaj
    boolean archive
    
    static hasMany = [picFamille : PicFamille]
    
    
    static constraints = {
        version nullable : true
        dateVersion nullable : true
        dateMaj nullable : true
    }
    
    
    def beforeInsert = {
        archive = false
        return true
    }
}
