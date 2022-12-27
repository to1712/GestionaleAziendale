package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ServletUtil {
	
	@RequestMapping(value = "/views/**", method = {RequestMethod.GET, RequestMethod.POST})
	public String templateHandler(HttpServletRequest request) {
		String resource = request.getRequestURI().substring("/views/".length());
		resource = resource.substring(0, resource.indexOf(".html"));
		return resource;
	}
	
}
