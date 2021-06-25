package ca.qc.cgmatane.informatique.outilmeteore.modele;

public class HashMeteore 
{
	protected int taille;
	protected Meteore[] tableauMeteore;
	
	public HashMeteore()
	{
		taille = 0;
		tableauMeteore = new Meteore[500];
	}
	
	public int getTaille() {
		return taille;
	}

	public void ajouter(Meteore meteore, int id)
	{
		this.tableauMeteore[id] = meteore;
		taille++;
	}
	
	public Meteore getMeteore(int id)
	{
		return this.tableauMeteore[id];
	}
	
	
}
