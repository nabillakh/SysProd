package application.pilotage


import grails.transaction.Transactional
import application.PP.*
import application.pilotage.*

@Transactional
class PicService {
    
    def Pic picAnnee(Integer year) {
        def monPic = new Pic()
        def mesPics = []
        mesPics = Pic.findAll("from Pic as b where b.annee=?", [year])
        mesPics.each() {pic->
            if(pic.archive==false) {
                monPic = pic
            }
        }
        return monPic
    }
    
    def generationPicFamille(Pic pic) {
        def mesFamilles = Ordonnancement.list()
        mesFamilles.each() {fam ->
            def picFam = new PicFamille(ordo : fam, uniteActivite : 24)
            generationPdp(picFam)
            pic.addToPicFamille(picFam)
            .save()
            picFam.save()
        }
    }
    
    def generationPdp(PicFamille picFam) {
        def mois = 0
        while(mois++<12) {
            def Float unite = picFam.uniteActivite / 12
            def monPdp = new Pdp(mois : mois, uniteActivite : unite)
            picFam.addToPdp(monPdp)
                .save()
            monPdp.save()
        }
    }
    
    
    def PicFamille[] listPicFamille(Pic pic) {
        def mesFamilles = Famille.list()
        def picFamListe = []
        mesFamilles.each() {fam ->
            def picFam = new PicFamille(famille : fam)
            picFamListe.add(picFam)
        }
        return picFamListe
    }  
    
}
