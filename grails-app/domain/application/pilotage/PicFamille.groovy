package application.pilotage

import application.PP.*


class PicFamille {
    
    static belongsTo = [pic : Pic]
    Ordonnancement ordo
    Float uniteActivite
    Integer version
    Date dateVersion
    Date dateMaj
    
    static hasMany = [pdp : Pdp]   
    static transients = ['chargePlanifie']
    
    public Float getChargePlanifie() {
        ordo.getChargeStandard() * uniteActivite
    }
    
    def restantAPlanifier = {
        return uniteActivite - (float)pdp.size()
    }
    
    static constraints = {
        version nullable : true
        dateVersion nullable : true
        dateMaj nullable : true
        pdp nullable : true
    }
    
    
    
    static mappedBy = [pdp : 'picFamille']
    
}
