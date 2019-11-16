package c.analyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * The syntactic analyzer for functions.
 * 
 * @author florin_nica
 */
public class FunctionsAnalyzer{
	/**
	 * The current function analyzed.
	 */
	private Function currentFunction;
	/**
	 * The list of functions analyzed.
	 */
	private List<Function> functionsList;
	/**
	 * The list of global variables.
	 */
	private List<Variable> variablesList;
	/**
	 * The total number of statements.
	 */
	private int nrOfStatements;
	/**
	 * Flag to check if the found variables are outside the functions.
	 */
	private boolean isGlobal = true;
	
	/**
	 * Constructor with no parameters.
	 */
	public FunctionsAnalyzer(){
		variablesList = new ArrayList<>();
		functionsList = new ArrayList<>();
	}

	/**
	 * Increases the global number of statements and the number of statements of current function.
	 */
	public void addStatement(){
		nrOfStatements ++;
		if(currentFunction != null) {
			currentFunction.addStatement();
		}
	}
	
	/**
	 * Changes the current function to a new function found by analyzer.
	 * @param functionName The name of the new function.
	 * @param defLine      The line where the function was defined.
	 */
	public void changeCurrentFunction(String functionName, int defLine) {
		if (functionName != null) {
			if (functionName.charAt(functionName.length() - 1) != ')') {
				functionName = functionName + "()";
			}
			currentFunction = new Function((String)functionName);
			System.out.println("The current function is: " + functionName);
			isGlobal = false;
			
		} else {
			currentFunction = null;
			isGlobal = true;
		}
	}
	
	/**
	 * Creates a variable and adds it to the list of local/global variables.
	 * @param variableName The name of the variable.
	 */
	public void addVariable(String variableName) {
		Variable variable = new Variable(variableName);
		if (isGlobal) {
			variablesList.add(variable);
		} else {
			currentFunction.addVariable(variable);
		}
	}
	/**
	 * Adds the current function to the functions list.
	 */
	public void addFunction() {
		functionsList.add(currentFunction);
		isGlobal = true;
	}
	/**
	 * @return The list of functions.
	 */
	public List<Function> getFunctions() {
		return functionsList;
	}
	/**
	 * @return The current function found by analyzer.
	 */
	public Function getCurrentFunction() {
		return currentFunction;
	}
	/**
	 * @return The total number of statements.
	 */
	public int getNrOfStatements() {
		return nrOfStatements;
	}
	/**
	 * @return The list of variables.
	 */
	public List<Variable> getVarList() {
		return variablesList;
	}
}