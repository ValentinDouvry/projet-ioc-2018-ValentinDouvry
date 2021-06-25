package ca.qc.cgmatane.informatique.outilmeteore.action;

import ca.qc.cgmatane.informatique.outilmeteore.vue.VueOutilObjetsSpatiaux;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ca.qc.cgmatane.informatique.outilmeteore.dao.ObjetsSpatiauxDaoImplementation;
import ca.qc.cgmatane.informatique.outilmeteore.dao.ObjetsSpatiauxDao;
import ca.qc.cgmatane.informatique.outilmeteore.modele.HashObjetsSpatiaux;
import ca.qc.cgmatane.informatique.outilmeteore.modele.ObjetSpacial;
import ca.qc.cgmatane.informatique.outilmeteore.modele.ObjetSpatialFactory;

public class ControleurOutilObjetsSpatiaux {
	protected VueOutilObjetsSpatiaux vue;
	protected ObjetsSpatiauxDaoImplementation objetsSpatiauxDaoImplementation;
	protected HashObjetsSpatiaux hashObjetsSpatiaux;
	
	public ControleurOutilObjetsSpatiaux(VueOutilObjetsSpatiaux vue) {
		this.vue = vue;
		objetsSpatiauxDaoImplementation = ObjetsSpatiauxDaoImplementation.getInstance(this);		
		hashObjetsSpatiaux = objetsSpatiauxDaoImplementation.recupererTouteLesMeteores();
		
		for (int compteur = 0; compteur < hashObjetsSpatiaux.getTaille(); compteur++) {
			if(hashObjetsSpatiaux.getObjetSpatial(compteur) != null) {
				vue.afficherMarqueur(hashObjetsSpatiaux.getObjetSpatial(compteur).getId(), hashObjetsSpatiaux.getObjetSpatial(compteur).getCoordonnees(), false);				
			}
		}
	}
	
	public void clicObjetSpatial(int id) {
		vue.afficherDetails(hashObjetsSpatiaux.getObjetSpatial(id));
	}
	
	public boolean ajouterObjet(String champNom, String champCoordonneeX, String champCoordonneeY, String champMasse, String champAnnee) {
		
		if (champNom.isEmpty() || champCoordonneeX.isEmpty() || champCoordonneeY.isEmpty() || champMasse.isEmpty() || champAnnee.isEmpty()) {
			this.afficherAlerte("Veuillez remplir les champs !");
			return false;
		} else {
			try {
				float coordonneesX = Float.parseFloat(champCoordonneeX);
				float coordonneesY = Float.parseFloat(champCoordonneeY);
				float masse = Float.parseFloat(champMasse);
				
				int id = this.hashObjetsSpatiaux.getIdDernierObjetSpacial() + 1;
				
				/*--- Ajustement coordonnees par rapport a l'image---*/
				float[] coordonnees = {0,0};
				coordonnees[0] =  (int) ((1200/360.0) * (180 + coordonneesY)); // LONG
				coordonnees[1] =  (int) ((600/180.0) * (90 - coordonneesX)); // LAT
				
				String positionMeteore = "(" + coordonneesX + ", " + coordonneesY + ")";
				
				ObjetSpacial meteore = ObjetSpatialFactory.getObjetSpacial("Meteore", coordonnees, id, masse, champNom, champAnnee, positionMeteore);
				this.hashObjetsSpatiaux.ajouter(meteore, id);				
				this.vue.afficherMarqueur(hashObjetsSpatiaux.getObjetSpatial(id).getId(), hashObjetsSpatiaux.getObjetSpatial(id).getCoordonnees(), true);
			} catch (Exception e) {
				this.afficherAlerte("Les coordonn�es et la masse doivent �tre des chiffres !");
				return false;
			}
		}
		return true;
	}
	
	public void afficherAlerte(String texte) {
		this.vue.afficherAlerte(texte);
	}
	
	
	
	
}
