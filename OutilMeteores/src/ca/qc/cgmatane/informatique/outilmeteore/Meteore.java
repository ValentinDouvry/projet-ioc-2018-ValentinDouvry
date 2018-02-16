package ca.qc.cgmatane.informatique.outilmeteore;

public class Meteore 
{
	private int[] coordonnees;
	private int id;
	private String description;
	private int masse;
	private String nom = "";
	private int annee;
	
	
	public Meteore(int[] coordonnees, int id, int masse, String nom,int annee)
	{
		this.coordonnees = coordonnees;
		this.id = id;
		this.masse = masse;
		this.nom = nom;
		this.description = ("Nom : " + nom  + " \nMasse : " + masse + "g" + "\nAnnee : " + annee + "\nCoordonnees :  " + "{" + coordonnees[0] + ";" + coordonnees[1] + "}" );
		
		
	}
	
	public int[] getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(int[] coordonnees) {
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

	public int getMasse() {
		return masse;
	}

	public void setMasse(int masse) {
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
