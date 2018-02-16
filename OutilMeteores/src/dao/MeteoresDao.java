package dao;
import java.util.List;

import ca.qc.cgmatane.informatique.outilmeteore.Meteore;

public interface MeteoresDao 
{
	public List<Meteore> recupererTouteLesMeteores();
	public Meteore getMeteore();
	public void miseAJourMeteores(Meteore meteore);
	public void supprimerMeteore(Meteore meteore);
	
	
}
