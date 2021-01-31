package be.heh.app.controller.rest;

import be.heh.app.model.entities.security.UserSecurity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/test/")
public class RestFullController {

	@GetMapping("/all")
	public List<String> allAccess() {
		List<String> l = new ArrayList<>();
		l.add("Public Content");
		return l;
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public List<String> userAccess() {

		UserSecurity userDetails =
				(UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<String> l = new ArrayList<>();
		l.add("User Content: " + userDetails.getUsername());
		return l;
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('OWNER')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('USER')")
	public String adminAccess() {
		return "Admin Board.";
	}

}
