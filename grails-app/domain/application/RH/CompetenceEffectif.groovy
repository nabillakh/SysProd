package application.RH

class CompetenceEffectif {

    Effectif effectif
    Competence competence
    
    static constraints = {
    }
    static mappedBy = [effectif : 'competence', competence : 'effectifs']
}
