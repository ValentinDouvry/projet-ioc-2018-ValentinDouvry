package ca.qc.cgmatane.informatique.outilmeteore.action;

import ca.qc.cgmatane.informatique.outilmeteore.vue.VueOutilMeteore;
import dao.MeteoreDaoImplementation;
import dao.MeteoresDao;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.qc.cgmatane.informatique.outilmeteore.Meteore;

public class ControleurOutilMeteores 
{
	protected VueOutilMeteore vue;
	
	public List<Meteore> listeMeteore;
	protected int compteurMeteoreClique;
	
	
	public ControleurOutilMeteores(VueOutilMeteore vue)
	{
		this.vue = vue;
		MeteoresDao meteoresDao = new MeteoreDaoImplementation();
		
		listeMeteore = new ArrayList<Meteore>();		
		
		for (Meteore meteore : meteoresDao.recupererTouteLesMeteores())
		{
			vue.afficherMarqueurMeteore(meteore.getId(),meteore.getCoordonnees());			
		}
		
		compteurMeteoreClique = 0;
		
		/*Iterator<Meteore> visiteurMeteore = listeMeteore.iterator();
		while(visiteurMeteore.hasNext())
		{
			Meteore meteoreTest = visiteurMeteore.next();
			vue.afficherMarqueurMeteore(meteoreTest.getId(),meteoreTest.getCoordonnees());
			
		}*/		
	}
	
	public void clicMeteore(int id)
	{
		vue.afficherDetailsMeteore(dao.MeteoreDaoImplementation.listeMeteores.get(id-1));
		compteurMeteoreClique++;
		if(compteurMeteoreClique == 3)
		{
			vue.afficherAlerte("Les meteores proches sont : " );
			compteurMeteoreClique = 0;
		}
	}
	
	
	
	
}
