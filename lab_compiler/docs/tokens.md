# Lexer Tokens Specifications

Taken from: http://cseweb.ucsd.edu/classes/fa00/cse131a/lexer-tokens.htm

## Oberon Tokens Specification
The following specifies the set of tokens for our lexer.
All token values are found in **Token.java**.

## Oberon Keywords

The following is the complete list of Oberon reserved words (also known as keywords).
For each of these, the **GetToken** value is the name of the keyword,
prepended by T_, as shown below.
Note that only uppercase strings qualify as keywords.

```
    ARRAY         (T_ARRAY)
    BEGIN         (T_BEGIN)
    BY            (T_BY)
    CASE          (etc.)
    CONST
    DIV
    DO
    ELSE
    ELSIF
    END
    EXIT
    FOR
    IF
    IMPORT
    IN
    IS
    LOOP
    MOD
    MODULE
    NIL
    OF
    OR
    POINTER
    PROCEDURE
    RECORD
    REPEAT
    RETURN
    THEN
    TO
    TYPE
    UNTIL
    VAR
    WHILE
    WITH
```

Oberon calls the following "predeclared identifiers", but they are
for our purposes equivalent to keywords:

```
    BOOLEAN
    CHAR
    FALSE
    INTEGER
    NEW
    REAL
    TRUE
```

### Punctuation Tokens

The following are punctuation symbols that our lexer
must recognize, followed by the token value.
Any printable
character that doesn't appear in the following list (such as @,
$, etc) is considered to be an illegal character.

```
    &     T_AMPERSAND
    ^     T_ARROW
    :=    T_ASSIGN
    |     T_BAR
    :     T_COLON
    ,     T_COMMA
    ..    T_DOTDOT
    .     T_DOT
    =     T_EQU
    >     T_GT
    >=    T_GTE
    {     T_LBRACE
    [     T_LBRACKET
    (     T_LPAREN
    <     T_LT
    <=    T_LTE
    -     T_MINUS
    #     T_NEQ
    +     T_PLUS
    }     T_RBRACE
    ]     T_RBRACKET
    )     T_RPAREN
    ;     T_SEMI
    ~     T_TILDE
    /     T_SLASH
    *     T_STAR
```

### Special Tokens

The following are the five special tokens -- their patterns are
described below.

##### T_ID

A sequence of up to 40 letters and digits, starting with a letter.
(Unlike many other languages, the underscore character cannot be part of an identifier and is in fact an illegal character.)

* If more than 40 letters/digits are read, the lexer should discard characters until a non-indentifier character is read, an error message is to be printed ("identifier too long") and the 40 characters returned as the lexeme.
In this case, the last character read (which, by definition, is not an identifier character) should be put back in the input stream.

##### T_INT_LITERAL

A sequence of up to 10 digits, OR a sequence of up to 10 hex digits
(0-9, uppercase A-F) followed by the character H.

* If more than 10 digits are read, the lexer should read and discard characters until a non-digit (or non-H) character is read, an error message is to be printed ("integer literal too long") and the 10 characters (plus the H if read) is returned. 
* If a literal contains hex digits but does not have a trailing H, an error message ("illegal hex integer literal) should be printed, and the lexeme should be fixed (by appending the H) before returning.
* All leading zeroes are to be discarded, and not counted against the limit of 10 (for example, the input **000000000012345** should return the lexeme 12345, with no error message).
* Note that several lexemes match the patterns for both integer literals and identifiers (for example, **AH** or **CDE123H**).
We claim that these lexemes should be returned as identifiers -- if the user really wanted the hex value **AH**, s/he can prepend a 0 (**0AH** can only be interpretted as an integer literal).

##### T_STR_LITERAL

A sequence of up to 80 characters, surrounded by either single or double quotes.
The ending quote must be the same as the starting quote.
It is legal for single quotes to be part of (inside) a double-quoted string, and vice versa.
Note that the surrounding quote characters themselves aren't considered when considering the length of the literal -- the largest string literal is 80 characters, PLUS the two surrounding quote characters.

* If an 81st character is read, the lexer should read and discard characters until either a closing quote, a newline, or an EOF is found.
In the first case, a single error ("unterminated string literal") is to be printed, while in the second and third cases two error messages (unterminated literal, newline/EOF in string) should be printed.
In all three cases, the first 80 characters read should be returned as the lexeme.

In all cases (whether or not a too-long condition has occurred), the surrounding quotes are _not_ to be returned as partof the lexeme.

##### T_REAL_LITERAL

A real literal consists of a _mantissa_, _optionally_ followed by an _exponent_.
A mantissa is a sequence of 1 to 9 digits and a period (not counting leading zeroes, which are discarded).
The period can be in the middle or end of the mantissa, but NOT in the beginning (this is according to the Oberon spec).
(Note that a single period, by itself, is not a legal mantissa, but instead
is a punctuation token.)
The exponent, if present, consists of an uppercase E or D, an
_optional_ plus or minus sign, and up to 3 digits.

* If an 11th mantissa character is read (a digit), then digit characters should be read and discarded until either an E, a D, or a non-digit character is read.
In the first two cases (E or D), the lexer should print an error message ("real literal mantissa too long"), and then proceed with reading in the exponent. In the last case, the same error message is printed, the last character read is put back, and the 10 mantissa characters returned as the lexeme.
* If more than 3 exponent digits are read (not including leading zeroes, which are discarded), all succeeding digit characters are read and discarded until a non-digit character is read (which is then put back), and a "real literal exponent too long" message is printed.

##### T_CHAR_LITERAL

A sequence of up to 3 hex digits, followed by the letter X.

* If more than 3 digits are followed by an X, an error message should be printed ("illegal character literal"), and the three digits (plus the X) be returned as the lexeme.
* As with integer literals, leading zeroes are to be discarded.
* Also as with integer literals, lexemes that satisfy the patterns for both identifiers and char literals (such as AX) should be returned as identifiers.

