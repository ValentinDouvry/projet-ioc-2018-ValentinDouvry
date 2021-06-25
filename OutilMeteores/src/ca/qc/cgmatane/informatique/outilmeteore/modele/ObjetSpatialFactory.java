package ca.qc.cgmatane.informatique.outilmeteore.modele;

public class ObjetSpatialFactory {

	public static ObjetSpacial getObjetSpacial(String type, float[] coordonnees, int id, float masse, String nom, String annee, String position) {
		if("Meteore".equalsIgnoreCase(type)) return new Meteore(coordonnees, id, masse, nom,  annee, position);
		else if("Satelite".equalsIgnoreCase(type)) return new Satelite(coordonnees, id, masse, nom,  annee, position);
		
		return null;
	}
}
