package com.jax.teamcraft.pronet;

import org.apache.commons.lang.StringUtils;

public class FormatNetwork {

	public String formatNetwork(Network network) {
		StringBuilder sb = new StringBuilder();
		sb.append(formatLine("Name", "Skills", "Recommends"));
		for (Programmer programmer : network.getProgrammers()) {
			String skillList = StringUtils.join(programmer.getSkills(), ',');
			String recommends = StringUtils.join(programmer.getRecommendations(), ',');
			sb.append(formatLine(programmer.getName(), skillList, recommends));
		}
		return sb.toString();
	}

	private String formatLine(String f1, String f2, String f3) {
		return String.format("%-10s %-20s %s\n", f1, f2, f3);
	}
	
}
