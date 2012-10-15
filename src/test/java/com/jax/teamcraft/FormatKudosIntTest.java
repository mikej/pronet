package com.jax.teamcraft;

import org.junit.Test;

import com.jax.teamcraft.pronet.FormatKudos;
import com.jax.teamcraft.pronet.Network;

public class FormatKudosIntTest {

	@Test
	public void test() {
		Network network = new Network();
		network.load("pronet.xml");

		FormatKudos kudosFormatter = new FormatKudos();
		System.out.println(kudosFormatter.formatKudos(network));
	
		
//		Bill	0.57
//		Dave	0.26
//		Ed		0.37
//		Frank	2.28
//		Jason	0.27
//		Jill	0.50
//		Liz		0.37
//		Nick	2.63
//		Rick	0.25
//		Stu		2.51
	}

}
