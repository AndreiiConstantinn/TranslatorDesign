package c.analyzer;

import java_cup.runtime.Symbol;

/**
 * Custom class used to store the parsed symbols.
 * 
 * @author florin_nica
 */
public class MySymbol extends Symbol {
	private int line;
	private int column;

	public MySymbol(int type, int line, int column) {
		super(type, -1, -1, null);
	}

	public MySymbol(int type, int line, int column, Object value) {
		this(type, line, column, -1, -1, value);
	}

	public MySymbol(int type, int line, int column, int left, int right, Object value) {
		super(type, left, right, value);
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public String toString() {   
		return "line: "+ line + ", column: "+ column;
	}
}
