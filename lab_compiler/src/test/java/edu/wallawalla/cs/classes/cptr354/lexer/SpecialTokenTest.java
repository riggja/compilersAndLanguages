package edu.wallawalla.cs.classes.cptr354.lexer;

import edu.ucsb.cseweb.classes.cse131a.lexer.Sym;
import edu.ucsb.cseweb.classes.cse131a.lexer.Token;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpecialTokenTest {

	private Token token;

	@Test
	public void testGetTokenIDTooLong() {
		Lexer lexer = new Lexer("thisIdentifierIsLongerThanFortyCharactersSS;");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_ID);
		assertEquals(token.GetLexeme(), "thisIdentifierIsLongerThanFortyCharacter");
	}

	@Test
	public void testGetTokenInt() {
		Lexer lexer = new Lexer("00FA;");

		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_INT_LITERAL);
		assertEquals(token.GetLexeme(), "FAH");
	}

	@Test
	public void testGetTokenStringTooLong() {
		Lexer lexer = new Lexer(
				"'This test string is much, much longer that 80 characters. Would you not agree? I would.';");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_STR_LITERAL);
		assertEquals(token.GetLexeme(),
				"This test string is much, much longer that 80 characters. Would you not agree? ");
	}

	@Test
	public void testGetTokenStringEOF() {
		Lexer lexer = new Lexer(
				"'This test string is much, much longer that 80 characters. Would you not agree? I would. EOF;");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_STR_LITERAL);
		assertEquals(token.GetLexeme(),
				"This test string is much, much longer that 80 characters. Would you not agree? ");
	}

	@Test
	public void testGetTokenStringNewLine() {
		Lexer lexer = new Lexer(
				"'This test string is much, much longer that 80 characters. Would you not agree? I would.\n;");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_STR_LITERAL);
		assertEquals(token.GetLexeme(),
				"This test string is much, much longer that 80 characters. Would you not agree? ");
	}

	@Test
	public void testGetTokenStringDoubleSingle() {
		Lexer lexer = new Lexer("\"test 'in single quotes.'\";");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_STR_LITERAL);
		assertEquals(token.GetLexeme(), "test 'in single quotes.'");
	}

	@Test
	public void testGetTokenStringSingleDouble() {
		Lexer lexer = new Lexer("'test \"in double quotes.\"';");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_STR_LITERAL);
		assertEquals(token.GetLexeme(), "test \"in double quotes.\"");
	}

	@Test
	public void testGetTokenReal() {
		Lexer lexer = new Lexer("1.23E+45;");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_REAL_LITERAL);
		assertEquals(token.GetLexeme(), "1.23E+45");
	}

	@Test
	public void testGetTokenRealNoED() {
		Lexer lexer = new Lexer("0001.2345678911;");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_REAL_LITERAL);
		assertEquals(token.GetLexeme(), "1.23456789");
	}

	@Test
	public void testGetTokenRealExpTooLong() {
		Lexer lexer = new Lexer("0001.2345678911D004569;");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_REAL_LITERAL);
		assertEquals(token.GetLexeme(), "1.23456789D456");
	}

	@Test
	public void testGetTokenChar() {
		Lexer lexer = new Lexer("00A1FX;");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_CHAR_LITERAL);
		assertEquals(token.GetLexeme(), "A1FX");
	}

	@Test
	public void testGetTokenCharTooLong() {
		Lexer lexer = new Lexer("00a1FbffX;");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_CHAR_LITERAL);
		assertEquals(token.GetLexeme(), "a1FX");
	}

	@Test
	public void testGetTokenInclude() {
		Lexer lexer = new Lexer("INCLUDE \"src/test/resources/inputTest.txt\";");
		token = lexer.getToken();
		assertEquals(token.GetType(), Sym.T_MODULE);
		assertEquals(token.GetLexeme(), "MODULE");
	}

}