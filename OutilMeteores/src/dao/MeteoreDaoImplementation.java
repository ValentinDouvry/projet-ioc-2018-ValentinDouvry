package dao;

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

import ca.qc.cgmatane.informatique.outilmeteore.Meteore;

public class MeteoreDaoImplementation implements MeteoresDao
{
	protected int id;
	protected Map<Integer,Meteore> hashMapMeteores;

	
	public MeteoreDaoImplementation() 
	{
		hashMapMeteores = new HashMap<Integer,Meteore>();		
	}
	
	
	@Override
	public Map<Integer,Meteore> recupererTouteLesMeteores() 
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
			String racine = docListeMeteore.getDocumentElement().getNodeName();
			
			NodeList noeudListeMeteore = docListeMeteore.getElementsByTagName("row");
			
			for(int position = 0; position < noeudListeMeteore.getLength(); position++)
			{
				Node noeudMeteore = noeudListeMeteore.item(position);
				Element elementMeteore = (Element)noeudMeteore;
				
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
				
				/*--- Ajustement coordonnees par rapport a l'image---*/
				float[] coordonnees = {0,0};
				/*coordonnees[0] = coordonneesX;
				coordonnees[1] = coordonneesY;*/
				
				float a = coordonneesY;
				float b = (float) Math.tan(coordonneesX);
				
				float minA = -180;
				float minB = 0;
				float maxA = 180;
				float maxB = 90;
				
				float h = 591;
				float w = 500;
				
				float s_a = w /(maxA - minA);
				float o_a = -w * minA / (maxA - minA);
				float s_b = -h / (maxB - minB);
				float o_b = h * maxB / (maxB - minB);
				
				float x = s_a * a + o_a;
				float y = s_b * b + o_b;
				
				coordonnees[0] = x;
				coordonnees[1] = y;
				/*-------------------------------------------------------------------------------------*/
				
				Meteore meteore = new Meteore(coordonnees, id, masse, nom, annee, positionMeteore);
				if(coordonneesX != -9999 && coordonneesY != -9999 && masse != 0)
				{
					hashMapMeteores.put(id, meteore);
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
		
		return hashMapMeteores;
	}	

	@Override
	public Meteore getMeteore() {
		return null;
	}

	@Override
	public void miseAJourMeteores(Meteore meteore) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerMeteore(Meteore meteore) {
		// TODO Auto-generated method stub
		
	}

}
