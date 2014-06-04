package application.pilotage


import application.PP.*


class Pdp {
    
    PicFamille picFamille
    Integer mois
    Float uniteActivite
    Integer version
    Date dateVersion
    Date dateMaj
    
    
    def chargePlanifie = {
        picFamille.getOrdo().getChargeStandard() * uniteActivite
    }
    
    static constraints = {
        version nullable : true
        dateVersion nullable : true
        dateMaj nullable : true
        uniteActivite nullable : true
    }
    
    
    
    def beforeInsert = {
        dateVersion = new Date()
        dateMaj = new Date()
        return true
    }
    
    def beforeUpdate = {
        dateMaj = new Date()
        return true
    }
    
}
