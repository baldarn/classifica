package eu.baldarn.classifica.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eu.baldarn.classifica.web.user.HomeController;

@Controller
public class LoginController {
	
	public final static String CONTROLLER_URL_ROOT = "/";
	public final static String CONTROLLER_URL = "/login";
	
	private final static String TEMPLATE = "login";
	
	@RequestMapping(value = CONTROLLER_URL_ROOT)
	public String root() throws Exception {
		return "redirect:" + HomeController.CONTROLLER_URL;
	}
	
	@RequestMapping(value = CONTROLLER_URL)
	public String login(@RequestParam(required = false) String error, Model model) throws Exception {
		model.addAttribute("error", error);
		return TEMPLATE;
	}
	
}
