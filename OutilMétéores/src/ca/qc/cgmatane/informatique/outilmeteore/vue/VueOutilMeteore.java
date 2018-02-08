package ca.qc.cgmatane.informatique.outilmeteore.vue;
import ca.qc.cgmatane.informatique.outilmeteore.action.ControleurOutilMeteores;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javax.swing.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;




public class VueOutilMeteore extends Application
{

	protected ControleurOutilMeteores controleur;
	
	
	public VueOutilMeteore()
	{
		this.controleur = new ControleurOutilMeteores(this);
	}

	public void start(Stage scenePrincipale) 
	{
		
	}
	
	

	public void afficherMarqueurMeteore(int id,int[] coordonnees)
	{
		
	}
	
	public void inscrireDescriptionMeteore(int id, String texte)
	{
		
	}
	
	public void afficherDescription(int id)
	{
		
	}
	
	

}
