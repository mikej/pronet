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
public class NetworkLoader {

	Collection<Programmer> programmers = new ArrayList<Programmer>();

	/**
	 * Perform the DOM loading of the specified XML file
	 * 
	 * @param filename
	 *            The name of the file to load
	 */
	public Collection<Programmer> parseXmlFile(String filename) {
		Document dom;

		// get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			// Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			for (int pass = 1; pass <= 2; pass++) {
				// parse using builder to get DOM representation of the XML file
				dom = db.parse(filename);
				parseDocument(dom, pass);
			}
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return programmers;
	}

	/**
	 * Parse the actual document and create programmers
	 * 
	 * @param dom
	 *            The document to read
	 */
	private void parseDocument(Document dom, int pass) {

		// get a nodelist of <employee> elements
		NodeList nl = dom.getElementsByTagName("Programmer");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// get the employee element
				Node node = nl.item(i);
				Element el = (Element) node;
				NamedNodeMap attrs = node.getAttributes();

				Node nameNode = attrs.getNamedItem("name");
				String programmerName = nameNode.getNodeValue();

				if (1 == pass) {
					// CReate the programmer
					Programmer programmer = new Programmer();
					programmer.setName(programmerName);

					NodeList skills = el.getElementsByTagName("Skill");
					List<String> results = parseChildren(skills);

					programmer.setSkills(results);

					// Add the programmer to the collection
					programmers.add(programmer);
				}

				// On second pass lookup the referenced programmers
				if (2 == pass) {

					// Lookup this programmer
					Programmer programmer = lookup(programmerName);

					if (null == programmer) {
						continue;
					}

					NodeList recommendations = el
							.getElementsByTagName("Recommendation");
					List<String> results = parseChildren(recommendations);

					for (String name : results) {
						Programmer recommendedProgrammer = lookup(name);
						if (recommendedProgrammer == null) {
							System.out.println("Unknown name [" + name
									+ "] ignoring...");
						} else {
							programmer.addRecommendation(recommendedProgrammer);
						
						}
					}

				}

			}
		}
	}

	/**
	 * 
	 * @param programmerName
	 * @return
	 */
	private Programmer lookup(String programmerName) {

		for (Programmer p : programmers) {
			if (p.getName().equalsIgnoreCase(programmerName)) {
				return p;
			}
		}
		return null;
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
