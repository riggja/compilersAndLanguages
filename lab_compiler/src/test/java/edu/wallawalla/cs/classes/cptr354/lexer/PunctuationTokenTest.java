package edu.wallawalla.cs.classes.cptr354.lexer;

import edu.ucsb.cseweb.classes.cse131a.lexer.Sym;
import edu.ucsb.cseweb.classes.cse131a.lexer.Token;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PunctuationTokenTest {

	private Token token;

	private void assertLexerToken(String input, int type) {
		Lexer lexer = new Lexer(input);
		token = lexer.getToken();
		assertEquals(token.GetType(), type);
		assertEquals(token.GetLexeme(), input);
	}

	@Test
	public void testGetTokenAmp() {
		assertLexerToken("&", Sym.T_AMPERSAND);
	}

	@Test
	public void testGetTokenArrow() {
		assertLexerToken("^", Sym.T_ARROW);
	}

	@Test
	public void testGetTokenAssign() {
		assertLexerToken(":=", Sym.T_ASSIGN);
	}

	@Test
	public void testGetTokenColon() {
		assertLexerToken(":", Sym.T_COLON);
	}

	@Test
	public void testGetTokenComma() {
		assertLexerToken(",", Sym.T_COMMA);
	}

	@Test
	public void testGetTokenDotdot() {
		assertLexerToken("..", Sym.T_DOTDOT);
	}

	@Test
	public void testGetTokenDot() {
		assertLexerToken(".", Sym.T_DOT);
	}

	@Test
	public void testGetTokenEqu() {
		assertLexerToken("=", Sym.T_EQU);
	}

	@Test
	public void testGetTokenGt() {
		assertLexerToken(">", Sym.T_GT);
	}

	@Test
	public void testGetTokenGte() {
		assertLexerToken(">=", Sym.T_GTE);
	}

	@Test
	public void testGetTokenLbrace() {
		assertLexerToken("{", Sym.T_LBRACE);
	}

	@Test
	public void testGetTokenLbracket() {
		assertLexerToken("[", Sym.T_LBRACKET);
	}

	@Test
	public void testGetTokenLparen() {
		assertLexerToken("(", Sym.T_LPAREN);
	}

	@Test
	public void testGetTokenLt() {
		assertLexerToken("<", Sym.T_LT);
	}

	@Test
	public void testGetTokenLte() {
		assertLexerToken("<=", Sym.T_LTE);
	}

	@Test
	public void testGetTokenMinus() {
		assertLexerToken("-", Sym.T_MINUS);
	}

	@Test
	public void testGetTokenNeq() {
		assertLexerToken("#", Sym.T_NEQ);
	}

	@Test
	public void testGetTokenPlus() {
		assertLexerToken("+", Sym.T_PLUS);
	}

	@Test
	public void testGetTokenRbrace() {
		assertLexerToken("}", Sym.T_RBRACE);
	}

	@Test
	public void testGetTokenRbracket() {
		assertLexerToken("]", Sym.T_RBRACKET);
	}

	@Test
	public void testGetTokenRparen() {
		assertLexerToken(")", Sym.T_RPAREN);
	}

	@Test
	public void testGetTokenSemi() {
		assertLexerToken(";", Sym.T_SEMI);
	}

	@Test
	public void testGetTokenTilde() {
		assertLexerToken("~", Sym.T_TILDE);
	}

	@Test
	public void testGetTokenSlash() {
		assertLexerToken("/", Sym.T_SLASH);
	}

	@Test
	public void testGetTokenStar() {
		assertLexerToken("*", Sym.T_STAR);
	}
}