package ca.qc.cgmatane.informatique.outilmeteore.vue;
import java.io.FileNotFoundException;

import org.omg.CORBA.PRIVATE_MEMBER;

import ca.qc.cgmatane.informatique.outilmeteore.action.ControleurOutilMeteores;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;




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
	
	
	

	public void start(Stage scenePrincipale) throws FileNotFoundException 
	{
		
				
		this.racine = new StackPane();
		this.panneauMeteore = new Pane();
		
		/* Test marqueur en image
		Image marqueurMeteore =  new Image(new FileInputStream("decoration/marqueurMeteore.png"));
		ImageView marqueurMeteoreView = new ImageView(marqueurMeteore);
		marqueurMeteoreView.setX(200);
		marqueurMeteoreView.setY(100);
		marqueurMeteoreView.setFitHeight();
		marqueurMeteoreView.setWidth();
		*/		
				
		
		/* Construction des cercles test pour les marqueurs de meteorites*/
		this.marqueurMeteoreTest1 = new Circle();
		marqueurMeteoreTest1.setCenterX(800f);
		marqueurMeteoreTest1.setCenterY(150f);
		
		marqueurMeteoreTest1.setRadius(5f);
		marqueurMeteoreTest1.setId("1");
		marqueurMeteoreTest1.setFill(javafx.scene.paint.Color.GREEN);		
		
		this.marqueurMeteoreTest2 = new Circle();
		marqueurMeteoreTest2.setCenterX(500f);
		marqueurMeteoreTest2.setCenterY(25f);
		marqueurMeteoreTest2.setRadius(5f);
		marqueurMeteoreTest2.setId("2");
		marqueurMeteoreTest2.setFill(javafx.scene.paint.Color.GREEN);		
		
		this.marqueurMeteoreTest3 = new Circle();		
		marqueurMeteoreTest3.setCenterX(70f);
		marqueurMeteoreTest3.setCenterY(100f);
		marqueurMeteoreTest3.setRadius(5f);
		marqueurMeteoreTest3.setId("3");
		marqueurMeteoreTest3.setFill(javafx.scene.paint.Color.GREEN);		
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
		
		
		Scene scene = new Scene(racine, 960, 491);
		scene.getStylesheets().add(VueOutilMeteore.class.getResource("decoration/OutilMeteore.css").toExternalForm());
		scenePrincipale.setScene(scene);		
		
		
		/*--- Ajout Cercles meteores sur background ---*/
		
		panneauMeteore.getChildren().add(marqueurMeteoreTest1);
		panneauMeteore.getChildren().add(marqueurMeteoreTest2);
		panneauMeteore.getChildren().add(marqueurMeteoreTest3);
		racine.getChildren().add(panneauMeteore);	
		
		/*---------------------------------------------------------------------------------*/
		
		
		
		/*--- Ajout EventHandler pour le clic des cercles ---*/
		
		//racine.getChildren().add(new Pane(marqueurMeteoreTest1));
		marqueurMeteoreTest1.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() 
		{
			@Override
			public void handle(javafx.scene.input.MouseEvent e) 
			{
				afficherDetailsMeteore("Description meteore numero 1");
				compteurMeteoreClique++;
				if(compteurMeteoreClique == 3)
				{
					afficherAlerte("Les meteores proches sont : " );
					compteurMeteoreClique = 0;
				}
			}
		});		
		
		//racine.getChildren().add(new Pane(marqueurMeteoreTest2));
		marqueurMeteoreTest2.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() 
		{
			@Override
			public void handle(javafx.scene.input.MouseEvent e) 
			{
				afficherDetailsMeteore("Description meteore numero 2");
				compteurMeteoreClique++;
				if(compteurMeteoreClique == 3)
				{
					
					afficherAlerte("Les meteores proches sont : " );
					compteurMeteoreClique = 0;
				}
			}
		});
		
		//racine.getChildren().add(new Pane(marqueurMeteoreTest3));		
		marqueurMeteoreTest3.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() 
		{
			@Override
			public void handle(javafx.scene.input.MouseEvent e) 
			{
				afficherDetailsMeteore("Description meteore numero 3");
				compteurMeteoreClique++;
				if(compteurMeteoreClique == 3)
				{
					
					afficherAlerte("Les meteores proches sont : " );
					compteurMeteoreClique = 0;
				}
			}
		});
		
		/*-------------------------------------------------------------------------------------*/
		
		scenePrincipale.show();
		this.controleur = new ControleurOutilMeteores(this);
	}
	
	
	
	

	public void afficherMarqueurMeteore(int id,int[] coordonnees)
	{
		
		int coordonneeX = coordonnees[0];
		int coordonneeY = coordonnees[1];
		
		if(id == 1)
		{
			marqueurMeteoreTest1.setCenterX(coordonneeX);
			marqueurMeteoreTest1.setCenterY(coordonneeY);
		}
		else if(id == 2)
		{
			marqueurMeteoreTest2.setCenterX(coordonneeX);
			marqueurMeteoreTest2.setCenterY(coordonneeY);
		}
		else if(id == 3)
		{
			marqueurMeteoreTest3.setCenterX(coordonneeX);
			marqueurMeteoreTest3.setCenterY(coordonneeY);
		}
		
		
		
	}
	
	public void afficherAlerte(String texte)
	{
		System.out.println(texte);
	}
	
	
	
	public void afficherDetailsMeteore(String texteDescription)
	{
		
		this.texteDetailsMeteore.setText(texteDescription);
		fenetreDetailsMeteore.show();
		
	}
	
	

}
