package employee_management;

public class HashTable {
	
	int Buckets;
	Node[] table;
	
	HashTable(int n){
		this.Buckets = n;
		this.table = new Node[n];
	}
	
	private int hashfunction(char x) {
		int hashkey = (int)x % Buckets; 
		System.out.println("hashkey:" + hashkey);
		return hashkey;
	}
	public void insert(Employee emp) {
		if(emp == null) {
			return;
		}
		int key = hashfunction(emp.name.charAt(0));
		if(table[key] == null) {
			Node node = new Node(key, emp, null);
			table[key] = node;
		}
		else {
			Node temp = table[key];
			while(temp.next != null) {
				temp = temp.next;
			}
			Node node = new Node(key, emp, null);
			temp.next = node;
		}
	}
	
	public void delete(String name, int Id) {
		if(name == "" || Id == 0) {
			return;
		}
		else {
			int key = hashfunction(name.charAt(0));
			System.out.println(key);
			Node temp = table[key];
			if(temp == null) {
				System.out.println("No employee found. Please check agiain");
			}
			else {
				if(name.equals(temp.emp.name) && Id == temp.emp.Id) {
					table[key] = temp.next;
					System.out.println("Employee succesfully fired");
					return;
				}
				else {
					Node prev = temp;
					temp = temp.next;
					while(temp != null) {
						if(name.equals(temp.emp.name) && Id == temp.emp.Id) {
							prev.next = temp.next;
							temp = null;
							System.out.println("Employee succesfully fired");
							return;
						}
						prev = temp;
						temp = temp.next;
					}
					System.out.println("No employee found. Please check agiain");
				}
			}
		}
	}
	
	public Node find(String name) {
		int key = hashfunction(name.charAt(0));
		Node temp = table[key];
		while(temp != null) {
			if(name.equals(temp.emp.name)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
	
	public void viewAll() {
		System.out.println("Id\tName\t\tSalary\t\tType"+"\t\tDuration\tBonus\tContrant years");
		for(int i=0; i < Buckets; i++) {
			if(table[i] == null) {
				continue;
			}
			Node temp = table[i];
			while(temp != null) {
				if(temp.emp.type.equals("Permenent")) {
					PermenentEmployee tempEmp = (PermenentEmployee)temp.emp;
					System.out.println(tempEmp.Id+"\t"+tempEmp.name+"\t\t"+tempEmp.salary+"\t\t"+tempEmp.type+"\t\t\t"+tempEmp.bonus);
				}
				else if(temp.emp.type.equals("Intern")) {
					Interns tempEmp = (Interns)temp.emp;
					System.out.println(tempEmp.Id+"\t"+tempEmp.name+"\t\t"+tempEmp.salary+"\t\t"+tempEmp.type+"\t\t"+tempEmp.duration);
				}
				else if(temp.emp.type.equals("Temporary")) {
					TemporaryEmployee tempEmp = (TemporaryEmployee)temp.emp;
					System.out.println(tempEmp.Id+"\t"+tempEmp.name+"\t\t"+tempEmp.salary+"\t\t"+tempEmp.type+"\t\t\t\t"+tempEmp.contractyears);
				}
				temp = temp.next;
			}
		}
		System.out.println("\n");

	}
	
	
	
}
