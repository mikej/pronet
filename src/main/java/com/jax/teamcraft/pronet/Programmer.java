/**
 * 
 */
package com.jax.teamcraft.pronet;

import java.util.Collection;
import java.util.List;

/**
 * @author gpimblott
 * 
 */
public class Programmer implements IProgrammer {

	String name;
	Collection<String> skills;
	Collection<String> recommendations;

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public List<String> getSkills() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSkills(Collection<String>skills) {
		this.skills = skills;
	}
	
	public void setRecommendations(Collection<String>recommendations) {
		this.recommendations = recommendations;
	}
	
	@Override
	public Collection<String> getRecommendations() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name:" + name+"\n");
	
		sb.append("Skill:" + skills.toString() +"\n");
		sb.append("Recommendations:" + recommendations.toString() + "\n");
		
		return sb.toString();
	}
}
