package employee_management;

public class Node {
	int key;
	Employee emp;
	Node next;
	
	Node(int key, Employee emp, Node next){
		this.key = key;
		this.emp = emp;
		this.next = next;
	}
}
