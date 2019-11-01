package c.analyzer;
import java.io.FileReader;

/**
 * Main class, initializes the lexical analyzer and parses the input files. 
 * 
 * @author florin_nica
 */
public class ClanguageAnalyzer {
	/**
	 * Analyzes an input .c file and writes the result into an outputFile.
	 * 
	 * @param inputFileName
	 * @param outputFileName
	 */
	public void runAnalyzer(String inputFileName, String outputFileName) {
		Lexer lexer = null;
		try {
			lexer = new Lexer(new FileReader(inputFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MySymbol symbol = null;		
		do {
			try {
				symbol = (MySymbol) lexer.next_token();
				if (outputFileName.isEmpty()) {
					System.out.println("Analyzer found the symbol: \""+ lexer.yytext() + 
							"\", located at: " + symbol.getSymbolLocation() +
							", type: " + symbol.getSymbolType());
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (symbol.sym != 0);
	}
	
	public static void main(String args[]) {
		new ClanguageAnalyzer().runAnalyzer("test/resources/input.txt", "");
	}
}