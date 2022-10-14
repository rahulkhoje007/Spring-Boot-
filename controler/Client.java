package controler;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import model.Department;
import model.Employee;

public class Client {
	public static void main(String[] args) {
		Employee e1 = new Employee("Rahul", "Aurangabad", "rahulkhoje007@gmail.com");
		Employee e2 = new Employee("Ankit", "Ratlam", "ankit@gmail.com");
		Employee e3 = new Employee("Rahul", "Aurangabad", "rahulkhoje007@gmail.com");

		Department d1 = new Department("IT", "it@gmail.com", "Pune");
		Department d2 = new Department("Math", "math@gmail.com", "Mum");

		Map<Employee, Department> limap = new LinkedHashMap<>();

		limap.put(e1, d1);
		limap.put(e2, d2);
		limap.put(e3, d1);
		limap.put(e1, d2);

		Set<java.util.Map.Entry<Employee, Department>> entryset = limap.entrySet();
		Iterator<java.util.Map.Entry<Employee, Department>> iterator = entryset.iterator();

		while (iterator.hasNext()) {
			Map.Entry<Employee, Department> entry = (Map.Entry<Employee, Department>) iterator.next();
			Employee emp = entry.getKey();
			Department dept = entry.getValue();
			System.out.println(emp);
			System.out.println(dept);
		}
	}

}
