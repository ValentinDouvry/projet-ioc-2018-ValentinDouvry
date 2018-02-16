package ca.qc.cgmatane.informatique.outilmeteore.action;

import ca.qc.cgmatane.informatique.outilmeteore.vue.VueOutilMeteore;
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
	
	//protected int coordoneesMeteoreTest1[] = {300,150};
	//protected int coordoneesMeteoreTest2[] = {500,25};
	//protected int coordoneesMeteoreTest3[] = {70,100};
	
	public List<Meteore> listeMeteore;
	protected Meteore meteoreTest1;
	protected Meteore meteoreTest2;
	protected Meteore meteoreTest3;
	
	
	
	
	public ControleurOutilMeteores(VueOutilMeteore vue)
	{
		this.vue = vue;
				
		meteoreTest1 = new Meteore();
		meteoreTest2 = new Meteore();
		meteoreTest3 = new Meteore();
		listeMeteore = new ArrayList<Meteore>();
		
		meteoreTest1.setId(0);
		meteoreTest1.setCoordonnees(new int[] {600,150});
		meteoreTest1.setDescription("Description du meteore numero 1");		
		
		meteoreTest2.setId(1);
		meteoreTest2.setCoordonnees(new int[] {500,25});
		meteoreTest2.setDescription("Description du meteore numero 2");
		
		meteoreTest3.setId(2);
		meteoreTest3.setCoordonnees(new int[] {70,100});
		meteoreTest3.setDescription("Description du meteore numero 3");
		
		listeMeteore.add(meteoreTest1);
		listeMeteore.add(meteoreTest2);
		listeMeteore.add(meteoreTest3);		
		
		Iterator<Meteore> visiteurMeteore = listeMeteore.iterator();
		while(visiteurMeteore.hasNext())
		{
			Meteore meteoreTest = visiteurMeteore.next();
			vue.afficherMarqueurMeteore(meteoreTest.getId(),meteoreTest.getCoordonnees());
			
		}
		
		
		
		
	}
	
	
	
	
	
	
}
