package beans;

public class SEmployee extends Employee {
private String tool;
public String getTool() {
	return tool;
}
public void setTool(String tool) {
	this.tool = tool;
}
public SEmployee() {
}
public SEmployee(String tool) {
	super();
	this.tool = tool;
}

}
