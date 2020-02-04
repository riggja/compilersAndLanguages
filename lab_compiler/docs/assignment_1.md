# Lexer Project Specification

Modified from http://cseweb.ucsd.edu/classes/fa00/cse131a/

## Compiler Project #1 -- Lexical Analysis

For this assignment, we will be building the lexical analysis component of a compiler, often referred to as a _lexer_.
A lexer performs three basic functions:

1. Recognize patterns in the input stream (such patterns are called _lexemes_), and pass internal representations of lexemes (called tokens) on for later processing.
	Examples of tokens are keywords (such as **IF**, **ELSE**, **RETURN**, etc), punctuation symbols  (such  as semicolons, periods, commas, also two-character symbols like assignment (  :=  )  or greater-than-or-equal  (  >= )), literals (such as **44**, **7.0**,  or **&quot;Hello&quot;**),  and  user-defined identifiers.
	The [Oberon Token Specification](tokens.md) specifies the complete set of Oberon tokens and their patterns.
1. Discard input characters that are not part of any lexeme.
	(In other words, ignore characters that we don't care about). 
	This would include comments, whitespace characters (spaces, tabs, newlines) and any illegal characters that may be read.
1. Report any lexical errors encountered.

### Specification

The lexer must be implemented as a class called **Lexer** which contains a public method called **getToken()**.
This method returns an object of type **Token**.

The specification for **getToken** is:

```Java
public Token getToken()
```

We provide three files -- _sym.java_, containing the valid token codes, _Token.java_, containing the Token class to be returned by **GetToken()**, _ILexer.java_, the Lexer interface, and  _LexerTester.java_, a test program for your lexer.
A program class (**Oberon**), whose main() method instantiates a **Lexer** instance and then passes that object to a newly instantiated **LexerTester** instance (as shown in _LexerTester.java_).

### Notes

* Your program should assume that any command line argument that starts with a minus sign ('-') is an option of some sort (like many Unix commands), and any argument that does not start with a '-' sign is a file to be opened.
This will hold for all projects now and later -- for this project, there are no options, but you might want to be prepared for future projects.
* Your program should read file(s) from the command line (if one or more are passed in) or from standard input (if no command line arguments are found).
We extend the Oberon language to support an include mechanism similar to the #include mechanism in C++ -- if you read the string **INCLUDE** followed by a string literal (there may be arbitrary whitespace or comments between the INCLUDE and the literal), you are to open the specified file and scan characters from there, and then continue with the original file.
(The INCLUDE and the literal are then discarded, not returned themselves as tokens.)
Note that included files may themselves have include specifications.
You are to disallow processing the same file more than once (see the last error message below).

* Oberon is case-sensitive.
All Oberon keywords consist solely of uppercase letters.
Thus, the lexeme **ELSE** should be recognized as the else keyword, while the lexeme **else** should be considered an identifier.
* Comments in Oberon are delimited by two pairs of strings, (\* and \*).
Comments can be nested, thus the input ** (\* this is (\* one \*) comment \*) ** is indeed a single comment and should be treated as such.
Also note that a comment is considered a separator -- thus, an input consisting of **ELS(\*comment\*)IF** (with no spaces) should be processed as two tokens (the identifier ELS and the keyword IF) and not the single keyword ELSIF.


### Error Messages


All error messages should be printed to standard output, not to standard error.
This bears repeating: **all error messages should be printed to standard output, not standard error.**
All error messages must be one of the following two forms: 

```sh
Error, "file", line N: <message>
Error, (stdin), line N: <message>
```
depending on whether the lexer is currently reading from a file or from standard input.
Note that you must keep track of the line number (most likely, this would be a private member of the Lexer class).

&lt;message&gt; is one of the following:

* **unknown character 'c'**, when the lexer encounters a character (other than whitespace) that doesn't match any token pattern.
* **newline in string literal**, when the lexer finds a newline character during the processing of a string literal.
* **EOF in string literal**, when the lexer encounters the end of file during the processing of a string literal.
* **unterminated comment**, when the lexer encounters the end of file while processing a comment.
* **&lt;something&gt; too long**, when the lexer encounters a lexeme that is too long, given the rules specified in the token spec. &lt;something&gt; is one of **identifier**, **string literal,** **integer literal**, **real literal (mantissa)**, **real literal (exponent)**, or **character literal**.
* **illegal hex integer literal "&lt;lexeme&gt;"**, when a hex int literal without a trailing H is found (example: 123ABC).
* **cannot open file "&lt;file&gt;"**, when one of the files on the command line cannot be opened. 
Note that the lexer should attempt to process all files on the command line, even if one or more of them fail to open.
* **illegal include directive "&lt;lexeme&gt;"**, when the INCLUDE string is followed by any token other than a string literal.
* **bad include file "&lt;file&gt;"**, when the INCLUDE string is followed by a valid string literal, but one that specifies a file that cannot be opened.
* **multiply included file "&lt;file&gt;"**, when the INCLUDE string is followed by a string literal that represents a previously read file.
This could either be a result of a _circular_ include (file A includes file B, and inside file B is an include of file A), or simply a file included more than once directly.

For the last three cases, both the INCLUDE and the offending token are discarded, and the lexer should continue looking for a valid token.
Note that this means that the string INCLUDE can never be returned by the lexer as any token.

### Extra Credit

Extra credit will be given to students to who improve the project tests.
You can get extra credit for:

* Improving a test 
* Fixing a test that is incorrect
* Adding a test to increase the test coverage (add a missing LEXEME)

The new test should be submitted through Gitlab's merge request with only the test change.
Only if the test is accepted will the student get extra credit.

### Turnin Instructions

You will turn in your source code (not your executables) to us electronically via gitlab, and we will build and run your project.
Therefore, it is very important that you adhere to the following.

* Make sure all the test are passing before in for project.
* Do not change the way **Oberon** main class functions.
Once your project is submitted for grading, the autograder will run it by executing the command **oberon**.
