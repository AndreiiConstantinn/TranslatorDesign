package c.analyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * The class used to store details about a function.
 * 
 * @author florin_nica
 */
public class Function{
	/**
	 * The name of the function found by the analyzer.
	 */
	private String functionName;
	/**
	 * The number of statements in function.
	 */
	private int nrOfStatements;
	/**
	 * The number of calls for the function.
	 */
	private int nrOfCalls;
	/**
	 * The list of local variables in the function.
	 */
	private List<Variable> varList;
	/**
	 * The line where the function was defined.
	 */
	private int defLine;
	
	/**
	 * Constructor1 
	 * @param functionName The name of the function.
	 */
	public Function(String functionName) {
		this(functionName, 0);
	}
	
	/**
	 * Constructor2
	 * @param functionName The name of the function.
	 * @param defLine      The line where the function was defined.
	 */
	public Function(String functionName, int defLine) {
		this.functionName = functionName;
		this.defLine = defLine;
		varList = new ArrayList<>();
	}
	
	/**
	 * Adds a variable to the list of local variables of the function.
	 * @param var The variable to add.
	 */
	public void addVariable (Variable var){
		varList.add(var);
	}
	/**
	 * Increases the number of local statements.
	 */
	public void addStatement(){
		nrOfStatements++;
	}
	/**
	 * @return The number of local statements.
	 */
	public int getNrOfStatements(){
		return nrOfStatements;
	}
	/**
	 * @return The name of the function.
	 */
	public String getName(){
		return functionName;
	}
	/**
	 * @return The list of local variables.
	 */
	public List<Variable> getVarList(){
		return varList;
	}
	public int getNrOfCalls(){
		return nrOfCalls;
	}
	public int getDefLine() {
		return defLine;
	}
}