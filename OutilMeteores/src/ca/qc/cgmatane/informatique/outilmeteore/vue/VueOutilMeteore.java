package ca.qc.cgmatane.informatique.outilmeteore.vue;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import ca.qc.cgmatane.informatique.outilmeteore.action.ControleurOutilMeteores;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;




public class VueOutilMeteore extends Application
{

	protected ControleurOutilMeteores controleur;
	//protected Image marqueurMeteore;
	protected Circle marqueurMeteore;
	
	
	public VueOutilMeteore()
	{
		this.controleur = new ControleurOutilMeteores(this);
	}

	public void start(Stage scenePrincipale) throws FileNotFoundException 
	{
		
		/*EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() 
		{
			public void handle(MouseEvent event)
			{
				System.out.println("Hello ");
			}
		};*/
				
		StackPane racine = new StackPane();
		
		/* Test marqueur en image
		Image marqueurMeteore =  new Image(new FileInputStream("decoration/marqueurMeteore.png"));
		ImageView marqueurMeteoreView = new ImageView(marqueurMeteore);
		marqueurMeteoreView.setX(200);
		marqueurMeteoreView.setY(100);
		marqueurMeteoreView.setFitHeight();
		marqueurMeteoreView.setWidth();
		*/
		
		Circle marqueurMeteore = new Circle();
		marqueurMeteore.setCenterX(100f);
		marqueurMeteore.setCenterY(200f);
		marqueurMeteore.setRadius(5f);
		marqueurMeteore.setFill(javafx.scene.paint.Color.DARKSEAGREEN);
		marqueurMeteore.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
			@Override
			public void handle(javafx.scene.input.MouseEvent e) {
				System.out.println("Yay");
			}
		});
		
		
		
		Scene scene = new Scene(racine, 960, 491);
		scene.getStylesheets().add(VueOutilMeteore.class.getResource("decoration/OutilMeteore.css").toExternalForm());
		scenePrincipale.setScene(scene);
		racine.getChildren().add(marqueurMeteore);
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
