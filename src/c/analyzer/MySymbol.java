package c.analyzer;

import java.lang.reflect.Field;

import java_cup.runtime.Symbol;

/**
 * Custom class used to store the parsed symbols.
 * 
 * @author florin_nica
 */
public class MySymbol extends Symbol {
	/**
	 * The line of the file on which the symbol was found.
	 */
	private int line;
	/**
	 * The column of the file on which the symbol was found.
	 */
	private int column;
	/**
	 * The value of the found symbol.
	 */
	private Object value;

	public MySymbol(int type, int line, int column) {
		this(type, line, column, -1, -1, null);
	}

	public MySymbol(int type, int line, int column, Object value) {
		this(type, line, column, -1, -1, value);
	}

	public MySymbol(int type, int line, int column, int left, int right, Object value) {
		super(type, left, right, value);
		this.line = line;
		this.column = column;
		this.value = value;
	}
	
	/**
	 * Converts an int token code into the name of the token as shown in ISymbol interface.
	 */
	private String getTokenName(int token) {
		try {
			Field [] classFields = ISymbol.class.getFields();
			for (int i = 0; i < classFields.length; i++) {
				if (classFields[i].getInt(null) == token) {
					return classFields[i].getName();
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return "UNKNOWN TOKEN";
	}

	public String getSymbolLocation() {
		return "line: " + line + ", column: " + column;
	}
	
	/**
	 * @return The type of the symbol as shown in ISymbol interface + the java type of the value.
	 */
	public String getSymbolType() {   
		return getTokenName(sym) + (value == null ? "" : (", java type: " +  value.getClass().getSimpleName()));
	}
}
