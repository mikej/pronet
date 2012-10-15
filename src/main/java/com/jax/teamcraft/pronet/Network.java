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
public class Network implements INetwork {

	Collection<IProgrammer> programmers = new ArrayList<IProgrammer>();

	@Override
	public Collection<IProgrammer> getProgrammers() {
		
		return programmers;
	}

	@Override
	public void load(String uri) {

		programmers = new NetworkLoader().parseXmlFile(uri);
	}

	

}
