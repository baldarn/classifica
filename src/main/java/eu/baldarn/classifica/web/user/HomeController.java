package eu.baldarn.classifica.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eu.baldarn.classifica.model.User;
import eu.baldarn.classifica.repository.UserRepository;

@Controller
public class HomeController {
	
	public final static String CONTROLLER_URL = "/home";
	public final static String ADD_POINT = "/admin/addPoint";
	public final static String SUB_POINT = "/admin/subPoint";

	
	private final static String TEMPLATE = "user/home";
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = CONTROLLER_URL, method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		
		model.addAttribute("utenti", userRepository.findAllByOrderByPointsDesc());
		return TEMPLATE;
	}
	
	@RequestMapping(value = ADD_POINT, method = RequestMethod.GET)
	public String addPoint(@RequestParam Long id) throws Exception {
		
		User user = userRepository.findById(id);
		user.setPoints(user.getPoints() + 1);
		userRepository.save(user);
		
		return "redirect:" + CONTROLLER_URL;
	}
	
	@RequestMapping(value = SUB_POINT, method = RequestMethod.GET)
	public String subPoint(@RequestParam Long id) throws Exception {
		
		User user = userRepository.findById(id);
		user.setPoints(user.getPoints() - 1);
		userRepository.save(user);
		
		return "redirect:" + CONTROLLER_URL;
	}

}
