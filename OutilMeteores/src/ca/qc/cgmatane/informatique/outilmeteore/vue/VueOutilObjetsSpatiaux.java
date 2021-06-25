package ca.qc.cgmatane.informatique.outilmeteore.vue;
import java.io.FileNotFoundException;

import org.omg.CORBA.PRIVATE_MEMBER;

import ca.qc.cgmatane.informatique.outilmeteore.action.ControleurOutilObjetsSpatiaux;
import ca.qc.cgmatane.informatique.outilmeteore.modele.ObjetSpatial;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
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

public class VueOutilObjetsSpatiaux extends Application {

	protected ControleurOutilObjetsSpatiaux controleur;
	//protected Image marqueurMeteore;
	/*protected Circle marqueurMeteoreTest1;
	protected Circle marqueurMeteoreTest2;
	protected Circle marqueurMeteoreTest3;*/
	protected StackPane racine;
	protected Stage fenetreDetails;
	protected Pane panneau;
	protected Stage fenetreAjouter;
	protected Text texteDetails;
	protected int compteurMeteoreClique;
	protected List<Circle> listMarqueurs;
	protected Button boutonAfficherFenetreAjouter;
	protected Button boutonModifierObjetSpatial;
	protected Button boutonSupprimerObjetSpatial;
	protected TextField nomChampAjouter;
	protected TextField coordonneeXChampAjouter;
	protected TextField coordonneeYChampAjouter;
	protected TextField masseChampAjouter;
	protected TextField anneeChampAjouter;
	protected TextField nomChampModifier;
	protected TextField coordonneeXChampModifier;
	protected TextField coordonneeYChampModifier;
	protected TextField masseChampModifier;
	protected TextField anneeChampModifier;	
	protected Alert alerte;
	
	public void start(Stage scenePrincipale) throws FileNotFoundException {		
				
		this.racine = new StackPane();
		this.panneau = new Pane();
		this.listMarqueurs = new ArrayList<Circle>();
		
		this.creerFenetreDetails();
		this.creerFenetreAjouterMeteore();
		
		this.boutonAfficherFenetreAjouter = new Button("Ajouter une météore");
		boutonAfficherFenetreAjouter.setTranslateY(200);
		boutonAfficherFenetreAjouter.setOnAction(value ->  {
			this.fenetreAjouter.show();
        });
		
		Scene scene = new Scene(racine, 1200, 600);
		scenePrincipale.setTitle("Crash !");
		scenePrincipale.getIcons().add(new Image("ca/qc/cgmatane/informatique/outilmeteore/vue/decoration/icon.png"));
		scene.getStylesheets().add(VueOutilObjetsSpatiaux.class.getResource("decoration/OutilMeteore.css").toExternalForm());
		scenePrincipale.setScene(scene);
		scenePrincipale.setResizable(false);
		
		
		/*--- Ajout Cercles meteores sur background ---*/
		racine.getChildren().add(panneau);
		racine.getChildren().add(boutonAfficherFenetreAjouter);
		
		this.alerte = new Alert(AlertType.NONE);
		
		
		scenePrincipale.show();
		this.controleur = new ControleurOutilObjetsSpatiaux(this);
	}	

	private void creerFenetreDetails() {
		this.boutonSupprimerObjetSpatial = new Button("Supprimer");
		/*boutonSupprimerObjetSpatial.setTranslateX(100);
		boutonSupprimerObjetSpatial.setTranslateY(100);*/

		this.boutonModifierObjetSpatial = new Button("Modifier");
		/*boutonModifierObjetSpatial.setTranslateX(0);
		boutonModifierObjetSpatial.setTranslateY(100);*/
		
		
		GridPane affichageDetails = new GridPane();
		affichageDetails.setAlignment(Pos.CENTER);
		affichageDetails.setPadding(new Insets(40, 40, 40, 40));
		affichageDetails.setHgap(10);
		affichageDetails.setVgap(10);
		ColumnConstraints columnOneConstraints = new ColumnConstraints(150, 100, Double.MAX_VALUE);
	    columnOneConstraints.setHalignment(HPos.RIGHT);
	    ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
	    columnTwoConstrains.setHgrow(Priority.ALWAYS);
	    affichageDetails.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
	    
	    Label nomLabel = new Label("Nom : ");
	    affichageDetails.add(nomLabel, 0,1);
	    this.nomChampModifier = new TextField();
	    affichageDetails.add(nomChampModifier, 1,1);
	    
	    Label coordonneeYLabel = new Label("Longitude : ");
	    affichageDetails.add(coordonneeYLabel, 0,2);
	    this.coordonneeYChampModifier = new TextField();
	    affichageDetails.add(coordonneeYChampModifier, 1,2);
	    
	    Label coordonneeXLabel = new Label("Latitude : ");
	    affichageDetails.add(coordonneeXLabel, 0,3);
	    this.coordonneeXChampModifier = new TextField();
	    affichageDetails.add(coordonneeXChampModifier, 1,3);    
	    
	    Label masseLabel = new Label("Masse (kg): ");
	    affichageDetails.add(masseLabel, 0,4);
	    this.masseChampModifier = new TextField();
	    affichageDetails.add(masseChampModifier, 1,4);
	    
	    Label anneeLabel = new Label("Année : ");
	    affichageDetails.add(anneeLabel, 0,5);
	    this.anneeChampModifier = new TextField();
	    affichageDetails.add(anneeChampModifier, 1,5);
	    
        affichageDetails.add(boutonModifierObjetSpatial, 0, 6, 2, 1);
        affichageDetails.add(boutonSupprimerObjetSpatial, 1, 6, 2, 1);
        GridPane.setHalignment(boutonModifierObjetSpatial, HPos.CENTER);
        GridPane.setHalignment(boutonSupprimerObjetSpatial, HPos.CENTER);
        GridPane.setMargin(boutonModifierObjetSpatial, new Insets(20, 0,20,0));
        GridPane.setMargin(boutonSupprimerObjetSpatial, new Insets(20, 0,20,0));
        
		Scene sceneDetails = new Scene(affichageDetails,500,500);
		this.fenetreDetails = new Stage();
		fenetreDetails.getIcons().add(new Image("ca/qc/cgmatane/informatique/outilmeteore/vue/decoration/icon_details.png"));
		fenetreDetails.setResizable(false);
		fenetreDetails.setTitle("Détails");
		fenetreDetails.setScene(sceneDetails);
		sceneDetails.getStylesheets().add(VueOutilObjetsSpatiaux.class.getResource("decoration/fenetreDetails.css").toExternalForm());
		//fenetreDetailsMeteore.show();
        

        	
    }
	
	private void creerFenetreAjouterMeteore() {	
		
		GridPane affichageAjouterMeteore = new GridPane();
		affichageAjouterMeteore.setAlignment(Pos.CENTER);
		affichageAjouterMeteore.setPadding(new Insets(40, 40, 40, 40));
		affichageAjouterMeteore.setHgap(10);
		affichageAjouterMeteore.setVgap(10);
		ColumnConstraints columnOneConstraints = new ColumnConstraints(150, 100, Double.MAX_VALUE);
	    columnOneConstraints.setHalignment(HPos.RIGHT);
	    ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
	    columnTwoConstrains.setHgrow(Priority.ALWAYS);
	    affichageAjouterMeteore.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
	    
	    Label nomLabel = new Label("Nom : ");
	    affichageAjouterMeteore.add(nomLabel, 0,1);
	    this.nomChampAjouter = new TextField();
	    affichageAjouterMeteore.add(nomChampAjouter, 1,1);
	    
	    Label coordonneeYLabel = new Label("Longitude : ");
	    affichageAjouterMeteore.add(coordonneeYLabel, 0,2);
	    this.coordonneeYChampAjouter = new TextField();
	    affichageAjouterMeteore.add(coordonneeYChampAjouter, 1,2);
	    
	    Label coordonneeXLabel = new Label("Latitude : ");
	    affichageAjouterMeteore.add(coordonneeXLabel, 0,3);
	    this.coordonneeXChampAjouter = new TextField();
	    affichageAjouterMeteore.add(coordonneeXChampAjouter, 1,3);    
	    
	    Label masseLabel = new Label("Masse (kg): ");
	    affichageAjouterMeteore.add(masseLabel, 0,4);
	    this.masseChampAjouter = new TextField();
	    affichageAjouterMeteore.add(masseChampAjouter, 1,4);
	    
	    Label anneeLabel = new Label("Année : ");
	    affichageAjouterMeteore.add(anneeLabel, 0,5);
	    this.anneeChampAjouter = new TextField();
	    affichageAjouterMeteore.add(anneeChampAjouter, 1,5);
	    

        Button boutonAjouter = new Button("Ajouter");
        boutonAjouter.setDefaultButton(true);
        affichageAjouterMeteore.add(boutonAjouter, 0, 6, 2, 1);
        GridPane.setHalignment(boutonAjouter, HPos.CENTER);
        GridPane.setMargin(boutonAjouter, new Insets(20, 0,20,0));
        
        boutonAjouter.setOnAction(value ->  {
        	boolean succes = this.controleur.ajouterObjet(nomChampAjouter.getText(), coordonneeXChampAjouter.getText(), coordonneeYChampAjouter.getText(), masseChampAjouter.getText(), anneeChampAjouter.getText());
        	if(succes) {
        		nomChampAjouter.clear();
            	coordonneeXChampAjouter.clear();
            	coordonneeYChampAjouter.clear();
            	masseChampAjouter.clear();
            	anneeChampAjouter.clear();
            	fenetreAjouter.close();
        	}
        });
        
		Scene sceneAjouteMeteore = new Scene(affichageAjouterMeteore,500,500);
		this.fenetreAjouter = new Stage();
		fenetreAjouter.getIcons().add(new Image("ca/qc/cgmatane/informatique/outilmeteore/vue/decoration/icon_details.png"));
		fenetreAjouter.setResizable(false);
		fenetreAjouter.setTitle("Ajouter une meteore");
		fenetreAjouter.setScene(sceneAjouteMeteore);
		sceneAjouteMeteore.getStylesheets().add(VueOutilObjetsSpatiaux.class.getResource("decoration/fenetreDetails.css").toExternalForm());
		//fenetreAjouterMeteore.show();
	}
	
	public void nettoyerPanneauMarqueur() {
		this.panneau.getChildren().clear();
		this.listMarqueurs.clear();
	}
	
	public void afficherMarqueur(ObjetSpatial objet, float[] coordonnees) {
		float coordonneeX = coordonnees[0];
		float coordonneeY = coordonnees[1];
		
		
		Circle marqueur = new Circle();
		marqueur.setCenterX(coordonneeX);
		marqueur.setCenterY(coordonneeY);		
		marqueur.setRadius(2.2f);
		marqueur.setId(Integer.toString(objet.getId()));
		if(objet.getEstCreeOuModifie()) {
			marqueur.setFill(Color.GREEN);
		} else {
			marqueur.setFill(Color.RED);
		}		
		marqueur.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				controleur.clicObjetSpatial(objet.getId());
			}
		});
		this.listMarqueurs.add(marqueur);		
		this.panneau.getChildren().add(marqueur);		
	}
	
	public void afficherAlerte(String texte) {
		this.alerte.setAlertType(AlertType.WARNING);
		this.alerte.setContentText(texte);
		this.alerte.show();
	}	
	
	public void afficherDetails(ObjetSpatial objet) {
		
		String[] coord = objet.getPosition().split(", ");
		this.nomChampModifier.setText(objet.getNom());
		this.coordonneeYChampModifier.setText(coord[0]);
		this.coordonneeXChampModifier.setText(coord[1]);
		this.masseChampModifier.setText("" + objet.getMasse());
		this.anneeChampModifier.setText(objet.getAnnee());
		this.boutonModifierObjetSpatial.setOnAction(value ->  {
			boolean succes = this.controleur.modifierObjetSpatial(objet.getId(),nomChampModifier.getText(), coordonneeXChampModifier.getText(), coordonneeYChampModifier.getText(), masseChampModifier.getText(), anneeChampModifier.getText());
			if(succes) {
            	fenetreDetails.close();
        	}
		});
		this.boutonSupprimerObjetSpatial.setOnAction(value ->  {
			this.controleur.supprimerObjetSpatial(objet.getId());
			fenetreDetails.close();
        });
		fenetreDetails.show();	
	}
}
