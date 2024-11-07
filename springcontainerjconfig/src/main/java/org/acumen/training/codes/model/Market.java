package org.acumen.training.codes.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Market {
	@Override
	public String toString() {
		return "Market [employees=" + employees + ", officers=" + officers + ", profiles=" + Arrays.toString(profiles)
				+ ", schedule=" + schedule + "]";
	}
	
	


	@Autowired
	public Market(@Qualifier()List<Employee> employees, @Qualifier()List<Profile> officers, @Qualifier()Profile[] profiles,
			@Qualifier()Map<Integer, Profile> schedule) {
		super();
		this.employees = employees;
		this.officers = officers;
		this.profiles = profiles;
		this.schedule = schedule;
	}



	private static final Logger LOGGER = Logger.getLogger(Market.class.getName());
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
	public void createBean() {
		LOGGER.info("Create Market Object");
	}
	
	public void destroyBean() {
		LOGGER.info("Destroying Market Object");
		
	}
	

}
