package com.jax.teamcraft;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.jax.teamcraft.pronet.FormatNetwork;
import com.jax.teamcraft.pronet.INetwork;
import com.jax.teamcraft.pronet.IProgrammer;
import com.jax.teamcraft.pronet.ShowNetwork;

public class FormatNetworkTest {

	@Test
	public void shouldListNetworkMembersInATable() {
		final IProgrammer programmer = new IProgrammer() {
			
			public List<String> getSkills() {
				return Arrays.asList("Java", "Ruby");
			}
			
			public Collection<String> getRecommendations() {
				return Arrays.asList("Bob", "Sue");
			}
			
			public String getName() {
				return "Andy";
			}
		};
		
		INetwork network = new INetwork() {
			
			public void load(String uri) {
			}
			
			public Collection<IProgrammer> getProgrammers() {
				return Arrays.asList(programmer);
			}
		};
		
		FormatNetwork formatter = new FormatNetwork();
		String expected = "Name       Skills               Recommends\n" +
				"Andy       Java,Ruby            Bob,Sue\n";
		assertEquals(expected, formatter.formatNetwork(network));
	}

}
