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
        println("dans picservice")
        mesFamilles.each() {fam ->
            def picFam = new PicFamille(pic : pic, ordo : fam, uniteActivite : 24)
            generationPdp(picFam)
            pic.addToPicFamille(picFam)
            .save()
            picFam.save()
        }
    }
    
    def generationPdp(PicFamille picFam) {
        def mois = 0
        while(mois++<12) {
            // def Float unite = picFam.uniteActivite / 12
            def monPdp = new Pdp(picFamille : picFam , mois : mois, uniteActivite : mois)
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
    
    def planPluriAnnuel(Pic pic1, Pic pic2, Pic pic3, Pic pic4) {
        println("dans service planpluri")
        def pics = Pic.list()
        // hypothese nbannee = nb pic
        def familles = Famille.list()
        
        def picLists = []
        familles.each {famille ->
            def picList = new LinkedHashMap()
            picList.put("famille",famille.nom.toString())
            famille.ordo.each {ordo ->
                def picList2 = new LinkedHashMap()
                picList2.put("ordo",ordo.nom.toString())
                def pf1 = retourPicFamille(pic1,ordo)
                picList2.put(pic1.annee,pf1.getChargePlanifie()) 
                     
                picList << picList2
                
            }
            picLists <<picList
        }
            println(picLists)
        picLists = []
        
        pics.each {pic ->
            def picList = new LinkedHashMap()
            picList.put("annee",pic.annee.toString())
            
            pic.picFamille.each() { maPicFamille ->
                 picList.put((maPicFamille.ordo.nom.toString()),(maPicFamille.getChargePlanifie()))
            }
             picLists << (picList)
        }
        return picLists
    }
    
    def PicFamille retourPicFamille(Pic pic, Ordonnancement ordo) {
        println("mes ordo " + pic.picFamille*.ordo.id)
        def picfamille = pic.picFamille.find { it.ordo == ordo }   
        if(!picfamille) {
            picfamille = new PicFamille(pic : pic, ordo : ordo, uniteActivite : 10).save(failOnError: true, flush : true)
            pic.addToPicFamille(picfamille)
            pic.save()
        }
        println("retourPicFamille" + pic)
        println("retourPicFamille" + ordo)
        println("retourPicFamille" + picfamille)
        return picfamille
    }
    
}
