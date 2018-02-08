package ca.qc.cgmatane.informatique.outilmeteore.vue;
import ca.qc.cgmatane.informatique.outilmeteore.action.ControleurOutilMeteores;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class VueOutilMeteore extends Application
{

	protected ControleurOutilMeteores controleur;
	
	
	public VueOutilMeteore()
	{
		this.controleur = new ControleurOutilMeteores(this);
	}

	@Override
	public void start(Stage scenePrincipale)
	{
		
		
	}
	

}
