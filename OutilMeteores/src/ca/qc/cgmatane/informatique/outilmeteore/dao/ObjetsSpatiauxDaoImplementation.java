package ca.qc.cgmatane.informatique.outilmeteore.dao;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ca.qc.cgmatane.informatique.outilmeteore.action.ControleurOutilObjetsSpatiaux;
import ca.qc.cgmatane.informatique.outilmeteore.modele.HashObjetsSpatiaux;
import ca.qc.cgmatane.informatique.outilmeteore.modele.ObjetSpatial;
import ca.qc.cgmatane.informatique.outilmeteore.modele.ObjetSpatialFactory;

public class ObjetsSpatiauxDaoImplementation implements ObjetsSpatiauxDao {
	protected int id;
	protected HashObjetsSpatiaux hashObjetsSpatiaux;
	private static ObjetsSpatiauxDaoImplementation INSTANCE = null;
	protected ControleurOutilObjetsSpatiaux controlleur;

	
	private ObjetsSpatiauxDaoImplementation(ControleurOutilObjetsSpatiaux controleur) {
		hashObjetsSpatiaux = new HashObjetsSpatiaux();
		this.controlleur = controleur;
	}
	
	public static ObjetsSpatiauxDaoImplementation getInstance(ControleurOutilObjetsSpatiaux controleur) {
		if(INSTANCE == null) {
			INSTANCE = new ObjetsSpatiauxDaoImplementation(controleur);
		}
		return INSTANCE;
	}
	
	@Override
	public HashObjetsSpatiaux recupererToutLesObjetsSpatiaux() {
		// recupererAutresObjetSpatiaux(); (satelites) TODO
		return this.recupererTouteLesMeteores();
	}
	
	
	public HashObjetsSpatiaux recupererTouteLesMeteores() {
		System.out.println("Récupération des météores en ligne");
		
		String xmlMeteores = "";
		URL urlDataNasa;
		try {
			urlDataNasa = new URL("https://data.nasa.gov/resource/y77d-th95.xml");
			BufferedReader influx = new BufferedReader(new InputStreamReader(urlDataNasa.openStream()));
			String ligne;
			while ((ligne = influx.readLine()) != null) xmlMeteores+=ligne;
			influx.close();
		} 
		catch (MalformedURLException e) { e.printStackTrace();} 
		catch (IOException e) { e.printStackTrace(); }	
		
		xmlMeteores = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>" + xmlMeteores;
		//System.out.println(xmlMeteores);
		try {
			id = 0;
			
			/*--- Test depuis fichier XML sur le disque ---*/
			/*File file = new File("c:\\file-utf.xml");
			InputStream inputStream;
			Reader reader;
			inputStream = new FileInputStream(file);
			reader = new InputStreamReader(inputStream,"UTF-8");
			InputSource is = new InputSource(reader);*/
			/*---------------------------------------------------------------*/
			
			DocumentBuilder parseur;
			parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document docListeMeteore = parseur.parse(new ByteArrayInputStream(xmlMeteores.getBytes()));			
			NodeList noeudListeMeteore = docListeMeteore.getElementsByTagName("row");
			
			System.out.println(noeudListeMeteore.getLength() + " éléments présents dans le XML");
			//for(int position = 0; position < 200; position++)
			for(int position = 0; position < noeudListeMeteore.getLength(); position++) {
				Node noeudMeteore = noeudListeMeteore.item(position);
				Element elementMeteore = (Element)noeudMeteore;
				
				/*-------------------------------------------------------------------------------------------------*/
				/*Recuperation parametres meteores depuis XML*/
				Node noeudNom = elementMeteore.getElementsByTagName("name").item(0);
				Element elementNom = (Element)noeudNom;
				String nom = elementNom.getTextContent();			
				
				/*Node noeudId = elementMeteore.getElementsByTagName("id").item(0);
				Element elementId = (Element)noeudId;
				int id = Integer.parseInt(elementId.getTextContent());*/
				
				String annee;
				Node noeudAnnee = elementMeteore.getElementsByTagName("year").item(0);
				Element elementAnnee = (Element)noeudAnnee;
				if(elementAnnee != null) {
					annee = elementAnnee.getTextContent();
				}
				else {
					annee = "Inconnue";
				}			
				
				float masse;
				Node noeudMasse = elementMeteore.getElementsByTagName("mass").item(0);
				Element elementMasse = (Element)noeudMasse;
				if(elementMasse != null) {
					 masse = Float.parseFloat(elementMasse.getTextContent());
				}
				else {
					masse = 0;
				}							
				
				String positionMeteore;
				
				float coordonneesX;
				Node noeudCoordonneesX = elementMeteore.getElementsByTagName("reclat").item(0);
				Element elementCoordonneesX = (Element)noeudCoordonneesX;
				
				float coordonneesY;
				Node noeudCoordonneesY = elementMeteore.getElementsByTagName("reclong").item(0);
				Element elementCoordonneesY = (Element)noeudCoordonneesY;
				
				if(elementCoordonneesX != null && elementCoordonneesY != null) {
					coordonneesX = Float.parseFloat(elementCoordonneesX.getTextContent());
					coordonneesY = Float.parseFloat(elementCoordonneesY.getTextContent());
					positionMeteore = elementCoordonneesX.getTextContent() + ", " + elementCoordonneesY.getTextContent();
				}
				else {
					coordonneesX = -9999;
					coordonneesY = -9999;
					positionMeteore = "Inconnue";
				}
				/*-------------------------------------------------------------------------------------------------*/				
				/*--- Ajustement coordonnees par rapport a l'image---*/
				float[] coordonnees = {0,0};			
				
				coordonnees[0] =  (int) ((1200/360.0) * (180 + coordonneesY)); // LONG
				coordonnees[1] =  (int) ((600/180.0) * (90 - coordonneesX)); // LAT				
				/*-------------------------------------------------------------------------------------------------*/
				
				if(coordonneesX != -9999 && coordonneesY != -9999 && masse != 0) {
					/*Creation meteores et ajout au Hash*/
					ObjetSpatial meteore = ObjetSpatialFactory.getObjetSpatial("Meteore",coordonnees, id, masse, nom, annee, positionMeteore, false);
					hashObjetsSpatiaux.ajouter(meteore, id);
					id++;
				}
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return hashObjetsSpatiaux;
	}	

}
