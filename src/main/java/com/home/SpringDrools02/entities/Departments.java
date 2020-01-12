package com.home.SpringDrools02.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Departments", schema = "HR")
public class Departments {

	@Id
	private Integer DEPARTMENT_ID;
	private String DEPARTMENT_NAME;
	private Integer MANAGER_ID;
	private Integer LOCATION_ID;

	@Transient
	private static Integer MaxNameLength = 30;
	
	@Override
	public String toString() {
		return String.format("%5s", this.DEPARTMENT_ID) 
				+ ":" 
		        +  String.format("%-" + MaxNameLength + "s", this.DEPARTMENT_NAME);
	}

	public Departments() {};
	
	public Departments(Integer dEPARTMENT_ID, String dEPARTMENT_NAME, Integer mANAGER_ID, Integer lOCATION_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
		DEPARTMENT_NAME = dEPARTMENT_NAME;
		MANAGER_ID = mANAGER_ID;
		LOCATION_ID = lOCATION_ID;
	}

	public Integer getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}

	public void setDEPARTMENT_ID(Integer dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}

	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}

	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}

	public Integer getMANAGER_ID() {
		return MANAGER_ID;
	}

	public void setMANAGER_ID(Integer mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}

	public Integer getLOCATION_ID() {
		return LOCATION_ID;
	}

	public void setLOCATION_ID(Integer lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}

}