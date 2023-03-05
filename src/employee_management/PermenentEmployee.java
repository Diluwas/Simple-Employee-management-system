package employee_management;

public class PermenentEmployee extends Employee{
	
	int bonus;
	PermenentEmployee(String name, int salary, int bonus){
		super(name, salary, "Permenent");
		this.bonus = bonus;
	}
}
