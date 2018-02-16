package ca.qc.cgmatane.informatique.outilmeteore;

public class Meteore 
{
	private float[] coordonnees;
	private int id;
	private String description;
	private float masse;
	private String nom = "";
	private int annee;
	
	
	public Meteore(float[] coordonnees, int id, float masse, String nom,int annee)
	{
		this.coordonnees = coordonnees;
		this.id = id;
		this.masse = masse;
		this.nom = nom;
		this.description = ("Nom : " + nom  + " \nMasse : " + masse + "g" + "\nAnnee : " + annee + "\nCoordonnees :  " + "{" + coordonnees[0] + ";" + coordonnees[1] + "}" );
		
		
	}
	
	public float[] getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(float[] coordonnees) {
		this.coordonnees = coordonnees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public float getMasse() {
		return masse;
	}

	public void setMasse(float masse) {
		this.masse = masse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	
	

}
