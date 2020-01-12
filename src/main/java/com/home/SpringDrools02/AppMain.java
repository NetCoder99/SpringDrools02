package com.home.SpringDrools02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.home.SpringDrools02.repositories"})
public class AppMain {

	public static void main(String[] args) {
		try {
			System.out.println("------ SpringDrools02 Started ------");

			SpringApplication.run(AppMain.class, args);

			System.out.println("------ SpringDrools02 Finished ------");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("------ SpringDrools02Failed ------");
		}

	}

}
