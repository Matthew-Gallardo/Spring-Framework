package org.acumen.training.codes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.acumen.training.codes.model.data.Project;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


@Repository
public class ProjectDao {
	
	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	@PersistenceContext
	private EntityManager em;
	
	public ProjectDao() {
		// TODO Auto-generated constructor stub
	}
	public ProjectDao(EntityManager em) {
		this.em = em;
	}
	
	

	/*
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
	*/
	@Transactional
	public boolean insertProject(Project proj) {
		try {
			em.persist(proj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
	
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
	*/
	@Transactional
	public boolean updateNewProjDate(LocalDate newProjDate, Integer id) {
		try {
			Project project= em.find(Project.class, id);
			project.setProjdate(newProjDate);
			project.setProjdate(newProjDate);
			em.merge(project);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
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
	*/
	
	@Transactional
	public boolean deleteById(Integer id) {
		try {
			Project project= em.find(Project.class, id);
			em.remove(project);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
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
	*/
    @Transactional
    public List<Project> selectAllProjects() {
        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Project> query = builder.createQuery(Project.class);
        Root<Project> root = query.from(Project.class);
        query.select(root);
        TypedQuery<Project> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }

 
    /*
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
	*/
    @Transactional
    public Project selectSingleProject(Long projectId) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Project> query = builder.createQuery(Project.class);
        Root<Project> root = query.from(Project.class);
        query.select(root).where(builder.equal(root.get("id"), projectId));
        TypedQuery<Project> typedQuery = em.createQuery(query);
        return typedQuery.getSingleResult();
    }

}
