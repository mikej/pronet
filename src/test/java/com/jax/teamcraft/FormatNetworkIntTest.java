package com.jax.teamcraft;

import org.junit.Test;

import com.jax.teamcraft.pronet.FormatKudos;
import com.jax.teamcraft.pronet.FormatNetwork;
import com.jax.teamcraft.pronet.Network;

public class FormatNetworkIntTest {


	@Test
	public void test() {
		Network network = new Network();
		network.load("pronet.xml");

		FormatNetwork networkFormatter = new FormatNetwork();
		System.out.println(networkFormatter.formatNetwork(network));
	}

}
