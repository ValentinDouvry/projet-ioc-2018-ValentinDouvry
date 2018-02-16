package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.qc.cgmatane.informatique.outilmeteore.Meteore;

public class MeteoreDaoImplementation implements MeteoresDao
{
	List<Meteore> listeMeteores;

	
	public MeteoreDaoImplementation() 
	{
		listeMeteores = new ArrayList<Meteore>();
		
	}
	
	
	@Override
	public List<Meteore> recupererTouteLesMeteores() 
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
		
		DocumentBuilder parseur;
		
		try {
			parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document docListeMeteore = parseur.parse(new StringBufferInputStream(xmlMeteores));
			String racine = docListeMeteore.getDocumentElement().getNodeName();
			
			NodeList noeudListeMeteore = docListeMeteore.getElementsByTagName("name");
					
					
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
