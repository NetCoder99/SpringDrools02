package com.home.SpringDrools02.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATIONS", schema = "HR")
public class Locations {

	@Id
	public Integer LOCATION_ID;
	public String STREET_ADDRESS;
	public String POSTAL_CODE;
	public String CITY;
	public String STATE_PROVINCE;
	@Column(name="COUNTRY_ID", length=2, columnDefinition="CHAR")
	public String COUNTRY_ID;
	
	public Locations() {}	
	
	public Locations(Integer lOCATION_ID, String sTREET_ADDRESS, String pOSTAL_CODE, String cITY, String sTATE_PROVINCE,
			String cOUNTRY_ID) {
		super();
		LOCATION_ID = lOCATION_ID;
		STREET_ADDRESS = sTREET_ADDRESS;
		POSTAL_CODE = pOSTAL_CODE;
		CITY = cITY;
		STATE_PROVINCE = sTATE_PROVINCE;
		COUNTRY_ID = cOUNTRY_ID;
	}
	public Integer getLOCATION_ID() {
		return LOCATION_ID;
	}
	public void setLOCATION_ID(Integer lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}
	public String getSTREET_ADDRESS() {
		return STREET_ADDRESS;
	}
	public void setSTREET_ADDRESS(String sTREET_ADDRESS) {
		STREET_ADDRESS = sTREET_ADDRESS;
	}
	public String getPOSTAL_CODE() {
		return POSTAL_CODE;
	}
	public void setPOSTAL_CODE(String pOSTAL_CODE) {
		POSTAL_CODE = pOSTAL_CODE;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getSTATE_PROVINCE() {
		return STATE_PROVINCE;
	}
	public void setSTATE_PROVINCE(String sTATE_PROVINCE) {
		STATE_PROVINCE = sTATE_PROVINCE;
	}
	public String getCOUNTRY_ID() {
		return COUNTRY_ID;
	}
	public void setCOUNTRY_ID(String cOUNTRY_ID) {
		COUNTRY_ID = cOUNTRY_ID;
	}



}
