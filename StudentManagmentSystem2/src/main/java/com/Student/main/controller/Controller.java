package com.Student.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Student.main.entities.Student;
import com.Student.main.services.StudentService;

import jakarta.websocket.server.PathParam;
import lombok.experimental.PackagePrivate;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/home")
	public String home() {
		return "home"; //go to view page html file -home.html
	}

	@GetMapping("/student")
	public String getAllStudents(Model model){
		model.addAttribute("student", service.getAllStudent());
		return "student";//view page 
		
	}
	@GetMapping("/student/new")
	public String createStudentForm(Model model) {
		Student students = new Student();
		model.addAttribute("students", students);
		
		return "create-student";
		
	}
	@PostMapping("/student")
	public String saveStudent(@ModelAttribute("students") Student students,
								RedirectAttributes redirectAttributes) {
		service.saveStudent(students);
		redirectAttributes.addFlashAttribute("success", true);
		return "redirect:/student/new";
		
	}
	@GetMapping("/student/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("students", service.getStudentyId(id));
		return "edit_student";
		
	}
	@PostMapping("/student/edit/{id}")
	public String updateStudent(@PathVariable int id ,@ModelAttribute("students") Student students,
			                    RedirectAttributes redirectAttributes) {
		Student existingstudent = service.getStudentyId(id);
		existingstudent.setFirstName(students.getFirstName());
		existingstudent.setLastName(students.getLastName());
		existingstudent.setEmail(students.getEmail());
		
		service.saveStudent(existingstudent);
		redirectAttributes.addFlashAttribute("success", true);
		return "redirect:/student/edit/" + id;

	}
	@GetMapping("/student/{id}")
	public String deletById(@PathVariable int id,
							 RedirectAttributes redirectAttributes) {
		service.deleteById(id);
		redirectAttributes.addFlashAttribute("deleteSuccess", true);
		return "redirect:/student";
		
	}
}
