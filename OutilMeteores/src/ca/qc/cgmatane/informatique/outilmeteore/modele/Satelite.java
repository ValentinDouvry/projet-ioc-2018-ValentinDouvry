package ca.qc.cgmatane.informatique.outilmeteore.modele;

public class Satelite extends ObjetSpatial{
	private float[] coordonnees;
	private int id;
	private String description;
	private float masse;
	private String nom = "";
	private String annee;
	private String position;
	private boolean estCreeOuModifie;
	
	
	public Satelite(float[] coordonnees, int id, float masse, String nom, String annee, String position, boolean estCreeOuModifie) {
		this.coordonnees = coordonnees;
		this.id = id;
		this.masse = masse;
		this.nom = nom;
		this.annee = annee;
		this.description = ("Nom : " + nom  + " \nMasse : " + masse + " kg" + "\nDate : " + annee + "\nCoordonnees :  " + position);
		this.position = position;
		this.estCreeOuModifie = estCreeOuModifie;
	}

	@Override
	public float[] getCoordonnees() {
		return this.coordonnees;
	}

	@Override
	public void setCoordonnees(float[] coordonnees) {
		this.coordonnees = coordonnees;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public float getMasse() {
		return this.masse;
	}

	@Override
	public void setMasse(float masse) {
		this.masse = masse;		
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;		
	}

	@Override
	public String getAnnee() {
		return this.annee;
	}

	@Override
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public void setEstCreeOuModifie(boolean estCreeOuModifie) {
		this.estCreeOuModifie = estCreeOuModifie;
	}


	@Override
	public boolean getEstCreeOuModifie() {
		return estCreeOuModifie;
	}

}
