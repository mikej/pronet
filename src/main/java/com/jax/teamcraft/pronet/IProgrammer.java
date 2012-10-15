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

	public void setSkills(Collection<String>skills);
	
	public void setRecommendations(Collection<String>recommendations);
	
	public Collection<String> getRecommendations();

	public double getKudos();

}
