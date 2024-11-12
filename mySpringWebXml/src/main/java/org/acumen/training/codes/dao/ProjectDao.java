package org.acumen.training.codes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.acumen.training.codes.model.data.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class ProjectDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public boolean insertProject(Project proj) {
		try {
			jdbcTemplate.update("insert into project values (?, ?, ?)", 
					proj.getId(), proj.getProjname(), proj.getProjdate());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public boolean updateNewProjDate(LocalDate newProjDate, Integer id) {
		try {
			jdbcTemplate.update("update project set projdate=? where id=?", 
					newProjDate.toString(), id.shortValue());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Transactional
	public boolean deleteById(Integer id) {
		try {
			jdbcTemplate.update("delete from project where id=?", 
					id.shortValue());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public List<Project> selectAllProjects() {
		List<Project> records = new ArrayList<Project>();
		records= jdbcTemplate.query("select * from project", 
				new RowMapper<Project>() {
					@Override
					public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
						Project proj = new Project();
						proj.setId(rs.getShort("id"));
						proj.setProjname(rs.getString("projname"));
						proj.setProjdate(rs.getDate("projdate").toLocalDate());
						return proj;
					}
			
		});
		return records;
	}
	
	@Transactional
	public Project selectSingleProject(Integer id) {
		Project proj = jdbcTemplate.queryForObject("select * from project where id =?", 
				new RowMapper<Project>() {

					@Override
					public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
						Project proj = new Project();
						proj.setId(rs.getShort("id"));
						proj.setProjname(rs.getString("projname"));
						proj.setProjdate(rs.getDate("projdate").toLocalDate());
						return proj;
					}}, id);
		
		return proj;
	}
	

}
