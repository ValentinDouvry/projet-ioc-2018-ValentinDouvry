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
	protected Meteore meteoreTest4;
	protected Meteore meteoreTest5;
	protected Meteore meteoreTest6;
	protected Meteore meteoreTest7;
	
	
	
	public ControleurOutilMeteores(VueOutilMeteore vue)
	{
		this.vue = vue;
				
		meteoreTest1 = new Meteore();
		meteoreTest2 = new Meteore();
		meteoreTest3 = new Meteore();
		meteoreTest4 = new Meteore();
		meteoreTest5 = new Meteore();
		meteoreTest6 = new Meteore();
		meteoreTest7 = new Meteore();
		
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
		
		meteoreTest4.setId(3);
		meteoreTest4.setCoordonnees(new int[] {254,37});
		meteoreTest4.setDescription("Description du meteore numero 4");
		
		meteoreTest5.setId(4);
		meteoreTest5.setCoordonnees(new int[] {100,67});
		meteoreTest5.setDescription("Description du meteore numero 5");
		
		meteoreTest6.setId(5);
		meteoreTest6.setCoordonnees(new int[] {511,169});
		meteoreTest6.setDescription("Description du meteore numero 6");
		
		meteoreTest7.setId(6);
		meteoreTest7.setCoordonnees(new int[] {399,255});
		meteoreTest7.setDescription("Description du meteore numero 7");
		
		listeMeteore.add(meteoreTest1);
		listeMeteore.add(meteoreTest2);
		listeMeteore.add(meteoreTest3);
		listeMeteore.add(meteoreTest4);	
		listeMeteore.add(meteoreTest5);	
		listeMeteore.add(meteoreTest6);	
		listeMeteore.add(meteoreTest7);	
		
		Iterator<Meteore> visiteurMeteore = listeMeteore.iterator();
		while(visiteurMeteore.hasNext())
		{
			Meteore meteoreTest = visiteurMeteore.next();
			vue.afficherMarqueurMeteore(meteoreTest.getId(),meteoreTest.getCoordonnees());
			
		}
		
		
		
		
	}
	
	
	
	
	
	
}
