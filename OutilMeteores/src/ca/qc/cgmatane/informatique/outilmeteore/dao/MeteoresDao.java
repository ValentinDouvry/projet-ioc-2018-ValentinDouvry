package ca.qc.cgmatane.informatique.outilmeteore.dao;
import java.util.List;
import java.util.Map;

import ca.qc.cgmatane.informatique.outilmeteore.modele.Meteore;

public interface MeteoresDao 
{
	public Map<Integer,Meteore> recupererTouteLesMeteores();
	public Meteore getMeteore();
	public void miseAJourMeteores(Meteore meteore);
	public void supprimerMeteore(Meteore meteore);
	
	
}
