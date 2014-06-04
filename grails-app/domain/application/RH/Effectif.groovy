package application.RH

import application.PP.*

class Effectif {

	transient springSecurityService

        String nom
        String prenom
        String mailEffectif
        Equipe equipe    
        String username
	String password
       	boolean enabled = true
	boolean accountExpired =false
	boolean accountLocked = false
	boolean passwordExpired 

        static hasMany = [mesOF : OFEffectif]
        
	static transients = ['springSecurityService', 'listeKanban']
        
        Entreprise entreprise
    
        public Kanban[] getListeKanban() {
            kanbanService.listeKanbanEffectif(this)
        }

	static constraints = {
		username blank: false, unique: true
		password blank: false
                mailEffectif email:true, unique:true, nullable:true
                nom nullable : true
                prenom nullable :true
                equipe nullable : true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Droit> getAuthorities() {
		EffectifDroit.findAllByEffectif(this).collect { it.droit } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
