/**
 * 
 */
package com.jax.teamcraft.pronet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gpimblott
 * 
 */
public class Programmer {

	String name;
	List<String> skills = new ArrayList<String>();
	List<Programmer> recommendations = new ArrayList<Programmer>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String>skills) {
		this.skills = skills;
	}
	
	public void setRecommendations(List<Programmer> recommendations) {
		this.recommendations = recommendations;
	}
	
	public List<Programmer> getRecommendations() {
		return recommendations;
	}
	
	public void setRecommendedBy(List<Programmer> programmers) {
		
	}
	
	public List<Programmer> getRecommendedBy() {
		return null;
	}
	
	public List<Programmer> getConnections() {
		return null;
	}
	
	public double getKudos() {
		return 0.0;
	}
	
	public void setKudos(double kudos) {
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name:" + name+"\n");
	
		sb.append("Skill:" + skills.toString() +"\n");
		sb.append("Recommendations:" + recommendations.toString() + "\n");
		
		return sb.toString();
	}

	/**
	 * Add a new recommendation
	 * @param p The programmer to add
	 */
	public void addRecommendation(Programmer p) {
		recommendations.add(p);
		
	}
}
