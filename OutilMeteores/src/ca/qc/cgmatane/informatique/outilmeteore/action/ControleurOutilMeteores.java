package ca.qc.cgmatane.informatique.outilmeteore.action;

import ca.qc.cgmatane.informatique.outilmeteore.vue.VueOutilMeteore;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ControleurOutilMeteores 
{
	protected VueOutilMeteore vue;
	
	protected int coordoneesMeteoreTest1[] = {300,150};
	protected int coordoneesMeteoreTest2[] = {500,25};
	protected int coordoneesMeteoreTest3[] = {70,100};
	
	
	public ControleurOutilMeteores(VueOutilMeteore vue)
	{
		this.vue = vue;
		vue.afficherMarqueurMeteore(1,coordoneesMeteoreTest1);
		vue.afficherMarqueurMeteore(2,coordoneesMeteoreTest2);
		vue.afficherMarqueurMeteore(3,coordoneesMeteoreTest3);
		
	}
	
	
	
	
	
	
}
