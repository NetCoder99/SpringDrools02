package com.home.SpringDrools02.controllers;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.SpringDrools02.entities.Departments;
import com.home.SpringDrools02.entities.RtnMessage;
import com.home.SpringDrools02.repositories.DepartmentRepository;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;

	Integer factsFired;
	
	KieServices ks = KieServices.Factory.get();
	KieContainer kContainer = ks.getKieClasspathContainer();
	KieSession kSession = kContainer.newKieSession("ksession-rules");
	
	@RequestMapping("/version")
	public String greeting() {
		return "Version: " + "1.0.0";
	}

	@RequestMapping("/departments/get")
	public List<Departments> GetDepartments() {
		List<Departments> tmpList = (List<Departments>) departmentRepository.findAll();
		return tmpList;
	}

	@RequestMapping("/departments/validate")
	public List<RtnMessage> ValidateDepartments() {
		List<FactHandle> factsList = new ArrayList<FactHandle>();
		GetDepartments().forEach(rec -> {
			factsList.add(kSession.insert(rec));
		});
		factsFired = kSession.fireAllRules();
		
		List<RtnMessage> rtnList = new ArrayList<RtnMessage>();
		QueryResults results = kSession.getQueryResults( "getReturnMessages" ); 
		for ( QueryResultsRow row : results ) {
			RtnMessage rtnMsg = ( RtnMessage ) row.get( "$result" ); 
			rtnList.add(rtnMsg);
		}			
		
		factsList.forEach(rec -> {
			kSession.delete(rec);
		});
		factsFired = kSession.fireAllRules();
		
		
		return rtnList;
	}
}
