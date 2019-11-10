package c.analyzer;

public class Variable{
	private String varName;
	private int declLine;
	
	public Variable(String varName) {
		this(varName, 0);
	}
	public Variable(String varName, int line){
		this.varName = varName;
		declLine = line;
	}

	public String getName(){
		return varName;
	}
	public int getDeclLine() {
		return declLine;
	}
}