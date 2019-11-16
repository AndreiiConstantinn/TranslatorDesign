package c.analyzer;

/**
 * The class used to store details about a variable.
 * 
 * @author florin_nica
 */
public class Variable {
	/**
	 * The name of the variable.
	 */
	private String varName;
	/**
	 * The line where the variable was declared.
	 */
	private int declLine;
	
	/**
	 * Constructor1
	 * @param varName The name of the variable.
	 */
	public Variable(String varName) {
		this(varName, 0);
	}
	
	/**
	 * Constructor2
	 * @param varName  The name of the variable.
	 * @param declLine The line where the variable was declared.
	 */
	public Variable(String varName, int declLine){
		this.varName = varName;
		this.declLine = declLine;
	}

	/**
	 * @return The name of the variable.
	 */
	public String getName(){
		return varName;
	}
	/**
	 * @return The declaration line of the variable.
	 */
	public int getDeclLine() {
		return declLine;
	}
}