package org.acumen.training.codes.model.data;

import java.time.LocalDate;

import org.springframework.stereotype.Component;


@Component
public class Project {
	private Short id;
	private String projname;
	private LocalDate projdate;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

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
