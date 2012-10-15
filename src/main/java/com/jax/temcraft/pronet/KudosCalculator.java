package com.jax.temcraft.pronet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.jax.teamcraft.pronet.IProgrammer;
import com.jax.teamcraft.pronet.Network;
import com.jax.teamcraft.pronet.Programmer;

public class KudosCalculator {

	private static double d = 0.85;
	private static double delta = 0.001;

	public Network calculate(Network network) {
		Map<String, Programmer> programmers = loadProgrammers(network
				.getProgrammers());

		double oldAvg = Double.MAX_VALUE;
		double acc = 0;
		do {
			acc = 0;
			// foreach programmer
			for (Entry<String, Programmer> e : programmers.entrySet()) {
				// calculate kudos from his followers
				double score = calculateScore(e.getValue());
				e.getValue().setKudos(score);
				acc += score;
			}
		} while (Math.abs(acc / programmers.size() - oldAvg) > delta);

		// save the value
		// repeat until avg ~= 1
		return network;
	}

	private double calculateScore(Programmer p) {
		Collection<Programmer> recomends = p.getRecommendedBy();

		double score = 0;
		for (Programmer p2 : recomends) {
			double k = p2.getKudos();
			int count = p2.getRecommendations().size();
			score += count == 0 ? 0 : k / count;
		}
		score = d * score + (1 - d);

		return score;
	}

	private Map<String, Programmer> loadProgrammers(
			Collection<Programmer> programmers) {
		HashMap<String, Programmer> map = new HashMap<String, Programmer>();
		for (Programmer p : programmers) {
			map.put(p.getName(), (Programmer) p);
		}
		return map;
	}

}
