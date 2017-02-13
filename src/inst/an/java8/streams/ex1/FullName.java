package inst.an.java8.streams.ex1;

public class FullName {
	private String firstName;
	private String middleName;
	public FullName(String firstName, String middleName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
	}
	public FullName(Object names[]) {
		super();
		this.firstName = names[0].toString();
		this.middleName = names[1].toString();
	}
	@Override
	public String toString() {
		return "[firstName=" + firstName + ", middleName=" + middleName + "]";
	}
}
