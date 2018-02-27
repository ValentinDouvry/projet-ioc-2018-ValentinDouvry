package ca.qc.cgmatane.informatique.outilmeteore.action;

import ca.qc.cgmatane.informatique.outilmeteore.vue.VueOutilMeteore;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ca.qc.cgmatane.informatique.outilmeteore.dao.MeteoreDaoImplementation;
import ca.qc.cgmatane.informatique.outilmeteore.dao.MeteoresDao;
import ca.qc.cgmatane.informatique.outilmeteore.modele.HashMeteore;
import ca.qc.cgmatane.informatique.outilmeteore.modele.Meteore;

public class ControleurOutilMeteores 
{
	protected VueOutilMeteore vue;
	protected int compteurMeteoreClique;
	protected MeteoreDaoImplementation meteoreDaoImplementation;
	protected HashMeteore mapMeteore;
	
	public ControleurOutilMeteores(VueOutilMeteore vue)
	{
		this.vue = vue;
		meteoreDaoImplementation = new MeteoreDaoImplementation();		
		mapMeteore = meteoreDaoImplementation.recupererTouteLesMeteores();
		
		for(int compteur = 0; compteur < mapMeteore.getTaille(); compteur++) 
		{
			if(mapMeteore.get(compteur) != null)
			{
				vue.afficherMarqueurMeteore(mapMeteore.get(compteur).getId(), mapMeteore.get(compteur).getCoordonnees());				
			}
			
			
		}
		
		compteurMeteoreClique = 0;	
	}
	
	public void clicMeteore(int id)
	{
		vue.afficherDetailsMeteore(mapMeteore.get(id));
		compteurMeteoreClique++;
		if(compteurMeteoreClique == 3)
		{
			vue.afficherAlerte("Les meteores proches sont : " );
			compteurMeteoreClique = 0;
		}
	}
	
	
	
	
}
