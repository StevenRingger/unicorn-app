package ch.unicorn.user;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/users")
	public String getUsers() {
		return "users";
	}
	
	@GetMapping("/users/{userId}")
	public String getUser() {
		return "user";
	}
	
	@PostMapping("/users")
	public String registerUser() {
		return "success";
	}
	
	@PutMapping("/users")
	public String updateUser() {
		return "updated user";
	}
	
	@DeleteMapping("/customers/{userId}")
	public String deleteUser() {
		return "deleted user";
	}
}
