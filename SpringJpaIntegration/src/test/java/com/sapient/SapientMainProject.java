package com.sapient;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.entity.Employee;
import com.sapient.entity.Project;
import com.sapient.service.EmployeeManager;
import com.sapient.service.ProjectManager;

public class SapientMainProject {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		ProjectManager projectManager = (ProjectManager) context.getBean("projectManager");
		EmployeeManager employeeManager = (EmployeeManager) context.getBean("employeeManager");
		
		Project project1=new Project(1,"Wellington");
		Project project2=new Project(2,"Enbridge");
		Project project3=new Project(3,"StateStreet");
		
		Set<Project> projectSet1 = new HashSet<Project>();
		projectSet1.add(project1);
		projectSet1.add(project2);	
		projectSet1.add(project3);
		
		Set<Project> projectSet2 = new HashSet<Project>();
		projectSet2.add(project1);
		projectSet2.add(project2);
		
		Set<Project> projectSet3 = new HashSet<Project>();
		projectSet3.add(project1);
		
		Employee emp1 = new Employee(1,"Raja",projectSet1);
		Employee emp2 = new Employee(2,"Charan",projectSet2);
		Employee emp3 = new Employee(3,"Fateh",projectSet3);
		
	
		projectManager.addProject(project1);
		projectManager.addProject(project2);
		projectManager.addProject(project3);
		
		
		
		employeeManager.addEmployee(emp1);
		employeeManager.addEmployee(emp2);
		employeeManager.addEmployee(emp3);
		
		Employee empfromDB =   employeeManager.getEmployeeDetails(1);
		System.out.println("Employee Found in Database ----");
		System.out.println(empfromDB.getEmployeeName());
		System.out.println("-------------------------------");
		System.out.println("  With following projects ----");
		
		Set<Project> projectsFromDB =   employeeManager.getProjects(1);
		for(Project project:projectsFromDB)
		{
			System.out.println(project.getProjectName());
			System.out.println("\n");
		}
		employeeManager.removeEmployee(3);
				
	}

}
