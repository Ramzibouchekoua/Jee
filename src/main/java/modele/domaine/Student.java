package modele.domaine;

public class Student {
	private String name;
	private String address;
	private String email;
	private int matricNo;

	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", email=" + email + ", matricNo=" + matricNo + "]";
	}
	public Student(String name, String address, String email, int matricNo) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.matricNo = matricNo;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMatricNo() {
		return matricNo;
	}
	public void setMatricNo(int matricNo) {
		this.matricNo = matricNo;
	}

}
