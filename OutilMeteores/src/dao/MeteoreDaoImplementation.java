package dao;

import java.io.BufferedReader;
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
import java.util.ArrayList;
import java.util.List;

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
	public static List<Meteore> listeMeteores;

	
	public MeteoreDaoImplementation() 
	{
		listeMeteores = new ArrayList<Meteore>();
		
	}
	
	
	@Override
	public List<Meteore> recupererTouteLesMeteores() 
	{
		/*String xmlMeteores = "";
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
		catch (IOException e) { e.printStackTrace(); }*/
		
		
		
		/*try {
			DocumentBuilder parseur;
			parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document docListeMeteore = parseur.parse(new StringBufferInputStream(xmlMeteores));
			String racine = docListeMeteore.getDocumentElement().getNodeName();
			
			NodeList noeudListeMeteore = docListeMeteore.getElementsByTagName("row");
			
			for(int position = 0; position < noeudListeMeteore.getLength(); position++)
			{
				Node noeudMeteore = noeudListeMeteore.item(position);
				Element elementMeteore = (Element)noeudMeteore;
				
				Node noeudNom = elementMeteore.getElementsByTagName("name").item(0);
				Element elementNom = (Element)noeudNom;
				String nom = elementNom.getTextContent();
				
				Node noeudId = elementMeteore.getElementsByTagName("id").item(0);
				Element elementId = (Element)noeudId;
				int id = Integer.parseInt(elementId.getTextContent());
				
				Node noeudAnnee = elementMeteore.getElementsByTagName("year").item(0);
				Element elementAnnee = (Element)noeudAnnee;
				int annee = Integer.parseInt(elementAnnee.getTextContent());
				
				Node noeudMasse = elementMeteore.getElementsByTagName("mass").item(0);
				Element elementMasse = (Element)noeudMasse;
				int masse = Integer.parseInt(elementMasse.getTextContent());				
				
				Node noeudCoordonneesX = elementMeteore.getElementsByTagName("reclat").item(0);
				Element elementCoordonneesX = (Element)noeudCoordonneesX;
				int coordonneesX = Integer.parseInt(elementCoordonneesX.getTextContent());
				
				Node noeudCoordonneesY = elementMeteore.getElementsByTagName("reclong").item(0);
				Element elementCoordonneesY = (Element)noeudCoordonneesY;
				int coordonneesY = Integer.parseInt(elementCoordonneesY.getTextContent());
				
				int[] coordonnees = {0,0};
				coordonnees[0] = coordonneesX;
				coordonnees[1] = coordonneesX;				
				
				Meteore meteore = new Meteore(coordonnees, id, masse, nom, annee);
				listeMeteores.add(meteore);
				
				
			}
			
					
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		try 
		{
			int id = 0;
			
			File file = new File("c:\\file-utf.xml");
			InputStream inputStream;
			Reader reader;
			inputStream = new FileInputStream(file);
			reader = new InputStreamReader(inputStream,"UTF-8");
			InputSource is = new InputSource(reader);
			
			DocumentBuilder parseur;
			parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document docListeMeteore = parseur.parse(is);
			String racine = docListeMeteore.getDocumentElement().getNodeName();
			
			NodeList noeudListeMeteore = docListeMeteore.getElementsByTagName("row");
			
			for(int position = 0; position < noeudListeMeteore.getLength(); position++)
			{
				Node noeudMeteore = noeudListeMeteore.item(position);
				Element elementMeteore = (Element)noeudMeteore;
				
				Node noeudNom = elementMeteore.getElementsByTagName("name").item(0);
				Element elementNom = (Element)noeudNom;
				String nom = elementNom.getTextContent();
				
				/*Node noeudId = elementMeteore.getElementsByTagName("id").item(0);
				Element elementId = (Element)noeudId;
				int id = Integer.parseInt(elementId.getTextContent());*/
				
				Node noeudAnnee = elementMeteore.getElementsByTagName("year").item(0);
				Element elementAnnee = (Element)noeudAnnee;
				//int annee = Integer.parseInt(elementAnnee.getTextContent());
				int annee = 10;
				
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
				
				float[] coordonnees = {0,0};
				coordonnees[0] = coordonneesX;
				coordonnees[1] = coordonneesX;		
				
				
				Meteore meteore = new Meteore(coordonnees, id, masse, nom, annee);
				if(coordonneesX != -9999 && coordonneesY != -9999 && masse != 0)
				{
					listeMeteores.add(meteore);
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
		
		return listeMeteores;
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
