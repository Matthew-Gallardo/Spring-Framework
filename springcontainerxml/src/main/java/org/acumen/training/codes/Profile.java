package org.acumen.training.codes;

public class Profile {

	private Integer id;
	private String firstname;
	private String lastname;
	private Double salary;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	//Hook Methods
	public void createBean() {
		System.out.println("Creating Profile Object");
	}
	
	public void destroyBean() {
		System.out.println("Destroying Profile Object");
	}
	@Override
	public String toString() {
		return "Profile [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", salary=" + salary + "]";
	}
	
}
