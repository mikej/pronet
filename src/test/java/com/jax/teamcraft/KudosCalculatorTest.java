package com.jax.teamcraft;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.jax.teamcraft.pronet.KudosCalculator;
import com.jax.teamcraft.pronet.Network;
import com.jax.teamcraft.pronet.Programmer;

public class KudosCalculatorTest {

	@Test
	public void calculateKudosForTwoUser() {
		// given
		ArrayList<Programmer> programmers = new ArrayList<Programmer>();
		Programmer p1 = new Programmer();
		Programmer p2 = new Programmer();
		p1.setName("p1");
		p2.setName("p2");
		p1.setRecommendations(Arrays.asList(p2));
		p2.setRecommendations(Arrays.asList(p1));
		p1.setRecommendedBy(Arrays.asList(p2));
		p2.setRecommendedBy(Arrays.asList(p1));
		programmers.add(p1);
		programmers.add(p2);
		Network network = new Network();

		// when
		KudosCalculator calc = new KudosCalculator();
		network.setProgrammers(programmers);
		Network n1 = calc.calculate(network);

		// then
		List<Double> exp = Arrays.asList(1d,1d);

		int i = 0;
		assertEquals(2,  n1.getProgrammers().size());
		for (Programmer p : n1.getProgrammers()) {
			assertEquals(exp.get(i++), p.getKudos(), 0.001);
		}
	}
	
	@Test
	public void calculateKudosForFourUser() {
		// given
		ArrayList<Programmer> programmers = new ArrayList<Programmer>();
		Programmer pA = new Programmer();
		Programmer pB = new Programmer();
		Programmer pC = new Programmer();
		Programmer pD = new Programmer();
		pA.setName("A");
		pB.setName("B");
		pC.setName("C");
		pD.setName("D");
		pA.setRecommendations(Arrays.asList(pB,pC));
		pA.setRecommendedBy(Arrays.asList(pC));
		
		pB.setRecommendations(Arrays.asList(pC));
		pB.setRecommendedBy(Arrays.asList(pA));
		
		pC.setRecommendations(Arrays.asList(pA));
		pC.setRecommendedBy(Arrays.asList(pA, pB, pD));
		
		pD.setRecommendations(Arrays.asList(pC));
		pD.setRecommendedBy(Collections.<Programmer>emptyList());
		
		programmers.add(pA);
		programmers.add(pB);
		programmers.add(pC);
		programmers.add(pD);
		Network network = new Network();
		network.setProgrammers(programmers);

		// when
		KudosCalculator calc = new KudosCalculator();
		Network n1 = calc.calculate(network);

		// then
		List<Double> exp = Arrays.asList(1.49d,0.78d,1.57d,0.15d);

		int i = 0;
		for (Programmer p : n1.getProgrammers()) {
			assertEquals(exp.get(i++), p.getKudos(), 0.01);
			System.out.println(p.getKudos());
		}
	}
}
