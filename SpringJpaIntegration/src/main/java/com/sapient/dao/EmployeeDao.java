package com.sapient.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Employee;
import com.sapient.entity.Project;
@Repository
public class EmployeeDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	public Set<Project> getProjects(int sapientId) {
		
		Query hqlQuery = entityManager.createQuery("from Employee e where e.sapientId  = ?)");
		hqlQuery.setParameter(1, sapientId);
		Employee empResult = (Employee) hqlQuery.getSingleResult();
		return empResult.getProjects();
		
	}

	public Employee getEmployeeDetails(int sapientId) {
		Query query1 = entityManager.createQuery("from Employee e where e.sapientId = ?");
		query1.setParameter(1, sapientId);
		Employee emp=(Employee) query1.getSingleResult();
		return emp;
	}
	@Transactional
	public void removeEmployee(int sapientId) {
		Query query=entityManager.createQuery("delete from Employee e where e.sapientId = ?");
		query.setParameter(1, sapientId);
		query.executeUpdate();
	}

}
