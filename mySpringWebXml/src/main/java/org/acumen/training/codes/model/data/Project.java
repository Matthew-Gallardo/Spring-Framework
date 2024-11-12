package org.acumen.training.codes.model.data;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(catalog = "hrms", name = "project")
public class Project {
	private Short id;
	private String projname;
	private LocalDate projdate;

	@Id
	@Column(name = "id" , nullable = false, unique = true)
	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}
	@Column(name = "projname" , nullable = false, length = 200)
	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}
	@Column(name = "projdate" , nullable = false)
	public LocalDate getProjdate() {
		return projdate;
	}

	public void setProjdate(LocalDate projdate) {
		this.projdate = projdate;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projname=" + projname + ", projdate=" + projdate + "]";
	}

}
