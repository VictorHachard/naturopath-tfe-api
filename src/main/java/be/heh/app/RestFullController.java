package be.heh.app;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RestFullController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/user")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
