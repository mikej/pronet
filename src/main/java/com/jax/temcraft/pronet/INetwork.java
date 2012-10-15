/**
 * 
 */
package com.jax.temcraft.pronet;

import java.util.Collection;

/**
 * @author gordon
 *
 */
public interface INetwork {

	public Collection<IProgrammer> getProgrammers();
	
	public void load(String uri);
}
