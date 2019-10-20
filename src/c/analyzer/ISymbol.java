package c.analyzer;

public interface ISymbol {
  /* terminals */
  public static final int QMARK = 75;
  public static final int SHORT = 44;
  public static final int SIGNED = 45;
  public static final int SUB_ASSGN = 82;
  public static final int IDENTIFIER = 25;
  public static final int GT = 66;
  public static final int MOD_ASSGN = 80;
  public static final int CONST = 30;
  public static final int NOTEQ = 70;
  public static final int _BOOL = 55;
  public static final int REGISTER = 42;
  public static final int ENUM = 35;
  public static final int RBRACK = 12;
  public static final int SIZEOF = 46;
  public static final int LSHIFT_ASSGN = 83;
  public static final int COMMA = 14;
  public static final int RBRACE = 10;
  public static final int MULT_ASSGN = 78;
  public static final int RPAREN = 8;
  public static final int LBRACK = 11;
  public static final int LT = 17;
  public static final int BIT_XOR = 71;
  public static final int DOUBLE = 3;
  public static final int STRUCT = 48;
  public static final int LBRACE = 9;
  public static final int LPAREN = 7;
  public static final int INTEGER_LITERAL = 23;
  public static final int NOT = 62;
  public static final int _COMPLEX = 56;
  public static final int ADD_ASSGN = 81;
  public static final int _IMAGINARY = 57;
  public static final int INLINE = 40;
  public static final int FLOAT = 37;
  public static final int GOTO = 38;
  public static final int ASSGN = 16;
  public static final int MOD = 63;
  public static final int LONG = 41;
  public static final int PLUS = 19;
  public static final int WHILE = 54;
  public static final int UNION = 51;
  public static final int EQUAL = 69;
  public static final int BITOR_ASSGN = 87;
  public static final int BIT_COMPL = 61;
  public static final int CHAR = 29;
  public static final int RSHIFT_ASSGN = 84;
  public static final int SWITCH = 49;
  public static final int DO = 33;
  public static final int FOR = 4;
  public static final int STAR = 22;
  public static final int VOID = 6;
  public static final int EXTERN = 36;
  public static final int DIV = 21;
  public static final int BIT_OR = 72;
  public static final int RETURN = 5;
  public static final int ELSE = 34;
  public static final int RESTRICT = 43;
  public static final int BREAK = 27;
  public static final int GTEQ = 68;
  public static final int DOT = 15;
  public static final int INT = 2;
  public static final int AMPER = 60;
  public static final int EOF = 0;
  public static final int SEMICOLON = 13;
  public static final int DEFAULT = 32;
  public static final int DECREMENT = 59;
  public static final int BITXOR_ASSGN = 86;
  public static final int MINUS = 20;
  public static final int LTEQ = 67;
  public static final int OR = 74;
  public static final int error = 1;
  public static final int INDIR_SEL = 58;
  public static final int CONTINUE = 31;
  public static final int IF = 39;
  public static final int UNSIGNED = 52;
  public static final int COLON = 76;
  public static final int DIV_ASSGN = 79;
  public static final int VOLATILE = 53;
  public static final int CASE = 28;
  public static final int PLUSPLUS = 18;
  public static final int RSHIFT = 65;
  public static final int BITAND_ASSGN = 85;
  public static final int AND = 73;
  public static final int ELLIPSIS = 77;
  public static final int STATIC = 47;
  public static final int LSHIFT = 64;
  public static final int TYPEDEF = 50;
  public static final int AUTO = 26;
  public static final int FLOATING_POINT_LITERAL = 24;
  public static final String[] terminalNames = new String[] {
  "EOF",
  "error",
  "INT",
  "DOUBLE",
  "FOR",
  "RETURN",
  "VOID",
  "LPAREN",
  "RPAREN",
  "LBRACE",
  "RBRACE",
  "LBRACK",
  "RBRACK",
  "SEMICOLON",
  "COMMA",
  "DOT",
  "ASSGN",
  "LT",
  "PLUSPLUS",
  "PLUS",
  "MINUS",
  "DIV",
  "STAR",
  "INTEGER_LITERAL",
  "FLOATING_POINT_LITERAL",
  "IDENTIFIER",
  "AUTO",
  "BREAK",
  "CASE",
  "CHAR",
  "CONST",
  "CONTINUE",
  "DEFAULT",
  "DO",
  "ELSE",
  "ENUM",
  "EXTERN",
  "FLOAT",
  "GOTO",
  "IF",
  "INLINE",
  "LONG",
  "REGISTER",
  "RESTRICT",
  "SHORT",
  "SIGNED",
  "SIZEOF",
  "STATIC",
  "STRUCT",
  "SWITCH",
  "TYPEDEF",
  "UNION",
  "UNSIGNED",
  "VOLATILE",
  "WHILE",
  "_BOOL",
  "_COMPLEX",
  "_IMAGINARY",
  "INDIR_SEL",
  "DECREMENT",
  "AMPER",
  "BIT_COMPL",
  "NOT",
  "MOD",
  "LSHIFT",
  "RSHIFT",
  "GT",
  "LTEQ",
  "GTEQ",
  "EQUAL",
  "NOTEQ",
  "BIT_XOR",
  "BIT_OR",
  "AND",
  "OR",
  "QMARK",
  "COLON",
  "ELLIPSIS",
  "MULT_ASSGN",
  "DIV_ASSGN",
  "MOD_ASSGN",
  "ADD_ASSGN",
  "SUB_ASSGN",
  "LSHIFT_ASSGN",
  "RSHIFT_ASSGN",
  "BITAND_ASSGN",
  "BITXOR_ASSGN",
  "BITOR_ASSGN"
  };
}

