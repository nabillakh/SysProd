package application.pilotage


import application.PP.*


class Pdp {
    
    
    static belongsTo = [picFamille : PicFamille]
    Integer mois
    Float uniteActivite
    Integer version
    Date dateMaj
    
    
    def chargePlanifie = {
        picFamille.getOrdo().getChargeStandard() * uniteActivite
    }
    
    static constraints = {
        version nullable : true
        dateMaj nullable : true
        uniteActivite nullable : true
    }
    
    
    
    def beforeInsert = {
        
        dateMaj = new Date()
        return true
    }
    
    def beforeUpdate = {
        dateMaj = new Date()
        return true
    }
    
}
