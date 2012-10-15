package com.jax.teamcraft;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jax.teamcraft.pronet.FormatKudos;
import com.jax.teamcraft.pronet.KudosCalculator;
import com.jax.teamcraft.pronet.Network;

public class FormatNetworkIntTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Network network = new Network();
		network.load("pronet.xml");

		FormatKudos kudosFormatter = new FormatKudos();
		System.out.println(kudosFormatter.formatKudos(network));
	}

}
