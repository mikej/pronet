/**
 * 
 */
package com.jax.teamcraft.pronet;

import java.io.Console;

/**
 * @author gordon
 * 
 */
public class ConsoleApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Welcome to ProNet Delux!!!");
		System.out.println("\nCommands : ");
		System.out.println("\tload {filename}");
		System.out.println("\tkudos {filename}");
		System.out.println("\texit");
		
		Console console = System.console();
		while (true) {

			String cmd = console.readLine(">");

			String[] tokens = cmd.split(" ");

			if (tokens[0].equals("load")) {
				Network network = loadNetwork(tokens);
				System.out.println(new FormatNetwork().formatNetwork(network));
			} else if (tokens[0].equals("kudos")) {
				Network network = loadNetwork(tokens);
				System.out.println(new FormatKudos().formatKudos(network));
			} else if (tokens[0].equals("help")) {
				System.out.println("Not in these timescales !");
			} else if (tokens[0].equals("exit")) {
				System.exit(0);
			} else {

				System.out.println("Unknown user command :(");
			}
		}

	}

	private static Network loadNetwork(String[] tokens) {
		Network network = new Network();
		network.load(tokens[1]);
		return network;
	}

}
