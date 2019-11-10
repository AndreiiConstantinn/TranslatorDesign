package c.analyzer;

import java.util.ArrayList;
import java.util.List;

public class Function{
	private String functionName;
	private List<Variable> varList;
	private int nrOfStatements;
	private int nrOfCalls;
	
	public Function(String functionName){
		this.functionName = functionName;
		varList = new ArrayList<>();
	}
	public void addVar(Variable v){
		varList.add(v);
	}
	public int getNrOfVariables(){
		return varList.size();
	}
	public void addStatement(){
		nrOfStatements++;
	}
	public int getNrOfStatements(){
		return nrOfStatements;
	}
	public String getName(){
		return functionName;
	}
	public List<Variable> getVarList(){
		return varList;
	}
	public int getNrOfCalls(){
		return nrOfCalls;
	}
}