//package com.home.SpringDrools02.runners;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//import org.kie.api.KieServices;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//import org.kie.api.runtime.rule.FactHandle;
//import org.kie.api.runtime.rule.QueryResults;
//import org.kie.api.runtime.rule.QueryResultsRow;
//
//import com.home.SpringDrools02.entities.Departments;
//import com.home.SpringDrools02.entities.RtnMessage;
//
//
//public class DepartmentValidation {
//	Integer factsFired = 0;
//
//	public List<RtnMessage> RunAllRules(List<Departments> deptList) {
//		try {
//			System.out.println("------ DepartmentRunner Started ------");
//
//			List<FactHandle> factsList = new ArrayList<FactHandle>();
//			
//			KieServices ks = KieServices.Factory.get();
//			KieContainer kContainer = ks.getKieClasspathContainer();
//			KieSession kSession = kContainer.newKieSession("ksession-rules");
//			
//			deptList.forEach(rec -> {
//				factsList.add(kSession.insert(rec));
//				//factsFired += kSession.fireAllRules();
//			});
//			factsFired = kSession.fireAllRules();
//
//			List<RtnMessage> rtnList = new ArrayList<RtnMessage>();
//			QueryResults results = kSession.getQueryResults( "getReturnMessages" ); 
//			for ( QueryResultsRow row : results ) {
//				RtnMessage rtnMsg = ( RtnMessage ) row.get( "$result" ); //you can retrieve all the bounded variables here
//				rtnList.add(rtnMsg);
//			}			
//			
//			System.out.println("------ DepartmentValidation Finsihed: " + factsFired.toString() + "------");
//			
//			return rtnList;
//			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println("------ DepartmentValidation Failed ------");
//			return null;
//		}
//
//	}
//}
