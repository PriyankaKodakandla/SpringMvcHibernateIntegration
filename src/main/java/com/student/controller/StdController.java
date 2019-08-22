package com.student.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.Student;
import com.studnet.dao.StdDaoImp;

@Controller
public class StdController {
	@Autowired
	public StdDaoImp std;

	@RequestMapping("/add")
	public String add(@ModelAttribute("student") Student student, Model model) {
		int i = std.insertStd(student);
	    System.out.println(i);
		model.addAttribute("Student", student);
		return "display";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search_std(HttpServletRequest request) {
		// student=std.search(2);
		// System.out.println(student.getId());
		// System.out.println(student.getName());
		// model.addAttribute("Student", std.search(2));
		// return "display";
		int id = Integer.parseInt(request.getParameter("id"));
		ModelAndView mav = new ModelAndView("display");
		mav.addObject("student", std.search(id));
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete_std(@PathVariable int id) {
		// String id= (String) request.getAttribute("id");
		// int i=(Integer.parseInt(id));
		int i = std.delete(id);
		System.out.println(i);
		ModelAndView mav = new ModelAndView("Delete");
		return mav;
	}
	@RequestMapping(value = "/updateStudent/{id}")
	public ModelAndView updateStudent(@PathVariable int id,Model model) {
		Student student=std.getObject(id); 
		model.addAttribute("student", student);
		System.out.println("update student");
		ModelAndView mav = new ModelAndView("edit");
		return mav;
		
	}
	@RequestMapping(value = "/modify")
	public ModelAndView edit_std(HttpServletRequest req,
			@ModelAttribute("student") Student student) {
		System.out.println("edit contoller");
		int primary = Integer.parseInt(req.getParameter("id"));
		student.setId(primary);

		int i = std.modifyStd(student);
		System.out.println(i);
		ModelAndView mav = new ModelAndView("display");
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("success");
		mav.addObject("studdents", std.listAll());
		return mav;
	}

}
