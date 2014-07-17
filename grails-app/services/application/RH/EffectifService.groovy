package application.RH

import grails.transaction.Transactional

@Transactional
class EffectifService {

    def maCompetenceEffectif(Competence competence, Effectif effectif) {
        def rep = new CompetenceEffectif(competence : competence, effectif : effectif)
        def effCompt = CompetenceEffectif.findAll("from CompetenceEffectif as b where b.competence=?", [competence])
        effCompt.each() {effComp ->
            if(effComp.effectif == effectif) {
                rep = effComp
            }
        }
        rep.save()
        return rep
    }
    
    def affectables(Competence competence) {
        def effCompt = CompetenceEffectif.findAll("from CompetenceEffectif as b where b.competence=?", [competence])
        def mesEffectifs = []
        effCompt.each() {effC ->
            mesEffectifs.add(effC.effectif)
        }
        mesEffectifs.unique()
        return mesEffectifs
        
    }
}
