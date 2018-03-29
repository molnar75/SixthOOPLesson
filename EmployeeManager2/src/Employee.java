import java.time.LocalDate;


public class Employee {
	
	private String employeeName;
	private long salary;
	private LocalDate birthday;
	
	
	static int pensionRemainingAge = 65;
	
	
	public Employee(String employeeName, LocalDate birthday) {
		super();
		this.employeeName = employeeName;
		this.birthday = birthday;
		this.salary = getAge()*10000;
	}
	
	public Employee(String employeeName, long salary, LocalDate birthday) {
		super();
		this.employeeName = employeeName;
		this.salary = salary;
		this.birthday = birthday;
	}
	
	
	public static Employee getYoungerEmployee(Employee employee1, Employee employee2){
		
		if(employee1.getRemainingYearsUntilPansion() > employee2.getRemainingYearsUntilPansion()){
			return employee1;
		}
		else
			return employee2;
	}
	
	public static void setpensionRemainingAgeUntilPension(int newPensionAge){
		Employee.pensionRemainingAge = newPensionAge;
	}
	
	public String toString() {
		return "Employee name:" + employeeName + "\nSalary:" + salary
				+ "\nBirthday:" + birthday + "\nRemaining years until pension:"
				+ getRemainingYearsUntilPansion();
	}

	public int getRemainingYearsUntilPansion(){
		
		return pensionRemainingAge-(LocalDate.now().getYear()-birthday.getYear());
	}
	
	public String displayInfo() {
		return "Salary: " + this.salary + "\n" + "Name: " + this.employeeName + "\n";
	}
	
	public boolean isInSalaryRange(long salaryStart, long salaryEnd){
		
		if((this.salary < salaryEnd) && (this.salary >= salaryStart)){
			return true;
		}
		else return false;
	}
	
	public long getTax(){
		
		return (long) (this.salary*0.16);
	}
	
	public boolean hasHigherSalary(Employee employee){
		if(this.salary > employee.salary){
			return true;
		}
		else return false;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public long getSalary() {
		return salary;
	}
	
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public int getAge() {
		return LocalDate.now().getYear()-birthday.getYear();
	}

}
