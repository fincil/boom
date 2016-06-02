package com.fincil.boom.web.controller.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String main(HttpServletRequest request, Model model) {
		model.addAttribute("mainContent", "main");
		return "main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainContent(HttpServletRequest request, Model model) {
		return "mainContent";
	}
}
