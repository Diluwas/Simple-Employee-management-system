package employee_management;

public class Employee {
	static int id = 0;
	int Id;
	String name;
	int salary;
	String type;
	
	Employee(String name, int salary, String type) {
		id += 1;
		this.Id = id;
		this.name = name;
		this.salary = salary;
		this.type = type;
	}
}

