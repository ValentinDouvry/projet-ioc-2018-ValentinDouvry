package ca.qc.cgmatane.informatique.outilmeteore.vue;
import ca.qc.cgmatane.informatique.outilmeteore.action.ControleurOutilMeteores;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;



import javafx.scene.layout.StackPane;
import javafx.stage.Stage;




public class VueOutilMeteore extends Application
{

	protected ControleurOutilMeteores controleur;
	protected Button actionDireBonjour;
	protected TextField penseeDuJour;
	
	
	public VueOutilMeteore()
	{
		this.controleur = new ControleurOutilMeteores(this);
	}

	public void start(Stage scenePrincipale) 
	{
		actionDireBonjour = new Button();
		actionDireBonjour.setId("boutton-Bienvenue");
		actionDireBonjour.setText("Hi There !");		
		actionDireBonjour.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		penseeDuJour = new TextField();
		StackPane racine = new StackPane();
		racine.getChildren().add(actionDireBonjour);
		//racine.getChildren().add(penseeDuJour);
		Scene scene = new Scene(racine, 300, 250);
		scene.getStylesheets().add(VueOutilMeteore.class.getResource("decoration/OutilMeteore.css").toExternalForm());
		scenePrincipale.setScene(scene);
		scenePrincipale.show();
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
