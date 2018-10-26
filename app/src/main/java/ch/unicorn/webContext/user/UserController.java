package ch.unicorn.webContext.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.unicorn.config.mapping.Mapper;
import ch.unicorn.webContext.user.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity user.
 *
 */
@RestController
@RequestMapping("/users")
@Api(value = "User Controller", description = "This class holds all REST endpoints targeted towards the entity user", authorizations = {
		@Authorization(value = "predefined authorization scheme", scopes = {
				@AuthorizationScope(description = "description", scope = "predeclared scope") }) })
public class UserController {

	private UserService userService;

	/**
	 *
	 */
	public UserController() {
		super();
	}

	/**
	 * @param userservice
	 */
	@Autowired
	public UserController(UserService userservice) {
		userService = userservice;
	}

	/**
	 * This method returns the requested user
	 *
	 * @param id Id of the requested user
	 * @return ResponseEntity with the user that was requested
	 */
	@ApiOperation(value = "This endpoint returns the requested user", response = UserDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested user", required = true) })
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
		User user = userService.findById(id);
		UserDTO userDTO = Mapper.instance().map(user, UserDTO.class, UserMapperPresets.USER_TO_USER_DTO);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	/**
	 * This method returns all users
	 *
	 * @return ResponseEntity with all existing users
	 */
	@ApiOperation(value = "This endpoint returns all users", response = UserDTO.class)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<List<UserDTO>> getAll() {
		List<User> users = userService.findAll();
		ArrayList<UserDTO> userDTOs = Mapper.instance().mapAll(users, UserDTO.class, UserMapperPresets.USER_TO_USER_DTO,
				ArrayList::new);
		return new ResponseEntity<>(userDTOs, HttpStatus.OK);
	}

	/**
	 * This method creates an user
	 *
	 * @return ResponseEntity with the user that was created
	 */
	@ApiOperation(value = "This endpoint creates an user", response = UserDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The user to be created", required = true) })
	@PostMapping({ "", "/" })
	public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDTO) {
		User user = Mapper.instance().map(userDTO, User.class, UserMapperPresets.USER_DTO_TO_USER);
		userService.save(user);
		return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
	}

	/**
	 * This method updates the requested user
	 *
	 * @param id   Id of the user that should get updated
	 * @param user user entity to which the requested user should get updated to
	 * @return ResponseEntity with the updated user
	 */
	@ApiOperation(value = "This endpoint updates the requested user", response = UserDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The logged in user", required = true) })
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateById(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		// TODO validate ids
		User user = Mapper.instance().map(userDTO, User.class, UserMapperPresets.USER_DTO_TO_USER);
		userService.update(user);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested user
	 *
	 * @param id Id of the user that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(value = "This endpoint deletes the requested user", response = UserDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested user", required = true) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
