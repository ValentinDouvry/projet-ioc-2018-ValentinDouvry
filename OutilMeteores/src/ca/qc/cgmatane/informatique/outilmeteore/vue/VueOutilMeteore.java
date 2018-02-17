package ca.qc.cgmatane.informatique.outilmeteore.vue;
import ca.qc.cgmatane.informatique.outilmeteore.Meteore;
import java.io.FileNotFoundException;

import org.omg.CORBA.PRIVATE_MEMBER;

import ca.qc.cgmatane.informatique.outilmeteore.action.ControleurOutilMeteores;
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
		this.texteDetailsMeteore = new Text();
		StackPane affichageDetails = new StackPane();
		affichageDetails.getChildren().add(texteDetailsMeteore);
		Scene sceneDetailsMeteore = new Scene(affichageDetails,300,300);		
		this.fenetreDetailsMeteore = new Stage();
		fenetreDetailsMeteore.setTitle("Details");
		fenetreDetailsMeteore.setScene(sceneDetailsMeteore);
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
		
		
		Circle marqueurMeteoreTest = new Circle();
		marqueurMeteoreTest.setCenterX(coordonneeX);
		marqueurMeteoreTest.setCenterY(coordonneeY);		
		marqueurMeteoreTest.setRadius(5f);
		marqueurMeteoreTest.setId(Integer.toString(id));
		marqueurMeteoreTest.setFill(Color.GREEN);
		marqueurMeteoreTest.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			@Override
			public void handle(MouseEvent e) 
			{
				afficherDetailsMeteore(dao.MeteoreDaoImplementation.listeMeteores.get(id-1));
				compteurMeteoreClique++;
				if(compteurMeteoreClique == 3)
				{
					afficherAlerte("Les meteores proches sont : " );
					compteurMeteoreClique = 0;
				}
			}
		});
		this.listMarqueursMeteore.add(marqueurMeteoreTest);
		
		
		
		this.panneauMeteore.getChildren().add(marqueurMeteoreTest);
		//this.racine.getChildren().add(panneauMeteore);
		
		
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
