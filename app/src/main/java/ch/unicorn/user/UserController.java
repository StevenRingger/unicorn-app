package ch.unicorn.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@CrossOrigin
	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("heinzer", "heinz", "Heinz", "Heinzer", "heinz"));
		users.add(new User("fredy", "fredy", "fredy", "fredy", "fredy"));
		return users;
	}
	
	@CrossOrigin
	@GetMapping("/users/{userId}")
	public User getUser() {
		return new User("heinzer", "heinz", "Heinz", "Heinzer", "heinz");
	}
	
	@CrossOrigin
	@PostMapping("/users")
	public String registerUser() {
		return "success";
	}
	
	@CrossOrigin
	@PutMapping("/users")
	public String updateUser() {
		return "updated user";
	}
	
	@CrossOrigin
	@DeleteMapping("/customers/{userId}")
	public String deleteUser() {
		return "deleted user";
	}
}
