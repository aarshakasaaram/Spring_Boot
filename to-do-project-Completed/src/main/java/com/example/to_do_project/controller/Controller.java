package com.example.to_do_project.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! what are you learning today?";
		
	}
	
	@RequestMapping("say-hello-html")
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first HTML page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html page with body");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
		
	}
	@RequestMapping("say-hello-jsp")
	
	public String sayHelloJsp() {
		return "sayHello";
		
	}
}
