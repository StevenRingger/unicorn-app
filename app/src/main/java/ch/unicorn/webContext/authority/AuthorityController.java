package ch.unicorn.webContext.authority;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.unicorn.config.mapping.Mapper;
import ch.unicorn.webContext.authority.dto.AuthorityDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity authority.
 *
 */
@RestController
@RequestMapping("/authorities")
@Api(value = "Authority Controller", description = "This class holds all REST endpoints targeted towards the entity authority", authorizations = {
		@Authorization(value = "predefined authorization scheme", scopes = {
				@AuthorizationScope(description = "description", scope = "predeclared scope") }) })
public class AuthorityController {

	private AuthorityService authorityService;

	/**
	 *
	 */
	public AuthorityController() {
	}

	/**
	 * This method handles the Validation
	 *
	 * @param dataBinder DataBinder binds data from the web request parameters to
	 *                   JavaBean objects
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// TODO Code body
		// dataBinder.addValidators(new AddressDTOValidator());
	}

	/**
	 * This method returns the requested authority
	 *
	 * @param id
	 * @return ResponseEntity with the Authority that was requested
	 */
	@ApiOperation(value = "This endpoint returns the requested authority", response = AuthorityDTO.class)
	@GetMapping("/{id}")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "Authority ID", required = true, dataType = "long") })
	public @ResponseBody ResponseEntity<AuthorityDTO> getById(@PathVariable long id) {
		Authority authority = authorityService.findById(id);
		AuthorityDTO authorityDTO = Mapper.instance().map(authority, AuthorityDTO.class,
				AuthorityMapperPresets.AUTHORITY_TO_AUTHORITY_DTO);
		return new ResponseEntity<AuthorityDTO>(authorityDTO, HttpStatus.OK);
	}

	/**
	 * This method returns all authorityes
	 *
	 * @return ResponseEntity with all existing authorities
	 */
	@ApiOperation(value = "This endpoint returns all authorities", response = AuthorityDTO.class)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<List<AuthorityDTO>> getAll() {
		List<Authority> authoritys = authorityService.findAll();
		ArrayList<AuthorityDTO> authorityDTOs = Mapper.instance().mapAll(authoritys, AuthorityDTO.class,
				AuthorityMapperPresets.AUTHORITY_TO_AUTHORITY_DTO, ArrayList::new);
		return new ResponseEntity<>(authorityDTOs, HttpStatus.OK);
	}

	/**
	 * This method creates an authority
	 *
	 * @param authority Authority entity which should be created
	 * @return ResponseEntity with the created Authority
	 */
	@ApiOperation(value = "This endpoint creates an authority", response = AuthorityDTO.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authorityDTO", value = "AuthorityDTO Object", required = true, dataType = "AuthorityDTO") })
	@PostMapping({ "", "/" })
	public @ResponseBody ResponseEntity<AuthorityDTO> create(@RequestBody AuthorityDTO authorityDTO) {
		Authority authority = Mapper.instance().map(authorityDTO, Authority.class,
				AuthorityMapperPresets.AUTHORITY_DTO_TO_AUTHORITY);
		authorityService.save(authority);
		return new ResponseEntity<>(authorityDTO, HttpStatus.CREATED);
	}

	/**
	 * This method updates the requested authority
	 *
	 * @param authority Authority entity which should get updated
	 * @return ResponseEntity with the HTTP Status
	 */
	@ApiOperation(value = "This endpoint updates the requested authority", response = Void.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authorityDTO", value = "AuthorityDTO Object", required = true, dataType = "AuthorityDTO") })
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<AuthorityDTO> updateById(@PathVariable long id, AuthorityDTO authorityDTO) {
		// TODO validate ids
		Authority authority = Mapper.instance().map(authorityDTO, Authority.class,
				AuthorityMapperPresets.AUTHORITY_DTO_TO_AUTHORITY);
		authorityService.update(authority);
		return new ResponseEntity<>(authorityDTO, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested authority
	 *
	 * @param id
	 * @return ResponseEntity with the HTTP Status
	 */
	@ApiOperation(value = "This endpoint deletes the requested authority", response = Void.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "Authority ID", required = true, dataType = "long") })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id) {
		authorityService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
