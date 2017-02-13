package inst.an.java8.streams.ex1;

public class Employee {
	private Long id;
	private String dept;
	private Double salary;
	public Employee(Long id, String dept, Double salary) {
		super();
		this.id = id;
		this.dept = dept;
		this.salary = salary;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", dept=" + dept + ", salary=" + salary + "]";
	}
}
