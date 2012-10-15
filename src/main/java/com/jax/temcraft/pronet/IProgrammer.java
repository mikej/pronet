/**
 * 
 */
package com.jax.temcraft.pronet;

import java.util.Collection;
import java.util.List;

/**
 * @author gordon
 * 
 */
public interface IProgrammer {

	public String getName();

	public List<String> getSkills();

	public Collection<IProgrammer> getRecommendations();

}
