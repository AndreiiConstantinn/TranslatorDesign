package c.analyzer;

import java.util.ArrayList;
import java.util.List;

public class FunctionsAnalyzer{
	private boolean isGlobal = true;
	private Function currentFunction;
	private List<Variable> globalVarList;
	private List<Function> functionsList;
	private int nrOfStatements;
	
	public FunctionsAnalyzer(){
		globalVarList = new ArrayList<>();
		functionsList = new ArrayList<>();
	}

	public void addStatement(){
		nrOfStatements ++;
		if(currentFunction != null) {
			currentFunction.addStatement();
		}
	}
	
	public void changeCurrentFunction(String functionName) {
		if (functionName.charAt(functionName.length() - 1) != ')') {
			functionName = functionName + "()";
		}
		currentFunction = new Function((String)functionName);
		System.out.println("The current function is: " + functionName);
		isGlobal = false;
	}
	
	public void addFunction() {
		functionsList.add(currentFunction);
		isGlobal = true;
	}
	
	public List<Function> getFunctions() {
		return functionsList;
	}
	
	public Function getCurrentFunction() {
		return currentFunction;
	}
	
	public int getNrOfStatements() {
		return nrOfStatements;
	}
}