import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int salary, age;
		
		System.out.println("Enter the number of employees: ");
		int n = scanner.nextInt();
		Employee[] employeeArray = new Employee[n];
		
		for(int i=0; i < n; i++){
			//employeeArray[i] = new Employee();
			System.out.println("\nEnter the name of your " +(i+1) + ". employee:");
			String name = scanner.next();
			System.out.println("Enter the salary of your " + (i+1) + ". employee:");
			salary = scanner.nextInt();
			System.out.println("Enter the age of your " + (i+1) + ". employee:");
			age = scanner.nextInt();
			employeeArray[i] = new Employee(name, salary, age);
			System.out.println(employeeArray[i]);
		}
		
		Employee.setpensionRemainingAgeUntilPension(75);
		System.out.println("\nPension remaining years 75:\n");
		
		for (Employee employee : employeeArray) {
			System.out.println(employee);
		}
		
		System.out.println("\nRemaining years until Pension lower than 5:\n ");
		for (Employee employee : employeeArray) {
			if(employee.getRemainingYearsUntilPansion() < 5){
				System.out.println(employee);
			}
		}
		
		
		
		int avg=0;
		for(int i = 0; i < n; i++){
			avg = employeeArray[i].getRemainingYearsUntilPansion() + avg;
		}
		
		avg = avg/n;
		
		System.out.println("\nRemaining years until pension higher than the avarage:\n ");
		
		for(int i = 0; i < n; i++){
			if(employeeArray[i].getRemainingYearsUntilPansion() > avg){
				System.out.println(employeeArray[i]+ "\n");
			}
		
		}
		
		
		System.out.println("\nBy lowest years until pension:\n");
		Employee seged;
		
		for(int i = 0; i < n-1; i++){
			for(int j = i+1; j < n; j++){
				if(employeeArray[i].getRemainingYearsUntilPansion() > employeeArray[j].getRemainingYearsUntilPansion()){
					seged = new Employee(employeeArray[i].getEmployeeName(), employeeArray[i].getSalary(), employeeArray[i].getAge());
					employeeArray[i] = new Employee(employeeArray[j].getEmployeeName(), employeeArray[j].getSalary(), employeeArray[j].getAge());
					employeeArray[j] = new Employee(seged.getEmployeeName(), seged.getSalary(), seged.getAge());
				}
			}
		}
		
		for(int i = 0; i < n; i++){
			System.out.println(employeeArray[i]);
		
		}
		
		System.out.println("\nBy highest years until pension:\n");
		
		for(int i = 0; i < n-1; i++){
			for(int j = i+1; j < n; j++){
				if(employeeArray[i].getRemainingYearsUntilPansion() < employeeArray[j].getRemainingYearsUntilPansion()){
					seged = new Employee(employeeArray[i].getEmployeeName(), employeeArray[i].getSalary(), employeeArray[i].getAge());
					employeeArray[i] = new Employee(employeeArray[j].getEmployeeName(), employeeArray[j].getSalary(), employeeArray[j].getAge());
					employeeArray[j] = new Employee(seged.getEmployeeName(), seged.getSalary(), seged.getAge());
				}
			}
		}
		
		for(int i = 0; i < n; i++){
			System.out.println(employeeArray[i] + "\n");
		
		}
		
		scanner.close();
		
	}

}
