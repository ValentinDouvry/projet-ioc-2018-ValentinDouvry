package ca.qc.cgmatane.informatique.outilmeteore.modele;

public abstract class ObjetSpacial {
	
	
	public abstract float[] getCoordonnees();
	public abstract void setCoordonnees(float[] coordonnees);
	public abstract int getId();
	public abstract void setId(int id);
	public abstract String getDescription();
	public abstract void setDescription(String description);
	public abstract float getMasse();
	public abstract void setMasse(float masse);
	public abstract String getNom();
	public abstract void setNom(String nom);
}
