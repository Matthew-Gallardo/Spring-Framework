package org.acumen.training.codes.model.form;

import java.time.LocalDate;

public class ProjectForm {
	private Integer id;
	private String projectname;
	private LocalDate projectdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public LocalDate getProjectdate() {
		return projectdate;
	}
	public void setProjectdate(LocalDate projectdate) {
		this.projectdate = projectdate;
	}

	
	
}
