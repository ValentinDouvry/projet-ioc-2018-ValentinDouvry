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

import ca.qc.cgmatane.informatique.outilmeteore.modele.HashMeteore;
import ca.qc.cgmatane.informatique.outilmeteore.modele.Meteore;

public class MeteoreDaoImplementation implements MeteoresDao
{
	protected int id;
	protected HashMeteore hashMeteores;
	private static MeteoreDaoImplementation INSTANCE = null;

	
	private MeteoreDaoImplementation() 
	{
		hashMeteores = new HashMeteore();		
	}
	
	public static MeteoreDaoImplementation getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new MeteoreDaoImplementation();
		}
		return INSTANCE;
	}
	
	
	@Override
	public HashMeteore recupererTouteLesMeteores() 
	{
		String xmlMeteores = "";
		URL urlDataNasa;
		try 
		{
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
		try 
		{
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
			
			//for(int position = 0; position < noeudListeMeteore.getLength(); position++)
			for(int position = 0; position < 200; position++)
			{
				Node noeudMeteore = noeudListeMeteore.item(position);
				Element elementMeteore = (Element)noeudMeteore;
				
				/*-------------------------------------------------------------------------------------------------*/
				/*Recuperation parametres meteores depuis XML*/
				Node noeudNom = elementMeteore.getElementsByTagName("name").item(0);
				Element elementNom = (Element)noeudNom;
				String nom = elementNom.getTextContent();
				
				String positionMeteore;
				Node noeudPosition = elementMeteore.getElementsByTagName("geolocation").item(0);
				Element elementPosition = (Element)noeudPosition;
				if(elementPosition != null)
				{
					positionMeteore = elementPosition.getTextContent();
					positionMeteore = positionMeteore.replace("POINT ", "");
					positionMeteore = positionMeteore.replace(" ", " ; ");
				}
				else
				{
					positionMeteore = "Inconnue";
				}					
				
				/*Node noeudId = elementMeteore.getElementsByTagName("id").item(0);
				Element elementId = (Element)noeudId;
				int id = Integer.parseInt(elementId.getTextContent());*/
				
				String annee;
				Node noeudAnnee = elementMeteore.getElementsByTagName("year").item(0);
				Element elementAnnee = (Element)noeudAnnee;
				if(elementAnnee != null)
				{
					annee = elementAnnee.getTextContent();
				}
				else 
				{
					annee = "Inconnue";
				}			
				
				float masse;
				Node noeudMasse = elementMeteore.getElementsByTagName("mass").item(0);
				Element elementMasse = (Element)noeudMasse;
				if(elementMasse != null)
				{
					 masse = Float.parseFloat(elementMasse.getTextContent());
				}
				else
				{
					masse = 0;
				}							
				
				Node noeudCoordonneesX = elementMeteore.getElementsByTagName("reclat").item(0);
				Element elementCoordonneesX = (Element)noeudCoordonneesX;
				float coordonneesX;
				
				if(elementCoordonneesX !=null)
				{
					coordonneesX = Float.parseFloat(elementCoordonneesX.getTextContent());
				}
				else
				{
					coordonneesX = -9999;
				}				
				
				float coordonneesY;
				Node noeudCoordonneesY = elementMeteore.getElementsByTagName("reclong").item(0);
				Element elementCoordonneesY = (Element)noeudCoordonneesY;
				
				if(elementCoordonneesY !=null)
				{
					coordonneesY = Float.parseFloat(elementCoordonneesY.getTextContent());
				}
				else 
				{
					coordonneesY = -9999;	
				}				
				/*-------------------------------------------------------------------------------------------------*/
				
				/*--- Ajustement coordonnees par rapport a l'image---*/
				float[] coordonnees = {0,0};
								
				coordonnees[0] = 295 + ((coordonneesY * 295)/180);
				coordonnees[1] = 250 - ((coordonneesX * 250)/180);
				
				
				/*-------------------------------------------------------------------------------------*/
				/*Creation meteores et ajout au Hash*/
				Meteore meteore = new Meteore(coordonnees, id, masse, nom, annee, positionMeteore);
			
				if(coordonneesX != -9999 && coordonneesY != -9999 && masse != 0)
				{
					hashMeteores.ajouter(meteore, id);
					id++;
				}
			
			}
		}
		catch (FileNotFoundException e) 
		{
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
		
		return hashMeteores;
	}	

}
