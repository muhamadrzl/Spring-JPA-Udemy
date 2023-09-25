package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO, Integer id) {
		return runner -> {
			findById(studentDAO, 1);
		};
	}

	private void createStudent(StudentDAO studentDAO){
		Student tempStudent= new Student("Leo", "Yuhu", "leohuyu@gmail.com");
		studentDAO.save(tempStudent);
		System.out.println(tempStudent.getId());
	}

	private void findById(StudentDAO studentDAO){

		studentDAO.findById(id);
//		System.out.println();
	}
}