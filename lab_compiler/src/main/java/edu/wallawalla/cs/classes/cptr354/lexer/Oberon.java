package edu.wallawalla.cs.classes.cptr354.lexer;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import edu.ucsb.cseweb.classes.cse131a.lexer.LexerTester;

/**
 * Oberon class has a main method that instantiates a Lexer instance then passes
 * the object to the LexerTester instance to run the program.
 * The main method accepts files as arguments to be used by the Lexer OR standard input stream
 */
public class Oberon {
	public static void main(String[] args) {
		Lexer lexer;
		if (args.length > 0) {
			// Read file(s) from command line
			for (int i = 0; i < args.length; i++) {
				Path filepath = Paths.get(args[i]);
				try {
					lexer = new Lexer(filepath);
					LexerTester lexerTester = new LexerTester(lexer);
					lexerTester.run();
				} catch (FileNotFoundException e) {
					System.out.println("Unable to find file: " + filepath.toString());
				}
			}
		} else {
			System.out.println("Program is using System.in");
			System.out.println("To execute lexer, type your commands into the console.");
			System.out.println("To end program, type 'EOF' without quotes.\n");
			lexer = new Lexer();
			LexerTester lexerTester = new LexerTester(lexer);
			lexerTester.run();
		}
	}
}