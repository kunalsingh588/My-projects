package com.sapient.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;



@Entity
public class Employee {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SAPIENT_ID")
	private int sapientId;

	@Version
	private long version;
	@Column(name = "EMP_NAME")
	private String employeeName;

	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.REMOVE)
	@JoinTable(name = "EMPLOYEE_PROJECTS", joinColumns = { @JoinColumn(name = "SAPIENT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PROJECT_ID") })
	private Set<Project> Project;

	public Employee() {
		super();
	}

	public int getSapientId() {
		return sapientId;
	}

	public void setSapientId(int sapientId) {
		this.sapientId = sapientId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Set<Project> getProjects() {
		return Project;
	}

	public void setProjects(Set<Project> Project) {
		this.Project = Project;
	}

	public Employee(int sapientId, String employeeName, Set<Project> Project) {
		super();
		this.sapientId = sapientId;
		this.employeeName = employeeName;
		this.Project = Project;
	}
}
