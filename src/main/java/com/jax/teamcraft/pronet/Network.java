/**
 * 
 */
package com.jax.teamcraft.pronet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author gordon
 * 
 */
public class Network implements INetwork {

	Collection<IProgrammer> programmers = new ArrayList<IProgrammer>();

	@Override
	public Collection<IProgrammer> getProgrammers() {
		
		return programmers;
	}

	@Override
	public void load(String uri) {

		parseXmlFile(uri);
	}

	
	/**
	 * Perform the DOM loading of the specified XML file
	 * @param filename The name of the file to load
	 */
	private void parseXmlFile(String filename) {
		Document dom;

		// get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			// Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parse using builder to get DOM representation of the XML file
			dom = db.parse(filename);
			parseDocument(dom);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Parse the actual document and create programmers
	 * @param dom The document to read
	 */
	private void parseDocument(Document dom) {
		// get a nodelist of <employee> elements
		NodeList nl = dom.getElementsByTagName("Programmer");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// get the employee element
				Node node = nl.item(i);
				NamedNodeMap attrs = node.getAttributes();

				Node nameNode = attrs.getNamedItem("name");

				// CReate the programmer
				Programmer programmer = new Programmer();
				programmer.setName(nameNode.getNodeValue());

				
				Element el = (Element)node;
				
				NodeList skills = el.getElementsByTagName("Skill");
				List<String> results = parseChildren(skills);
				
				programmer.setSkills(results);
				
				NodeList recommendations = el.getElementsByTagName("Recommendation");
				results = parseChildren(recommendations);
				programmer.setRecommendations(results);

				// Add the programmer to the collection
				programmers.add(programmer);
			}
		}
	}

	private List<String> parseChildren(NodeList items) {
	
		List<String> results = new ArrayList<String>();
		for (int sk = 0; sk < items.getLength(); sk++) {
			Node skill = items.item(sk);

			if (null != skill) {
				results.add(skill.getTextContent().trim());
			}
		}
		
		return results;
	}

}
