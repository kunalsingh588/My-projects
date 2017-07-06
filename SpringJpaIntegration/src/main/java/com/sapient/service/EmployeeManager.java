package com.sapient.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.EmployeeDao;
import com.sapient.entity.Employee;
import com.sapient.entity.Project;
@Service
public class EmployeeManager {
	@Autowired
	private EmployeeDao employeeDao;

	public void addEmployee(Employee employee)
	{
		employeeDao.addEmployee(employee);
	}
	public Set<Project> getProjects(int sapientId)
	{
		return employeeDao.getProjects(sapientId);
	}
	public Employee getEmployeeDetails(int sapientId)
	{
		return employeeDao.getEmployeeDetails(sapientId);	
	}
	public void removeEmployee(int sapientId)
	{
		employeeDao.removeEmployee(sapientId);
	}
}
