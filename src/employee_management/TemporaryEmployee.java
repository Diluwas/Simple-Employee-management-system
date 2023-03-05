package employee_management;

public class TemporaryEmployee extends Employee {
	
	int contractyears;

	TemporaryEmployee(String name, int salary, int contractyears){
		super(name, salary, "Temporary");
		this.contractyears = contractyears;
	}

}
