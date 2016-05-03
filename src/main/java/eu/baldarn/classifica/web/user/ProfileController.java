package eu.baldarn.classifica.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eu.baldarn.classifica.model.User;
import eu.baldarn.classifica.model.dto.UserDto;
import eu.baldarn.classifica.repository.UserRepository;

@Controller
public class ProfileController {
	
	private final static String CONTROLLER_URL = "/admin/profile.html";
	private final static String ADD_USER = "/admin/addUser";
	private final static String DEL_USER = "/admin/delUser";

	
	private final static String TEMPLATE = "user/profile";
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = CONTROLLER_URL, method = RequestMethod.GET)
	public String profile(@RequestParam Long id, Model model) throws Exception {
		
		User user = userRepository.findById(id);
		model.addAttribute("user", user);
		return TEMPLATE;
	}
	
	@RequestMapping(value = CONTROLLER_URL, method = RequestMethod.POST)
	public String post(@ModelAttribute UserDto user) throws Exception {
		
		User userDb = userRepository.findById(user.getId());
		userDb.setUsername(user.getUsername());
		userRepository.save(userDb);
		
		return "redirect:" + HomeController.CONTROLLER_URL;
	}
	
	@RequestMapping(value = ADD_USER, method = RequestMethod.GET)
	public String addUser() throws Exception {
		
		User user = new User();
		userRepository.save(user);
		
		return "redirect:" + CONTROLLER_URL + "?id=" + user.getId();
	}
	
	@RequestMapping(value = DEL_USER, method = RequestMethod.GET)
	public String delUser(@RequestParam Long id) throws Exception {
		
		userRepository.delete(id);
		
		return "redirect:" + HomeController.CONTROLLER_URL;
	}

}
