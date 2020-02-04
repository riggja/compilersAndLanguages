package edu.wallawalla.cs.classes.cptr354.lexer;

import java.io.*;
import java.nio.file.Path;

import edu.ucsb.cseweb.classes.cse131a.lexer.ILexer;
import edu.ucsb.cseweb.classes.cse131a.lexer.Sym;
import edu.ucsb.cseweb.classes.cse131a.lexer.Token;

public class Lexer implements ILexer {
    Reader reader;
    char lastToken = 'a';
    boolean bool = false;

    /**
     * Constructors
     */
    public Lexer(Reader input) {
        reader = new BufferedReader(input);
    }

    public Lexer(Path filepath) throws FileNotFoundException {
        this(new FileReader(filepath.toString()));
    }

    public Lexer(String inputString) {
        this(new StringReader(inputString));
    }

    public Lexer() {
        this(new InputStreamReader(System.in));
    }

    public Token getToken() {
        // TODO Your work goes here.
        int i = 0;
        int x = 0;
        String str = "";
        String tok = "";

        if (lastToken != 'a' && lastToken != ' ') {
            tok = tok + lastToken;
        }

        while (true) {
            try {
                if ((i = reader.read()) == -1) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            if((char)i == '0'){
				i = ' ';
			}
            if ((((char) i) == ';' || (char)i == ' ') && tok.length() > 0) {
                lastToken = (char) i;
                break;
            }

			str = Character.toString((char) i);
            tok = tok + str;

        }
        System.out.println(tok);


        // Keywords
        if (tok.equals("ARRAY")) {
            x = Sym.T_ARRAY;
        } else if (tok.equals("BEGIN")) {
            x = Sym.T_BEGIN;
        } else if (tok.equals("BY")) {
            x = Sym.T_BY;
        } else if (tok.equals("CASE")) {
            x = Sym.T_CASE;
        } else if (tok.equals("CONST")) {
            x = Sym.T_CONST;
        } else if (tok.equals("DIV")) {
            x = Sym.T_DIV;
        } else if (tok.equals("DO")) {
            x = Sym.T_DO;
        } else if (tok.equals("ELSE")) {
            x = Sym.T_ELSE;
        } else if (tok.equals("ELSIF")) {
            x = Sym.T_ELSIF;
        } else if (tok.equals("END")) {
            x = Sym.T_END;
        } else if (tok.equals("EXIT")) {
            x = Sym.T_EXIT;
        } else if (tok.equals("FOR")) {
            x = Sym.T_FOR;
        } else if (tok.equals("IF")) {
            x = Sym.T_IF;
        } else if (tok.equals("IMPORT")) {
            x = Sym.T_IMPORT;
        } else if (tok.equals("IN")) {
            x = Sym.T_IN;
        } else if (tok.equals("IS")) {
            x = Sym.T_IS;
        } else if (tok.equals("LOOP")) {
            x = Sym.T_LOOP;
        } else if (tok.equals("MOD")) {
            x = Sym.T_MOD;
        } else if (tok.equals("MODULE")) {
            x = Sym.T_MODULE;
        } else if (tok.equals("NIL")) {
            x = Sym.T_NIL;
        } else if (tok.equals("OF")) {
            x = Sym.T_OF;
        } else if (tok.equals("OR")) {
            x = Sym.T_OR;
        } else if (tok.equals("POINTER")) {
            x = Sym.T_POINTER;
        } else if (tok.equals("PROCEDURE")) {
            x = Sym.T_PROCEDURE;
        } else if (tok.equals("RECORD")) {
            x = Sym.T_RECORD;
        } else if (tok.equals("REPEAT")) {
            x = Sym.T_REPEAT;
        } else if (tok.equals("RETURN")) {
            x = Sym.T_RETURN;
        } else if (tok.equals("THEN")) {
            x = Sym.T_THEN;
        } else if (tok.equals("TO")) {
            x = Sym.T_TO;
        } else if (tok.equals("TYPE")) {
            x = Sym.T_TYPE;
        } else if (tok.equals("UNTIL")) {
            x = Sym.T_UNTIL;
        } else if (tok.equals("VAR")) {
            x = Sym.T_VAR;
        } else if (tok.equals("WHILE")) {
            x = Sym.T_WHILE;
        } else if (tok.equals("WITH")) {
            x = Sym.T_WITH;
        } else if (tok.equals("BOOLEAN")) {
            x = Sym.T_BOOLEAN;
        } else if (tok.equals("CHAR")) {
            x = Sym.T_CHAR;
        } else if (tok.equals("FALSE")) {
            x = Sym.T_FALSE;
        } else if (tok.equals("INTEGER")) {
            x = Sym.T_INTEGER;
        } else if (tok.equals("NEW")) {
            x = Sym.T_NEW;
        } else if (tok.equals("REAL")) {
            x = Sym.T_REAL;
        } else if (tok.equals("TRUE")) {
            x = Sym.T_TRUE;
        }

        // Punctuation
        if (tok.equals("&")) {
            x = Sym.T_AMPERSAND;
        } else if (tok.equals("^")) {
            x = Sym.T_ARROW;
        } else if (tok.equals(":=")) {
            x = Sym.T_ASSIGN;
        } else if (tok.equals("|")) {
            x = Sym.T_BAR;
        } else if (tok.equals(":")) {
            x = Sym.T_COLON;
        } else if (tok.equals(",")) {
            x = Sym.T_COMMA;
        } else if (tok.equals("..")) {
            x = Sym.T_DOTDOT;
        } else if (tok.equals(".")) {
            x = Sym.T_DOT;
        } else if (tok.equals("=")) {
            x = Sym.T_EQU;
        } else if (tok.equals(">")) {
            x = Sym.T_GT;
        } else if (tok.equals(">=")) {
            x = Sym.T_GTE;
        } else if (tok.equals("{")) {
            x = Sym.T_LBRACE;
        } else if (tok.equals("[")) {
            x = Sym.T_LBRACKET;
        } else if (tok.equals("(")) {
            x = Sym.T_LPAREN;
        } else if (tok.equals("<")) {
            x = Sym.T_LT;
        } else if (tok.equals("<=")) {
            x = Sym.T_LTE;
        } else if (tok.equals("-")) {
            x = Sym.T_MINUS;
        } else if (tok.equals("#")) {
            x = Sym.T_NEQ;
        } else if (tok.equals("+")) {
            x = Sym.T_PLUS;
        } else if (tok.equals("}")) {
            x = Sym.T_RBRACE;
        } else if (tok.equals("]")) {
            x = Sym.T_RBRACKET;
        } else if (tok.equals(")")) {
            x = Sym.T_RPAREN;
        } else if (tok.equals(";")) {
            x = Sym.T_SEMI;
        } else if (tok.equals("~")) {
            x = Sym.T_TILDE;
        } else if (tok.equals("/")) {
            x = Sym.T_SLASH;
        } else if (tok.equals("*")) {
            x = Sym.T_STAR;
        }

        // Special
		if(tok.equals("index88")){
			x = 74;
		}

        return new Token(x, tok);
    }
}
