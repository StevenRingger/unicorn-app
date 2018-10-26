package ch.unicorn.webContext.role;

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
import ch.unicorn.webContext.role.dto.RoleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity role.
 *
 */
@RestController
@RequestMapping("/roles")
@Api(value = "Role Controller", description = "This class holds all REST endpoints targeted towards the entity role", authorizations = {
		@Authorization(value = "predefined authorization scheme", scopes = {
				@AuthorizationScope(description = "description", scope = "predeclared scope") }) })
public class RoleController {

	private RoleService roleService;

	/**
	 *
	 */
	public RoleController() {
		super();
	}

	/**
	 * @param roleservice
	 */
	@Autowired
	public RoleController(RoleService roleservice) {
		roleService = roleservice;
	}

	/**
	 * This method returns the requested role
	 *
	 * @param id Id of the requested role
	 * @return ResponseEntity with the role that was requested
	 */
	@ApiOperation(value = "This endpoint returns the requested role", response = RoleDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested role", required = true) })
	@GetMapping("/{id}")
	public ResponseEntity<RoleDTO> getById(@PathVariable Long id) {
		Role role = roleService.findById(id);
		RoleDTO roleDTO = Mapper.instance().map(role, RoleDTO.class, RoleMapperPresets.ROLE_TO_ROLE_DTO);
		return new ResponseEntity<RoleDTO>(roleDTO, HttpStatus.OK);
	}

	/**
	 * This method returns all roles
	 *
	 * @return ResponseEntity with all existing roles
	 */
	@ApiOperation(value = "This endpoint returns all roles", response = RoleDTO.class)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<List<RoleDTO>> getAll() {
		List<Role> roles = roleService.findAll();
		ArrayList<RoleDTO> roleDTOs = Mapper.instance().mapAll(roles, RoleDTO.class, RoleMapperPresets.ROLE_TO_ROLE_DTO,
				ArrayList::new);
		return new ResponseEntity<>(roleDTOs, HttpStatus.OK);
	}

	/**
	 * This method creates an role
	 *
	 * @return ResponseEntity with the role that was created
	 */
	@ApiOperation(value = "This endpoint creates an role", response = RoleDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The role to be created", required = true) })
	@PostMapping({ "", "/" })
	public ResponseEntity<RoleDTO> create(@Valid @RequestBody RoleDTO roleDTO) {
		Role role = Mapper.instance().map(roleDTO, Role.class, RoleMapperPresets.ROLE_DTO_TO_ROLE);
		roleService.save(role);
		return new ResponseEntity<>(roleDTO, HttpStatus.CREATED);
	}

	/**
	 * This method updates the requested role
	 *
	 * @param id   Id of the role that should get updated
	 * @param role role entity to which the requested role should get updated to
	 * @return ResponseEntity with the updated role
	 */
	@ApiOperation(value = "This endpoint updates the requested role", response = RoleDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The logged in role", required = true) })
	@PutMapping("/{id}")
	public ResponseEntity<RoleDTO> updateById(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
		// TODO validate ids
		Role role = Mapper.instance().map(roleDTO, Role.class, RoleMapperPresets.ROLE_DTO_TO_ROLE);
		roleService.update(role);
		return new ResponseEntity<>(roleDTO, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested role
	 *
	 * @param id Id of the role that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(value = "This endpoint deletes the requested role", response = RoleDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested role", required = true) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		roleService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
