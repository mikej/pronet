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
	List<String> skills;
	List<String> recommendations;

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String>skills) {
		this.skills = skills;
	}
	
	public void setRecommendations(List<String>recommendations) {
		this.recommendations = recommendations;
	}
	
	@Override
	public List<String> getRecommendations() {
		return recommendations;
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
