package ca.qc.cgmatane.informatique.outilmeteore.modele;
import org.apache.commons.lang3.ArrayUtils;

public class HashObjetsSpatiaux {
	protected int taille;
	protected ObjetSpatial[] tableauObjetsSpatiaux;
	
	public HashObjetsSpatiaux() {
		taille = 0;
		tableauObjetsSpatiaux = new ObjetSpatial[5000];
	}
	
	public int getTaille() {
		return taille;
	}

	public void ajouter(ObjetSpatial objetSpacial, int id) {
		this.tableauObjetsSpatiaux[id] = objetSpacial;
		taille++;
	}
	
	public ObjetSpatial getObjetSpatial(int id) {
		return this.tableauObjetsSpatiaux[id];
	}
	
	public int getIdDernierObjetSpacial() {
		return this.getObjetSpatial(this.taille-1).getId();
	}
	
	public void supprimerObjetSpacial(int id) {
        //this.tableauObjetsSpatiaux = ArrayUtils.remove(tableauObjetsSpatiaux, id);
        System.out.println("DELETED: " + tableauObjetsSpatiaux[id].getNom());
	}
	
	public void modifierObjetSpatial(int id, float[] coordonnees, String nom, Float masse, String annee, String position) {
		this.getObjetSpatial(id).setNom(nom);
		this.getObjetSpatial(id).setCoordonnees(coordonnees);
		this.getObjetSpatial(id).setAnnee(annee);
		this.getObjetSpatial(id).setMasse(masse);
		this.getObjetSpatial(id).setPosition(position);
		this.getObjetSpatial(id).setEstCreeOuModifie(true);
	}
	
	
}
