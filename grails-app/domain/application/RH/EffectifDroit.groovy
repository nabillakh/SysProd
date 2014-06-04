package application.RH

import org.apache.commons.lang.builder.HashCodeBuilder

class EffectifDroit implements Serializable {

	Effectif effectif
	Droit droit

	boolean equals(other) {
		if (!(other instanceof EffectifDroit)) {
			return false
		}

		other.effectif?.id == effectif?.id &&
			other.droit?.id == droit?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (effectif) builder.append(effectif.id)
		if (droit) builder.append(droit.id)
		builder.toHashCode()
	}

	static EffectifDroit get(long effectifId, long droitId) {
		find 'from EffectifDroit where effectif.id=:effectifId and droit.id=:droitId',
			[effectifId: effectifId, droitId: droitId]
	}

	static EffectifDroit create(Effectif effectif, Droit droit, boolean flush = false) {
		new EffectifDroit(effectif: effectif, droit: droit).save(flush: flush, insert: true)
	}

	static boolean remove(Effectif effectif, Droit droit, boolean flush = false) {
		EffectifDroit instance = EffectifDroit.findByEffectifAndDroit(effectif, droit)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(Effectif effectif) {
		executeUpdate 'DELETE FROM EffectifDroit WHERE effectif=:effectif', [effectif: effectif]
	}

	static void removeAll(Droit droit) {
		executeUpdate 'DELETE FROM EffectifDroit WHERE droit=:droit', [droit: droit]
	}

	static mapping = {
		id composite: ['droit', 'effectif']
		version false
	}
}
