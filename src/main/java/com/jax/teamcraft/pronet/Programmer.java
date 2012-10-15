/**
 * 
 */
package com.jax.teamcraft.pronet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gpimblott
 * 
 */
public class Programmer {

	String name;
	List<String> skills;
	List<Programmer> recommendations;
	private List<Programmer> recommendedBy;
	private double kudos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public void setRecommendations(List<Programmer> recommendations) {
		this.recommendations = recommendations;
	}

	public List<Programmer> getRecommendations() {
		return recommendations;
	}


	public void setRecommendedBy(List<Programmer> recommendedBy) {
		this.recommendedBy = recommendedBy;
	}

	public List<Programmer> getRecommendedBy() {
		return recommendedBy;
	}

	public List<Programmer> getConnections() {
		Set<Programmer> connections = new HashSet<Programmer>();
		if (recommendations != null) { connections.addAll(recommendations); }
		if (recommendedBy != null) { connections.addAll(recommendedBy); }
		return new ArrayList<Programmer>(connections);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Name:" + name + "\n");

		sb.append("Skill:" + skills.toString() + "\n");
		sb.append("Recommendations:" + recommendations.toString() + "\n");

		return sb.toString();
	}

	public void setKudos(double score) {
		this.kudos = score;
	}

	public double getKudos() {
		return kudos;
	}
}
