package employee_management;

public class Interns extends Employee {
	
	int duration;
	
	Interns(String name, int salary, int duration) {
		super(name, salary, "Intern");
		this.duration = duration;
	}
}
