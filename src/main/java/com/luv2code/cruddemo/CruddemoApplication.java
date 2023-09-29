package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.luv2code.cruddemo.entity.Student;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			deleteAllStudents(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO){
		Student tempStudent1 = new Student("Ahoy", "Yuhuy", "ahoyuhuy@gmail.com");
		Student tempStudent2= new Student("Abizhar", "Multazam", "abizharmultazam@gmail.com");
		Student tempStudent3 = new Student("Syuaib", "Bin Ismail", "syuaibinmail@gmail.com");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void findStudent(StudentDAO studentDAO){
		Student tempStudent = new Student("Yahoo", "Yohooo","yahoouhuy@gmail.com");
		studentDAO.save(tempStudent);
		int id = tempStudent.getId();
		System.out.println(id);
		System.out.println(studentDAO.findById(id));
	}

	private void findAll(StudentDAO studentDAO){
		List<Student> theStudents=studentDAO.findAll();

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudentByLastName(StudentDAO studentDAO){
		List<Student>  theStudents = studentDAO.findByLastName("Multazam");
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}


	private void updateStudent(StudentDAO studentDAO){
		int id = 1;
		Student myStudent = studentDAO.findById(id) ;
		myStudent.setFirstName("Anjing");
		studentDAO.update(myStudent);
		System.out.println(myStudent);
	}
	private void deleteStudent(StudentDAO studentDAO){
		int id = 5;
		studentDAO.delete(id);
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		int numRows = studentDAO.deleteAll();
		System.out.println(numRows);
	}

}
