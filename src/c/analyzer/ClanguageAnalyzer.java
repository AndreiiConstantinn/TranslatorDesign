package c.analyzer;
import java.io.FileReader;

/**
 * Main class, initializes the lexical analyzer and parses a test file. 
 * 
 * @author florin_nica
 */
public class ClanguageAnalyzer {
	public static void main(String args[]) {
		Lexer lex = null;
		try {
			lex = new Lexer(new FileReader("test/resources/input.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MySymbol symbol = null;		
		do {
			try {
				symbol = (MySymbol) lex.next_token();
				System.out.println("The analyzer found: \""+ lex.yytext() + "\" located at: " + symbol);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (symbol.sym != 0);
	}
}