package org.acumen.training.codes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Market {
	private List<Employee>employees;
	private List<Profile>officers;
	private Profile[] profiles;
	private Map<Integer, Profile>schedule;
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public List<Profile> getOfficers() {
		return officers;
	}
	public void setOfficers(List<Profile> officers) {
		this.officers = officers;
	}
	public Profile[] getProfiles() {
		return profiles;
	}
	public void setProfiles(Profile[] profiles) {
		this.profiles = profiles;
	}
	public Map<Integer, Profile> getSchedule() {
		return schedule;
	}
	public void setSchedule(Map<Integer, Profile> schedule) {
		this.schedule = schedule;
	}
	
	

}
