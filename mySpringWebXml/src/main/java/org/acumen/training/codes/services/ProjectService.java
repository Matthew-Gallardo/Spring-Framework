package org.acumen.training.codes.services;

import java.util.List;

import org.acumen.training.codes.dao.ProjectDao;
import org.acumen.training.codes.model.data.Project;
import org.acumen.training.codes.model.form.ProjectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDao projectDao;

	@Transactional
	public boolean insertRecord(ProjectForm form) {
		Project project = new Project();
		project.setId(form.getId().shortValue());
		project.setProjname(form.getProjectname());
		project.setProjdate(form.getProjectdate());
		boolean result = projectDao.insertProject(project);
		if (result) {
			return true;
		} return false;
	}
	
	@Transactional
	public List<Project	>retrieveAll(){
		return projectDao.selectAllProjects();
	}
}
