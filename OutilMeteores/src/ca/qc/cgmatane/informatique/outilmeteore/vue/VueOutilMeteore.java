package ca.qc.cgmatane.informatique.outilmeteore.vue;
import java.io.FileNotFoundException;

import org.omg.CORBA.PRIVATE_MEMBER;

import ca.qc.cgmatane.informatique.outilmeteore.action.ControleurOutilMeteores;
import ca.qc.cgmatane.informatique.outilmeteore.modele.Meteore;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VueOutilMeteore extends Application
{

	protected ControleurOutilMeteores controleur;
	//protected Image marqueurMeteore;
	protected Circle marqueurMeteoreTest1;
	protected Circle marqueurMeteoreTest2;
	protected Circle marqueurMeteoreTest3;
	protected StackPane racine;
	protected Stage fenetreDetailsMeteore;
	protected Pane panneauMeteore;
	protected Text texteDetailsMeteore;
	protected int compteurMeteoreClique;
	protected List<Circle> listMarqueursMeteore;	
	

	public void start(Stage scenePrincipale) throws FileNotFoundException 
	{		
				
		this.racine = new StackPane();
		this.panneauMeteore = new Pane();
		this.listMarqueursMeteore = new ArrayList<Circle>();
		
		/* Fenetre Details des meteores */
		this.texteDetailsMeteore = new Text(); //Texte description meteore
		this.texteDetailsMeteore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		this.texteDetailsMeteore.setFill(Color.YELLOW);
		StackPane affichageDetails = new StackPane();
		affichageDetails.getChildren().add(texteDetailsMeteore);
		Scene sceneDetailsMeteore = new Scene(affichageDetails,300,300);
		this.fenetreDetailsMeteore = new Stage();
		fenetreDetailsMeteore.setResizable(false);
		fenetreDetailsMeteore.setTitle("Details");
		fenetreDetailsMeteore.setScene(sceneDetailsMeteore);
		sceneDetailsMeteore.getStylesheets().add(VueOutilMeteore.class.getResource("decoration/fenetreDetails.css").toExternalForm());
		//fenetreDetailsMeteore.show();	
		/*-----------------------------------------------------------------------------------------------*/
		
		
		Scene scene = new Scene(racine, 591, 500);
		scene.getStylesheets().add(VueOutilMeteore.class.getResource("decoration/OutilMeteore.css").toExternalForm());
		scenePrincipale.setScene(scene);
		scenePrincipale.setResizable(false);
		
		
		/*--- Ajout Cercles meteores sur background ---*/
		racine.getChildren().add(panneauMeteore);	
		
		
		scenePrincipale.show();
		this.controleur = new ControleurOutilMeteores(this);
	}	

	public void afficherMarqueurMeteore(int id, float[] coordonnees)
	{
		float coordonneeX = coordonnees[0];
		float coordonneeY = coordonnees[1];
		
		
		Circle marqueurMeteore = new Circle();
		marqueurMeteore.setCenterX(coordonneeX);
		marqueurMeteore.setCenterY(coordonneeY);		
		marqueurMeteore.setRadius(3.8f);
		marqueurMeteore.setId(Integer.toString(id));
		marqueurMeteore.setFill(Color.RED);
		marqueurMeteore.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			@Override
			public void handle(MouseEvent e) 
			{
				controleur.clicMeteore(id);
			}
		});
		this.listMarqueursMeteore.add(marqueurMeteore);		
		this.panneauMeteore.getChildren().add(marqueurMeteore);		
	}
	
	public void afficherAlerte(String texte)
	{
		System.out.println(texte);
	}	
	
	public void afficherDetailsMeteore(Meteore meteore)
	{
		
		this.texteDetailsMeteore.setText(meteore.getDescription());
		fenetreDetailsMeteore.show();
		
	}
	
	
	
	

}
