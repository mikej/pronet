package com.jax.temcraft.pronet;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.jax.teamcraft.pronet.IProgrammer;
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
		p1.setKudos(1);
		p2.setKudos(2);
		List<IProgrammer> exp = Arrays.asList((IProgrammer)p1, (IProgrammer)p2);

		int i = 0;
		for (Programmer p : n1.getProgrammers()) {
			IProgrammer expProg = exp.get(i++);
			assertEquals("p1", expProg.getName());
			assertEquals(1, expProg.getKudos(), 0.001);
		}
	}
}
