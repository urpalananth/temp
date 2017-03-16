package inst.an.java8;

public class Employee {
	private Long id;
	private String name;
	private Long deptId;
	private Double salary;
	public Employee(Long id, String name, Long deptId, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.salary = salary;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Long getDeptId() {
		return deptId;
	}
	public Double getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", deptId=" + deptId + ", salary=" + salary + "]";
	}
}
