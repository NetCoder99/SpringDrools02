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
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import com.home.SpringDrools02.entities.Departments;
//import com.home.SpringDrools02.repositories.DepartmentRepository;
//
//@Component
//@Order(1)
//public class DepartmentRunner implements ApplicationRunner{
//
//	@Autowired
//	private DepartmentRepository departmentRepository;
//
//	Integer factsFired = 0;
//
//	public void run(ApplicationArguments arg0) throws Exception {
//		try {
//			System.out.println("------ DepartmentRunner Started ------");
//
//			List<FactHandle> factsList = new ArrayList<FactHandle>();
//			
//			KieServices ks = KieServices.Factory.get();
//			KieContainer kContainer = ks.getKieClasspathContainer();
//			KieSession kSession = kContainer.newKieSession("ksession-rules");
//
//			List<Departments> tmpList = (List<Departments>) departmentRepository.findAll();
//			//tmpList.sort(Comparator.comparing(Departments::getDEPARTMENT_ID));
//			tmpList.sort(Comparator.comparing(Departments::getDEPARTMENT_ID).reversed());
//			
//			tmpList.forEach(rec -> {
//				//System.out.println(rec.toString());
//				factsList.add(kSession.insert(rec));
//				factsFired += kSession.fireAllRules();
//			});
//			//factsFired = kSession.fireAllRules();
//
//			System.out.println("------ DepartmentRunner Finsihed: " + factsFired.toString() + "------");
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println("------ DepartmentRunner Failed ------");
//		}
//
//	}
//}
