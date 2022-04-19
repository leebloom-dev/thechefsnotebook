package com.thechefsnotebook.thechefsnotebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThechefsnotebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThechefsnotebookApplication.class, args);
	}

}

/*
* @SpringBootApplication
* a convenience annotation that adds all of the following:
*
* @Configuration
* Tags the class as a source of bean definitions for the application context.
*
* @EnableAutoConfiguration
* Tells Spring Boot to start adding beans based on classpath settings,
* other beans, and various property settings. For example, if spring-webmvc
* is on the classpath, this annotation flags the application as a web
* application and activates key behaviors, such as setting up a
* DispatcherServlet.
*
* @ComponentScan
* Tells Spring to look for other components, configurations, and service in
* the com/thechefsnotebook package, letting it find the controllers.
*
* The main() method uses Spring Boot's SpringApplication.run() method
* to launch an application.*/
