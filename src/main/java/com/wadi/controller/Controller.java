package com.wadi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wadi.entity.Student;

@RestController
@RequestMapping("/api/v1")
public class Controller {

	private static final List<Student> map = Arrays.asList
			(new Student(1, "wadi"),
			 new Student(2, "ahmed"),
			 new Student(3, "mojtaba")
			 );

	@GetMapping("/students/{studentId}")
	public Student getSudentId(@PathVariable(value="studentId") Integer studentId) {

		return map.stream().filter(student -> studentId.equals(student.getStudentId())).findFirst()
				.orElseThrow(() -> new IllegalStateException("Student" + studentId + "not found"));
	}

}
