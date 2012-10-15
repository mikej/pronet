package com.jax.teamcraft;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.jax.teamcraft.pronet.FormatNetwork;
import com.jax.teamcraft.pronet.Network;
import com.jax.teamcraft.pronet.Programmer;

public class FormatNetworkTest {

	@Test
	public void shouldListNetworkMembersInATable() {
		Programmer bob = new Programmer();
		bob.setName("Bob");
		Programmer sue = new Programmer();
		sue.setName("Sue");
		
		Programmer andy = new Programmer();
		andy.setName("Andy");
		andy.setSkills(Arrays.asList("Java", "Ruby"));
		andy.setRecommendations(Arrays.asList(bob, sue));
		
		Network network = new Network();
		network.setProgrammers(Arrays.asList(andy));
				
		FormatNetwork formatter = new FormatNetwork();
		String expected = "Name       Skills               Recommends\n" +
				"Andy       Java,Ruby            Bob,Sue\n";
		assertEquals(expected, formatter.formatNetwork(network));
	}

}
