package com.jax.teamcraft.pronet;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class FormatNetwork {

	public String formatNetwork(Network network) {
		StringBuilder sb = new StringBuilder();
		sb.append(formatLine("Name", "Skills", "Recommends"));
		extractProgrammers(network, sb);
		
		return sb.toString();
	}

	private void extractProgrammers(Network network, StringBuilder sb) {
		for (Programmer programmer : network.getProgrammers()) {
			List<String> names = extractNames(programmer);
			String recommends = StringUtils.join(names, ',');
			String skillList = StringUtils.join(programmer.getSkills(), ',');
			
			sb.append(formatLine(programmer.getName(), skillList, recommends));
		}
	}

	private List<String> extractNames(Programmer programmer) {
		List<String> names = new ArrayList<String>();
		for (Programmer p : programmer.getRecommendations()) {
			names.add(p.getName());
		}
		return names;
	}

	private String formatLine(String f1, String f2, String f3) {
		return String.format("%-10s %-20s %s\n", f1, f2, f3);
	}
	
}
