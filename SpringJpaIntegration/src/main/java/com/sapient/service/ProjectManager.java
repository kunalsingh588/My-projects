package com.sapient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.ProjectDAO;
import com.sapient.entity.Employee;
import com.sapient.entity.Project;

@Service
public class ProjectManager {
	
@Autowired
private ProjectDAO projectDao;

public void addProject(Project project)
{
	projectDao.addProject(project);
}
public List<Project> getProjects(int projectId)
{
	return projectDao.getProjects(projectId);
}
public List<Employee> getEmployeesInProject(int projectId)
{
	return projectDao.getEmployeesInProject(projectId);	
}
}
