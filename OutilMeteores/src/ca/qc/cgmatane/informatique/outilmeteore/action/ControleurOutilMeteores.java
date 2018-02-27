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
import java.util.Map;

import ca.qc.cgmatane.informatique.outilmeteore.Meteore;

public class ControleurOutilMeteores 
{
	protected VueOutilMeteore vue;
	protected int compteurMeteoreClique;
	protected MeteoreDaoImplementation meteoreDaoImplementation;
	protected Map<Integer, Meteore> mapMeteore;
	
	public ControleurOutilMeteores(VueOutilMeteore vue)
	{
		this.vue = vue;
		meteoreDaoImplementation = new MeteoreDaoImplementation();		
		mapMeteore = meteoreDaoImplementation.recupererTouteLesMeteores();
		
		for(int compteur = 0; compteur < mapMeteore.size(); compteur++) 
		{
			vue.afficherMarqueurMeteore(mapMeteore.get(compteur).getId(), mapMeteore.get(compteur).getCoordonnees());
		}
		
		compteurMeteoreClique = 0;	
	}
	
	public void clicMeteore(int id)
	{
		
		vue.afficherDetailsMeteore(meteoreDaoImplementation.recupererTouteLesMeteores().get(id-1));
		compteurMeteoreClique++;
		if(compteurMeteoreClique == 3)
		{
			vue.afficherAlerte("Les meteores proches sont : " );
			compteurMeteoreClique = 0;
		}
	}
	
	
	
	
}
