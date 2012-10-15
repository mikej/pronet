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
	private static double delta = 0.00001;

	public Network calculate(Network network) {
		Map<String, Programmer> programmers = loadProgrammers(network
				.getProgrammers());

		for (int i = 0; ; ++i) {
			double highestDelta = 0;
			// foreach programmer
			for (Entry<String, Programmer> e : programmers.entrySet()) {
				// calculate kudos from his followers
				Programmer p = e.getValue();
				double newKudos = calculateScore(p);
				double oldKudos = p.getKudos();
				p.setKudos(newKudos);
				double kudosDelta = Math.abs(oldKudos - newKudos);
				if (kudosDelta > highestDelta)
					highestDelta = kudosDelta;
			}
			if (highestDelta < delta && i > 100)
				break;
		}

		// save the value
		// repeat until avg ~= 1
		return network;
	}

	private double calculateScore(Programmer p) {
		Collection<Programmer> recomends = p.getRecommendedBy();

		double score = 0;
		for (Programmer p2 : recomends) {
			double k = p2.getKudos();
			double count = p2.getRecommendations().size();
			score += k / count;
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
