package ca.qc.cgmatane.informatique.outilmeteore.modele;

public class ObjetSpatialFactory {

	public static ObjetSpatial getObjetSpatial(String type, float[] coordonnees, int id, float masse, String nom, String annee, String position, boolean creeOuModifie) {
		if("Meteore".equalsIgnoreCase(type)) return new Meteore(coordonnees, id, masse, nom,  annee, position, creeOuModifie);
		else if("Satelite".equalsIgnoreCase(type)) return new Satelite(coordonnees, id, masse, nom,  annee, position, creeOuModifie);
		
		return null;
	}
}
