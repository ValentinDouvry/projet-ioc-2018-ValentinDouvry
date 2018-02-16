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
		
		/* Test marqueur en image
		Image marqueurMeteore =  new Image(new FileInputStream("decoration/marqueurMeteore.png"));
		ImageView marqueurMeteoreView = new ImageView(marqueurMeteore);
		marqueurMeteoreView.setX(200);
		marqueurMeteoreView.setY(100);
		marqueurMeteoreView.setFitHeight();
		marqueurMeteoreView.setWidth();
		*/		
				
		
		/* Construction des cercles test pour les marqueurs de meteorites*/
		/*this.marqueurMeteoreTest1 = new Circle();
		marqueurMeteoreTest1.setCenterX(800f);
		marqueurMeteoreTest1.setCenterY(150f);
		
		marqueurMeteoreTest1.setRadius(5f);
		marqueurMeteoreTest1.setId("1");
		marqueurMeteoreTest1.setFill(Color.GREEN);		
		
		this.marqueurMeteoreTest2 = new Circle();
		marqueurMeteoreTest2.setCenterX(500f);
		marqueurMeteoreTest2.setCenterY(25f);
		marqueurMeteoreTest2.setRadius(5f);
		marqueurMeteoreTest2.setId("2");
		marqueurMeteoreTest2.setFill(Color.GREEN);		
		
		this.marqueurMeteoreTest3 = new Circle();		
		marqueurMeteoreTest3.setCenterX(70f);
		marqueurMeteoreTest3.setCenterY(100f);
		marqueurMeteoreTest3.setRadius(5f);
		marqueurMeteoreTest3.setId("3");
		marqueurMeteoreTest3.setFill(Color.GREEN);*/
		/*------------------------------------------------------------------------------------------*/
		
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
		
		
		Scene scene = new Scene(racine, 1270, 675);
		scene.getStylesheets().add(VueOutilMeteore.class.getResource("decoration/OutilMeteore.css").toExternalForm());
		scenePrincipale.setScene(scene);
		scenePrincipale.setResizable(false);
		
		
		/*--- Ajout Cercles meteores sur background ---*/
		
		/*panneauMeteore.getChildren().add(marqueurMeteoreTest1);
		panneauMeteore.getChildren().add(marqueurMeteoreTest2);
		panneauMeteore.getChildren().add(marqueurMeteoreTest3);*/
		racine.getChildren().add(panneauMeteore);
		
		
		
		/*---------------------------------------------------------------------------------*/
		
		
		
		/*--- Ajout EventHandler pour le clic des cercles ---*/
		
		//racine.getChildren().add(new Pane(marqueurMeteoreTest1));
		/*marqueurMeteoreTest1.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			@Override
			public void handle(MouseEvent e) 
			{
				//afficherDetailsMeteore();
				compteurMeteoreClique++;
				if(compteurMeteoreClique == 3)
				{
					afficherAlerte("Les meteores proches sont : " );
					compteurMeteoreClique 0= 0;
				}
			}
		});*/		
		
		//racine.getChildren().add(new Pane(marqueurMeteoreTest2));
		/*marqueurMeteoreTest2.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			@Override
			public void handle(MouseEvent e) 
			{
				//afficherDetailsMeteore();
				compteurMeteoreClique++;
				if(compteurMeteoreClique == 3)
				{
					
					afficherAlerte("Les meteores proches sont : " );
					compteurMeteoreClique = 0;
				}
			}
		});*/
		
		//racine.getChildren().add(new Pane(marqueurMeteoreTest3));		
		/*marqueurMeteoreTest3.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			@Override
			public void handle(MouseEvent e) 
			{
				//afficherDetailsMeteore();
				compteurMeteoreClique++;
				if(compteurMeteoreClique == 3)
				{
					
					afficherAlerte("Les meteores proches sont : " );
					compteurMeteoreClique = 0;
				}
			}
		});*/
		
		/*-------------------------------------------------------------------------------------*/
		
		scenePrincipale.show();
		this.controleur = new ControleurOutilMeteores(this);
	}
	
	
	
	

	public void afficherMarqueurMeteore(int id, int[] coordonnees)
	{
		int coordonneeX = coordonnees[0];
		int coordonneeY = coordonnees[1];
		
		
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
				afficherDetailsMeteore(controleur.listeMeteore.get(id-1));
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
