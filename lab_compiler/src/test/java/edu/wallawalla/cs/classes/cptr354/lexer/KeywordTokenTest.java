package edu.wallawalla.cs.classes.cptr354.lexer;

import edu.ucsb.cseweb.classes.cse131a.lexer.Sym;
import edu.ucsb.cseweb.classes.cse131a.lexer.Token;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeywordTokenTest {

	private Token token;

	private void assertLexerToken(String input, int type) {
		Lexer lexer = new Lexer(input);
		token = lexer.getToken();
		assertEquals(token.GetType(), type);
		assertEquals(token.GetLexeme(), input);
	}


	@Test
	public void testGetTokenKeywordARRAY() {
		assertLexerToken("ARRAY", Sym.T_ARRAY);
	}
	
	@Test
	public void testGetTokenKeywordBEGIN() {
		assertLexerToken("BEGIN", Sym.T_BEGIN);
	}	

    @Test
	public void testGetTokenKeywordBY() {
		assertLexerToken("BY", Sym.T_BY);
	}
	
	@Test
	public void testGetTokenKeywordCASE() {
		assertLexerToken("CASE", Sym.T_CASE);
	}
	
	@Test
	public void testGetTokenKeywordCONST() {
		assertLexerToken("CONST", Sym.T_CONST);
	}
	
	@Test
	public void testGetTokenKeywordDIV() {
		assertLexerToken("DIV", Sym.T_DIV);
	}
	
	@Test
	public void testGetTokenKeywordDO() {
		assertLexerToken("DO", Sym.T_DO);
	}
	
	@Test
	public void testGetTokenKeywordELSE() {
		assertLexerToken("ELSE", Sym.T_ELSE);
	}
	
	@Test
	public void testGetTokenKeywordELSIF() {
		assertLexerToken("ELSIF", Sym.T_ELSIF);
	}
	
	@Test
	public void testGetTokenKeywordEND() {
		assertLexerToken("END", Sym.T_END);
	}
	
	@Test
	public void testGetTokenKeywordEXIT() {
		assertLexerToken("EXIT", Sym.T_EXIT);
	}
	
	@Test
	public void testGetTokenKeywordFOR() {
		assertLexerToken("FOR", Sym.T_FOR);
	}
	
	@Test
	public void testGetTokenKeywordIF() {
		assertLexerToken("IF", Sym.T_IF);
	}
	
	@Test
	public void testGetTokenKeywordIMPORT() {
		assertLexerToken("IMPORT", Sym.T_IMPORT);
	}
	
	@Test
	public void testGetTokenKeywordIN() {
		assertLexerToken("IN", Sym.T_IN);
	}
	
	@Test
	public void testGetTokenKeywordIS() {
		assertLexerToken("IS", Sym.T_IS);
	}
	
	@Test
	public void testGetTokenKeywordLOOP() {
		assertLexerToken("LOOP", Sym.T_LOOP);
	}
	
	@Test
	public void testGetTokenKeywordMOD() {
		assertLexerToken("MOD", Sym.T_MOD);
	}
	
	@Test
	public void testGetTokenKeywordMODULE() {
		assertLexerToken("MODULE", Sym.T_MODULE);
	}
	
	@Test
	public void testGetTokenKeywordNIL() {
		assertLexerToken("NIL", Sym.T_NIL);
	}
	
	@Test
	public void testGetTokenKeywordOF() {
		assertLexerToken("OF", Sym.T_OF);
	}
	
	@Test
	public void testGetTokenKeywordOR() {
		assertLexerToken("OR", Sym.T_OR);
	}
	
	@Test
	public void testGetTokenKeywordPOINTER() {
		assertLexerToken("POINTER", Sym.T_POINTER);
	}
	
	@Test
	public void testGetTokenKeywordPROCEDURE() {
		assertLexerToken("PROCEDURE", Sym.T_PROCEDURE);
	}
		
	@Test
	public void testGetTokenKeywordRECORD() {
		assertLexerToken("RECORD", Sym.T_RECORD);
	}
		
	@Test
	public void testGetTokenKeywordREPEAT() {
		assertLexerToken("REPEAT", Sym.T_REPEAT);
	}
		
	@Test
	public void testGetTokenKeywordRETURN() {
		assertLexerToken("RETURN", Sym.T_RETURN);
	}
		
	@Test
	public void testGetTokenKeywordTHEN() {
		assertLexerToken("THEN", Sym.T_THEN);
	}
		
	@Test
	public void testGetTokenKeywordTO() {
		assertLexerToken("TO", Sym.T_TO);
	}
		
	@Test
	public void testGetTokenKeywordTYPE() {
		assertLexerToken("TYPE", Sym.T_TYPE);
	}
		
	@Test
	public void testGetTokenKeywordUNTIL() {
		assertLexerToken("UNTIL", Sym.T_UNTIL);
	}
		
	@Test
	public void testGetTokenKeywordVAR() {
		assertLexerToken("VAR", Sym.T_VAR);
	}
		
	@Test
	public void testGetTokenKeywordWHILE() {
		assertLexerToken("WHILE", Sym.T_WHILE);
	}
		
	@Test
	public void testGetTokenKeywordWITH() {
		assertLexerToken("WITH", Sym.T_WITH);
	}
		
	@Test
	public void testGetTokenKeywordBOOLEAN() {
		assertLexerToken("BOOLEAN", Sym.T_BOOLEAN);
	}
		
	@Test
	public void testGetTokenKeywordCHAR() {
		assertLexerToken("CHAR", Sym.T_CHAR);
	}
		
	@Test
	public void testGetTokenKeywordFALSE() {
		assertLexerToken("FALSE", Sym.T_FALSE);
	}
		
	@Test
	public void testGetTokenKeywordINTEGER() {
		assertLexerToken("INTEGER", Sym.T_INTEGER);
	}
		
	@Test
	public void testGetTokenKeywordNEW() {
		assertLexerToken("NEW", Sym.T_NEW);
	}
		
	@Test
	public void testGetTokenKeywordREAL() {
		assertLexerToken("REAL", Sym.T_REAL);
	}
		
	@Test
	public void testGetTokenKeywordTRUE() {
		assertLexerToken("TRUE", Sym.T_TRUE);
	}
}