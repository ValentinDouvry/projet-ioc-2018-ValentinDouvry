package ca.qc.cgmatane.informatique.outilmeteore.modele;

public class HashObjetsSpatiaux {
	protected int taille;
	protected ObjetSpacial[] tableauObjetsSpatiaux;
	
	public HashObjetsSpatiaux() {
		taille = 0;
		tableauObjetsSpatiaux = new ObjetSpacial[5000];
	}
	
	public int getTaille() {
		return taille;
	}

	public void ajouter(ObjetSpacial objetSpacial, int id) {
		this.tableauObjetsSpatiaux[id] = objetSpacial;
		taille++;
	}
	
	public ObjetSpacial getObjetSpatial(int id) {
		return this.tableauObjetsSpatiaux[id];
	}
	
	public int getIdDernierObjetSpacial() {
		return this.getObjetSpatial(this.taille-1).getId();
	}
	
	
}
