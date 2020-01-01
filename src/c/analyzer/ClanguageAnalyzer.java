package c.analyzer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class, initializes the lexical analyzer and parses the input files. 
 * 
 * @author florin_nica
 */
public class ClanguageAnalyzer {

	private String messageToDisplay = "The selected file is a VALID .c file!";
	
	private Parser cParser;
	
	private Map<String, String> variablesLocation = new HashMap<>();
	
	private Map<String, Integer> variablesRefs = new HashMap<>();
	
	/**
	 * Analyzes an input .c file and writes the results provided by lexer into an outputFile.
	 * 
	 * @param inputFileName  The path of the .c file to analyze.
	 * @param outputFileName The path of the file to store the results.
	 */
	public void runAnalyzer(String inputFileName, String outputFileName) {
		Lexer lexer = null;
		Lexer lexerCopy = null;
		try {
			lexer = new Lexer(new FileReader(inputFileName));
			lexerCopy = new Lexer(new FileReader(inputFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// if the file is valid
		if (runParser(lexerCopy)) {
			MySymbol symbol = null;	
			StringBuilder result = new StringBuilder();
			do {
				try {
					symbol = (MySymbol) lexer.next_token();
					result.append("Analyzer found the symbol: \""+ lexer.yytext() + 
								"\", located at: " + symbol.getSymbolLocation() +
								", type: " + symbol.getSymbolType());
					result.append("\n");
					if (symbol.sym == ISymbol.IDENTIFIER) {
						String variableName = lexer.yytext();
						variablesLocation.putIfAbsent(lexer.yytext(), symbol.getSymbolLocation());
						if (variablesRefs.containsKey(variableName)) {
							variablesRefs.put(variableName, (Integer)variablesRefs.get(variableName).intValue() + 1) ;
						
						} else {
							variablesRefs.put(variableName, 0);
						}
						System.out.println(lexer.yytext());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (symbol.sym != 0);
			
			if (outputFileName.isEmpty()) {
				System.out.println(result.toString());
			} else {
				PrintWriter writer = null;
				try {
					writer = new PrintWriter(outputFileName);
					writer.write(result.toString());
				} catch (FileNotFoundException e) {
					messageToDisplay = "Invalid output file.";
				} finally {
					writer.close();
				}
			}
		// if the file is not valid
		} else {
			messageToDisplay = "The selected file is an INVALID .c file!";
		}
	}
	
	/**
	 * Parses an input file and checks if it is a valid .c file.
	 * 
	 * @param lexer The lexer used as default Scanner.
	 * @return <code>true</code> if it is a valid .c file, <code>false</code> otherwise.
	 */
	@SuppressWarnings("deprecation")
	public boolean runParser(Lexer lexer) {
		try {
			this.cParser = new Parser(lexer);
			this.cParser.debug_parse();
		// if any exception thrown by the internal parser is caught
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * @return The message that will be displayed in the analyzer gui.
	 */
	public String getMessageToDisplay() {
		return messageToDisplay == null ? "" : messageToDisplay;
	}
	
	/**
	 * @return The C parser.
	 */
	public Parser getParser() {
		return cParser;
	}
	
	/**
	 * @return The location of the found variables.
	 */
	public Map<String, String> getVariablesLocations() {
		return variablesLocation;
	}
	
	public Map<String, Integer> getVariablesRefs() {
		return variablesRefs;
	}
	
	public static void main(String args[]) {
		ClanguageAnalyzer cAnalyzer = new ClanguageAnalyzer();
		cAnalyzer.runAnalyzer("test/resources/input.txt", "");
		
		FunctionsAnalyzer fAnalyzer = cAnalyzer.cParser.getAnalyzer();
		
		System.out.println("\n# The functions are: ");
		for (Function function : fAnalyzer.getFunctions()) {
			System.out.println("- " + function.getName()); //+ ", located at line: " + function.getDefLine());
		}
		System.out.println("\n# The variables are: ");
		for (Variable variable : fAnalyzer.getVarList()) {
			String varName = variable.getName();
			System.out.println("- " + varName + ", located at: " + cAnalyzer.variablesLocation.get(varName)
											  + ", references: " + cAnalyzer.variablesRefs.get(varName));
		}
		System.out.println("\n# Statements count: " + fAnalyzer.getNrOfStatements());
	}
}