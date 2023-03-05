package employee_management;
import java.util.Scanner;

public class OfficeMain {

	public static void main(String[] args) {
		HashTable hT = new HashTable(10);
		Scanner data = new Scanner(System.in);
		System.out.println("Welcome to Employee management System\n");
		
		while(true) {
			System.out.println("1 - Add Employee\n2 - Fire Employee\n3 - Increase salary\n4 - View details of all employees\n-1 - exit\n");
			System.out.println("Choose the prefered option:");
			int preference = data.nextInt();
			if(preference == 1) {
				System.out.println("\n1 - Permenant employee\n2 - Temporery employee\n3 - Trainee\nSelect Employee type:");
				int Emtypeint = data.nextInt();
				if(Emtypeint == 1) {
					System.out.println("Enter Name:");
					String name = data.next();
					System.out.println("Enter Salary:");
					int salary = data.nextInt();
					System.out.println("Enter bonus:");
					int bonus = data.nextInt();
					PermenentEmployee Permenent = new PermenentEmployee(name, salary, bonus);
					hT.insert(Permenent);
				}
				else if(Emtypeint == 2) {
					System.out.println("Enter Name:");
					String name = data.next();
					System.out.println("Enter Salary:");
					int salary = data.nextInt();
					System.out.println("Enter contract year:");
					int years = data.nextInt();
					TemporaryEmployee Contract = new TemporaryEmployee(name, salary, years);
					hT.insert(Contract);
				}
			
				else if(Emtypeint == 3) {
					System.out.println("Enter Name:");
					String name = data.next();
					System.out.println("Enter Salary:");
					int salary = data.nextInt();
					System.out.println("Enter duration:");
					int duration = data.nextInt();
					Interns Trainee = new Interns(name, salary, duration);
					hT.insert(Trainee);	
				}
				else {
					System.out.println("Wrong Input");
				}
			}
			else if(preference == 2) {
				System.out.println("....Enter Name and Id of the employee to fire....");
				System.out.println("Enter Name:");
				String name = data.next();
				System.out.println("Enter Id number:");
				int Id = data.nextInt();
				hT.delete(name, Id);
			}
			else if (preference == 3){
				System.out.println("Enter Name:");
				String name = data.next();
				System.out.println("Enter Salary increment:");
				int salary = data.nextInt();
				Node toChange = hT.find(name);
				if(toChange != null) {
					toChange.emp.salary += salary;
				}
				else {
					System.out.println("Employee not found");
				}
			}
			
			else if (preference == 4){
				hT.viewAll();
			}
			
			else if(preference == -1) {
				break;
			}
			else {
				System.out.println("Wrong input");
			}
		}
		data.close();
	}
}
