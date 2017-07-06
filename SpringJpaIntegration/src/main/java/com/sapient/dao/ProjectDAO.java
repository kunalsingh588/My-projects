package com.sapient.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Employee;
import com.sapient.entity.Project;
@Repository
public class ProjectDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public ProjectDAO() {
		
	}

	@Transactional
	public void addProject(Project project) {
		entityManager.persist(project);
	}

	public List<Project> getProjects(int projectId)
	{
		List<Project> result = null;
		Query query1 = entityManager.createQuery("from Project p");
		result = (List<Project>)query1.getResultList();
		return result;
	}

	public List<Employee> getEmployeesInProject(int projectId) {
		List<Employee> result = null;
		Query query1 = entityManager.createQuery("from Employee e where e.SAPIENT_ID IN (select SAPIENT_ID from EMPLOYEE_PROJECTS emp_pro where emp_pro.PROJECT_ID:=projectId)");
		query1.setParameter("projectId",projectId);
		result = (List<Employee>)query1.getResultList();
		return result;
	}
}
