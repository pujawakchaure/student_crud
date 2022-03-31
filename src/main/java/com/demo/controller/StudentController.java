package com.demo.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demo.bean.Student;
import com.demo.service.StudentService;

@Path("student")
public class StudentController {
	StudentService student=new StudentService();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Student> getStudent() {
		return student.getStudents();
	}
	
	
	@Path("insert")
	@POST
	public String insertData(Student d) {
		return student.createStudent(d);
	}
	
	
	@Path("update")
	@PUT
	public String updateData(Student s) {
		return student.updateStudent(s);
	}
	
	
	@Path("delete/{num}")
	@DELETE
	public String deleteData(@PathParam("num") int num) {
		 return student.deleteStudent(num);
	}
	
	
	@Path("search/{num}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@GET
	public Student getData(@PathParam("num") int num) {
		 return student.getStudent(num);
	}

}
