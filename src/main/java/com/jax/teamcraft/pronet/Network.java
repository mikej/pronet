/**
 * 
 */
package com.jax.teamcraft.pronet;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author gordon
 * 
 */
public class Network {

	Collection<Programmer> programmers = new ArrayList<Programmer>();

	public Collection<Programmer> getProgrammers() {
		return programmers;
	}
	
	public void setProgrammers(Collection<Programmer> programmers) {
		this.programmers = programmers;
	}

	public void load(String uri) {
		programmers = new NetworkLoader().parseXmlFile(uri);
	}

}
