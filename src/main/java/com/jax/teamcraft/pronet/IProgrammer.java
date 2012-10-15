/**
 * 
 */
package com.jax.teamcraft.pronet;

import java.util.Collection;
import java.util.List;

/**
 * @author gordon
 * 
 */
public interface IProgrammer {

	public String getName();

	public void setName(String name);
	
	public List<String> getSkills();

	public void setSkills(List<String>skills);
	
	public void setRecommendations(List<String>recommendations);
	
	public List<String> getRecommendations();

}
