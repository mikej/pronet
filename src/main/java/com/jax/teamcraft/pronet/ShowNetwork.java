package com.jax.teamcraft.pronet;

public class ShowNetwork {

	public static void main(String[] args) {
		ShowNetwork showNetwork = new ShowNetwork();
		showNetwork.run(args);
	}

	private void run(String[] args) {
		String filename = args[0];
		Network network = new Network();
		network.load(filename);
		System.out.println(new FormatNetwork().formatNetwork(network));
	}
	
}
