package com.jax.temcraft.pronet;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class KudosCalculatorTest {

	@Test
	public void calculateKudosForTwoUser() {
		// given
		ArrayList<IProgrammer> programmers = new ArrayList<IProgrammer>();
		Programmer p1 = new Programmer();
		Programmer p2 = new Programmer();
		p1.setName("p1");
		p2.setName("p2");
		p1.setRecommendations(Arrays.asList(p2));
		p1.setRecommendations(Arrays.asList(p1));
		programmers.add(p1);
		programmers.add(p2);
		Network network = new Network();

		// when
		KudosCalculator calc = new KudosCalculator();
		Network n1 = calc.calculate(network.setProgrammers(programmers));

		// then
		p1.setKudos(1);
		p2.setKudos(2);
		ArrayList<IProgrammer> exp = Arrays.asList(p1, p2);

		int i = 0;
		for (IProgrammer p : n1.getProgrammers()) {
			IProgrammer expProg = exp.get(i++);
			assertEquals("p1", expProg.getName());
			assertEquals(1, expProg.getKudos());
		}
	}
}
