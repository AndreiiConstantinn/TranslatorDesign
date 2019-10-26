package c.analyzer;
import java.io.FileReader;

/**
 * Main class, initializes the lexical analyzer and parses a test file. 
 * 
 * @author florin_nica
 */
public class ClanguageAnalyzer {
	public static void main(String args[]) {
		Lexer lexer = null;
		try {
			lexer = new Lexer(new FileReader("test/resources/input.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MySymbol symbol = null;		
		do {
			try {
				symbol = (MySymbol) lexer.next_token();
				System.out.println("Analyzer found the symbol: \""+ lexer.yytext() + 
									"\", located at: " + symbol.getSymbolLocation() +
									", type: " + symbol.getSymbolType());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (symbol.sym != 0);
	}
}